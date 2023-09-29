package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

  @FindBy(css = ".account")
  private List<WebElement> accountButton;
  
  protected final WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    // This call sets the WebElement fields.
    PageFactory.initElements(driver, this);
  }

  public boolean isLoggedIn(){
    return accountButton.size() != 0;
  }

}
