package utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils extends QAPracticeUtils{

    public static WebDriver driver;


    public void navigateToLoginPage() throws InterruptedException {

        WebElement formsTab = driver.findElement(By.xpath("//a[@id='forms']"));
        System.out.println("formsTab located: " + formsTab);
        formsTab.click();
        WebElement loginSubTab = driver.findElement((By.xpath("//a[@id='login']")));
        loginSubTab.click();
    }
}
