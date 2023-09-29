package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

public class LoginTest extends TestShopScenario {

    //will pass
    @Test
    public void validLoginTest() {

        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw2");
        Assert.assertTrue(authenticationPage.isLoggedIn(), "Expected account button was not found");
    }

    //will pass
    @Test
    public void wrongPasswordTest() {

        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw");
        Assert.assertFalse(authenticationPage.isLoggedIn(), "User was logged in dispite of wrong credentials");
    }

    //will fail
    @Test
    public void wrongUsernameTest() {

        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        homePage.openAuthenticationPage();
        authenticationPage.login("tester@test.com", "1qazxsw2");
        Assert.assertFalse(authenticationPage.isLoggedIn(), "User was logged in dispite of wrong credentials");
    }
}
