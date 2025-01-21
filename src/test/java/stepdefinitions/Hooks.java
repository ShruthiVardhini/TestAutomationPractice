package stepdefinitions;

import utills.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends CommonUtils {

@Before // Executes before every scenario
    public void initializeChrome()
{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
}

@After// Executes after every scenario
    public void tearUp()
    {
        driver.close();
    }

}
