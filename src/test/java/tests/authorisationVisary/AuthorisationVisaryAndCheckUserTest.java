package tests.authorisationVisary;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Credentials.PASSWORD;
import static constants.Constant.Credentials.USER_NAME;
import static constants.Constant.URLs.AUTH_HOME_PAGE;

public class AuthorisationVisaryAndCheckUserTest extends BaseTest {
    @Test
    public void authAndCheckTest () throws InterruptedException {
        basePage.open(AUTH_HOME_PAGE);
        authorizationVisary.clickLogin(USER_NAME, PASSWORD);
        Thread.sleep(2000);
        visaryHomePage.checkUser();
        Thread.sleep(2000);
        System.out.println("Тест автооризации - true");
    }


}
