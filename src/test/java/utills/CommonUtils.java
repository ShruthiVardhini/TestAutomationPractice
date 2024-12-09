package utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils extends QAPracticeUtils{

    public static WebDriver driver;

    public void navigateToLoginPage() {

        WebElement formsTab = driver.findElement(By.xpath("//a[@id='forms']"));
        System.out.println("formsTab located: " + formsTab);
        formsTab.click();
        WebElement loginSubTab = driver.findElement((By.xpath("//a[@id='login']")));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(loginSubTab)).click();
        //loginSubTab.click();
    }

    public void navigateToRegisterPage()
    {
        WebElement formsTab = driver.findElement(By.xpath("//a[@id='forms']"));
        formsTab.click();
        WebElement registerSubTab = driver.findElement((By.xpath("//a[@id='register']")));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(registerSubTab)).click();
        //registerSubTab.click();
    }

    public void navigateToRecoverPasswordPage()  {
        WebElement formsTab = driver.findElement(By.xpath("//a[@id='forms']"));
        formsTab.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        WebElement recoverPassSubTab = driver.findElement((By.xpath("//a[@id='recover-password']")));
        wait.until(ExpectedConditions.elementToBeClickable(recoverPassSubTab)).click();
        //recoverPassSubTab.click();
    }
}
