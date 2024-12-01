package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id="email")
    WebElement emailIdBox;

    @FindBy(id="password")
    WebElement passwordBox;

    @FindBy(xpath="//button[@id='submitLoginBtn']")
     public WebElement loginSubmitBtn;

    @FindBy(id="message")
    WebElement loginErrorMessage;

public LoginPage(WebDriver driver)
{
    this.driver = driver;
    PageFactory.initElements(driver,this);
}

public void Login(String emailId, String password)
{
    emailIdBox.sendKeys(emailId);
    passwordBox.sendKeys(password);
    loginSubmitBtn.click();
}
public boolean isMessageDisplayed()
{
    return loginErrorMessage.isDisplayed();
}

}
