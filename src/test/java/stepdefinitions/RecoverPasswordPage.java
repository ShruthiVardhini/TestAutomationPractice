package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailBox;

    @FindBy(xpath = "//button[@id='recover-password']")
    WebElement recoverPassBtn;

    @FindBy(xpath = "//div[@id='message']")
    WebElement recoverPassMessage;

    public RecoverPasswordPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmailBox(String email)
    {
        emailBox.sendKeys(email);
    }

    public void clickRecoverPassBtn()
    {
        recoverPassBtn.click();
    }

    public void isRecoverPassMessageDisplayed(String email) {
        String expectedMessage = "An email with the new password has been sent to " + email + ". Please verify your inbox!";
        String actualMessage = recoverPassMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public void isRecoverPassMessageNotDisplayed()
    {
        Assert.assertFalse("The Recover password email trigger message is displayed unexpectedly",recoverPassMessage.isDisplayed());
    }

}

