package pages.AuthorizationVisary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class AuthorizationVisary extends BasePage {

    public AuthorizationVisary(WebDriver driver) {
        super(driver);
    }

    private final By userName = By.cssSelector("#app > div > div.va-layout__main > div > div.va-layout__view > div > div > div > div.va-login-box__form > form > div:nth-child(3) > div > div.va-base-input.va-base-input--with-icon > input");
    private final By userPassword = By.cssSelector("#app > div > div.va-layout__main > div > div.va-layout__view > div > div > div > div.va-login-box__form > form > div:nth-child(4) > div > div.va-base-input.va-base-input--with-icon > input");
    private final By buttonLogin = By.cssSelector(".va-base-button.va-base-button--full");


    public AuthorizationVisary clickLogin(String username, String password) {

        // Вводим логин и пароль
        WebElement usernameField = driver.findElement(userName);
        WebElement passwordField = driver.findElement(userPassword);
        WebElement submitButton = driver.findElement(buttonLogin);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        return this;
    }

}
