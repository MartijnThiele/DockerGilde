package tests;

import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestShopScenario {

    @Test
    public void validLoginTest() {
        HomePage homePage = new HomePage(this.driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw2");
        assertTrue(authenticationPage.isLoggedIn(), "Expected account button was not found");
    }

    @Test
    public void wrongPasswordTest() {
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw");
        assertFalse(authenticationPage.isLoggedIn(), "User was logged in dispite of wrong password");
    }

    @Test
    public void wrongUsernameTest() {
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw2");
        assertFalse(authenticationPage.isLoggedIn(), "User was logged in dispite of wrong username");
    }
}