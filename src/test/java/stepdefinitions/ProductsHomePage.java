package stepdefinitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsHomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='logout']")
    WebElement logoutBtn;

    public ProductsHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isLogoutBtnDisplayed() {
        boolean isBtnDisplayed = false;

        try {
            if(logoutBtn.isDisplayed()) {
                isBtnDisplayed = true;
            }
        } catch (NoSuchElementException|NullPointerException e) {
            isBtnDisplayed = false;
        }
        return isBtnDisplayed;
    }
}
