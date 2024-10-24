package api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

import static constants.Constant.Credentials.*;
import static constants.Constant.PATHS_FOR_API.TAKE_TOKEN;
import static constants.Constant.URLs.AUTH_HOME_PAGE;

public class TokenFetcher {

    /**Получаем токен Bearer для авторизации на ресурсе */
    public static String getBearerToken() throws Exception {
        String encodedClientString = encodeClientCredentials();
        String urlParameters = prepareRequestBody();
        String response = sendPostRequest(encodedClientString, urlParameters);
        return extractBearerToken(response);
    }

    private static String encodeClientCredentials() {
        // Кодируем Client ID и Secret в base64
        String forEncoding = CLIENT_ID + ":" + CLIENT_SECRET;
        return Base64.getEncoder().encodeToString(forEncoding.getBytes());
    }

    private static String prepareRequestBody() {
        // Подготавливаем тело запроса
        return "grant_type=password&username=" + USER_NAME + "&password=" + PASSWORD;
    }

    private static String sendPostRequest(String encodedClientString, String urlParameters) throws Exception {
        // Создаем URL и соединение
        URL url = new URL(AUTH_HOME_PAGE+TAKE_TOKEN);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Basic " + encodedClientString);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);

        // Отправляем запрос
        try (OutputStream os = conn.getOutputStream()) {
            os.write(urlParameters.getBytes());
            os.flush();
        }

        // Получаем ответ
        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    private static String extractBearerToken(String response) {
        // Извлекаем токен из ответа
        String[] responseParts = response.split(",");
        for (String part : responseParts) {
            if (part.contains("access_token")) {
                return part.split(":")[1].replaceAll("\"", "");
            }
        }
        return null;
    }
}
