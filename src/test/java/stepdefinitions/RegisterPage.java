package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneBox;

    @FindBy(xpath = "//select[@id='countries_dropdown_menu']")
    WebElement countriesDropDown;

    @FindBy(xpath = "//option[contains(text(),'Afghanistan')]")
    WebElement afghanistan;

    @FindBy(xpath = "//input[@id='emailAddress']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@id='exampleCheck1']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//button[@id='registerBtn']")
    WebElement registerBtn;

    @FindBy(xpath = "//div[@id='message']")
    WebElement registerMessage;


    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void setFirstNameBox(String firstName)
    {
        firstNameBox.sendKeys(firstName);
    }

    public void setLastNameBox(String lastName)
    {
        lastNameBox.sendKeys(lastName);
    }

    public void setPhoneBox(String phone)
    {
        phoneBox.sendKeys(phone);
    }

    public void setCountriesDropDown()
    {
        countriesDropDown.click();
        afghanistan.click();
    }

    public void setEmailBox(String email)
    {
        emailBox.sendKeys(email);
    }

    public void setPasswordBox(String password)
    {
        passwordBox.sendKeys(password);
    }

    public void setiAgreeCheckBox()
    {
        iAgreeCheckBox.click();
    }

    public void clickRegisterBtn()
    {
        registerBtn.click();
    }

    public void check_Resgisteration_Succuss_Message()
    {
        String expectedMessage = "The account has been successfully created!";
        String actualMessage = registerMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    public void isRegisterMessageDisplayed()
    {
        Assert.assertFalse("The registration success message is being displayed unexpectedly.",registerMessage.isDisplayed());
    }
}
