package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

  @FindBy(xpath = "//*[@id='login-form']//*[@type='email']")
  private WebElement emailTextfield;

  @FindBy(xpath = "//*[@name='password']")
  private WebElement passwordTextfield;

  @FindBy(id = "submit-login")
  private WebElement loginButton;

  @FindBy(css = "[data-link-action='display-register-form']")
  private WebElement registrationLink;

  public AuthenticationPage(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    emailTextfield.sendKeys(username);
    passwordTextfield.sendKeys(password);
    loginButton.click();
  }

  public void clickRegistrationLink(){
    registrationLink.click();
  }

}
