package features;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utills.CommonUtils;

public class Hooks extends CommonUtils {

@Before
    public void initializeChrome()
{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
}

@After
    public void tearUp()
    {
        driver.close();
    }

}
