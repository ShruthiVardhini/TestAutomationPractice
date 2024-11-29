package stepdefinitions;

import features.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utills.CommonUtils;

public class Forms extends CommonUtils {

    LoginPage loginpage;

    @Given("I am on the QA Practice website")
    public void i_am_on_the_qa_practice_website() {
        driver.get(QA_Practice_URL);
    }
    @When("I navigate to the login page from the forms tab")
    public void i_navigate_to_the_login_page_from_the_forms_tab() throws InterruptedException {

        navigateToLoginPage();
    }
    @When("I log in using {string} and {string}")
    public void i_log_in_using_and(String emailId, String password) {
         loginpage = new LoginPage(driver);
         loginpage.Login(emailId,password);
    }
    @Then("I should be landed on the home page")
    public void i_should_be_landed_on_the_home_page() {

        String acualResult = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
        String expectedResult = "Home";
        Assert.assertEquals(expectedResult,acualResult);
    }
}
