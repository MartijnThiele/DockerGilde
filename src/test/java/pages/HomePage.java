package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  
  @FindBy(css = "[title='Log in to your customer account']")
  private WebElement authenticationLink;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openAuthenticationPage() {
    authenticationLink.click();
  }

}
