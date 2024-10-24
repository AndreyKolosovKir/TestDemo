package pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;


import static common.Config.COUNT_OF_CLICKS;
import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) { //открытие окна по url
        driver.get(url);
    }

    //явное ожидание
    public WebElement waitElementIsVisible(WebElement element) {//ожидание видимости элемента
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public String addNumberForTitle(String name) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDteTime = localDateTime.format(formatter);

        return (name + formattedDteTime);
    }

    //метоод с явным ожиданием элемента и при необходимосчти повторяющий попытку клика
    public void waitElementIsVisibleAndClickRetry(By locator) {
        int attempts = 0; //счетчик попытоок
        boolean elementClicked = false;

        while (attempts < COUNT_OF_CLICKS && !elementClicked) {
            try {
                WebElement element = driver.findElement(locator); // Ищем элемент заново
                waitElementIsVisible(element);
                element.click();
                elementClicked = true;
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("StaleElementReferenceException, пытаемся заново: " + attempts);
            } catch (NoSuchElementException e) {
                System.out.println("Element не найден: " + locator);
                break;
            }
        }

        if (!elementClicked) {
            throw new RuntimeException("Не удалось нажать на элемент после " + COUNT_OF_CLICKS + " попыток: " + locator);
        }
    }


    //проверка скачивания файла
    public String searchLastDownloadedFile(String downloadFilePath, String fileName) {
        File directory = new File(downloadFilePath);
        File[] filesList = directory.listFiles();

        if (filesList != null && filesList.length > 0) {
            File[] filteredFiles = Arrays.stream(filesList)
                    .filter(file -> file.isFile() && file.getName().contains(fileName))
                    .sorted(Comparator.comparingLong(File::lastModified).reversed()) // Сортируем по дате модификации
                    .toArray(File[]::new);

            if (filteredFiles.length > 0) {
                // Получаем последний загруженный файл, который соответствует условиям
                File lastDownloadedFile = filteredFiles[0];
                return ("Последний загруженный файл: " + lastDownloadedFile.getName());
            } else {
                return ("Файл с частичным именем '" + fileName + "' не найден.");
            }
        } else {
            return ("Директория пуста или путь неверный.");
        }
    }
}
