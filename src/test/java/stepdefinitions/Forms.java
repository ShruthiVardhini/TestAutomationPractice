package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utills.CommonUtils;

public class Forms extends CommonUtils {

    LoginPage loginpage;
    ProductsHomePage productsHomePage;

    @Given("I am on the QA Practice website")
    public void i_am_on_the_qa_practice_website() {
        driver.get(QA_Practice_URL);
    }
    @When("I navigate to the login page from the forms tab")
    public void i_navigate_to_the_login_page_from_the_forms_tab() {

        navigateToLoginPage();
    }
    @When("I log in using {string} and {string}")
    public void i_log_in_using_and(String emailId, String password) {
         loginpage = new LoginPage(driver);
         loginpage.Login(emailId,password);
    }
    @Then("I should be landed on the home page")
    public void i_should_be_landed_on_the_home_page() {
        productsHomePage = new ProductsHomePage(driver);
        /*String acualResult = driver.findElement(By.xpath("//a[@id='logout']")).getText();
        String expectedResult = "Log Out";
        Assert.assertEquals(expectedResult,acualResult);*/
        boolean isBtnDisplayed = productsHomePage.isLogoutBtnDisplayed();
        Assert.assertTrue("Login unsuccessful",isBtnDisplayed);
        System.out.println("Logged In Successfully");
    }

    @Then("I must not be able to login and Bad credentials error should be thrown")
    public void iMustNotBeAbleToLoginAndBadCredentialsErrorShouldBeThrown()
    {
        productsHomePage = new ProductsHomePage(driver);
        boolean isBtnDisplayed = productsHomePage.isLogoutBtnDisplayed();
        Assert.assertFalse("Unexpectedly logged in",isBtnDisplayed);
        boolean isMessageDisp = loginpage.isMessageDisplayed();
        Assert.assertTrue("Message not displayed",isMessageDisp);
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        loginpage = new LoginPage(driver);
        loginpage.loginSubmitBtn.click();
    }
}
