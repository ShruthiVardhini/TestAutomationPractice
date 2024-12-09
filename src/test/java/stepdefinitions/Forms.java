package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utills.CommonUtils;
import java.util.Map;

public class Forms extends CommonUtils {

    LoginPage loginpage;
    ProductsHomePage productsHomePage;
    RegisterPage registerPage;
    RecoverPasswordPage recoverPasswordPage;
    private String email;

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

    @When("I navigate to the register page from forms tab")
    public void iNavigateToTheRegisterPageFromFormsTab() {

        navigateToRegisterPage();
    }

    @Then("I fill all the fields and click on register button which displays a success message")
    public void iFillAllTheFieldsAndClickOnRegisterButtonWhichDisplaysASuccessMessage(DataTable userInfo) {

        Map<String, String> userData = userInfo.asMaps().get(0);
        registerPage = new RegisterPage(driver);

        registerPage.setFirstNameBox(userData.get("firstname"));
        registerPage.setLastNameBox(userData.get("lastname"));
        registerPage.setPhoneBox(userData.get("phone"));
        registerPage.setCountriesDropDown();
        registerPage.setEmailBox(userData.get("email"));
        registerPage.setPasswordBox(userData.get("password"));
        registerPage.setiAgreeCheckBox();
        registerPage.clickRegisterBtn();
        registerPage.check_Resgisteration_Succuss_Message();

    }


    @When("I fill all the fields except email and password and click register")
    public void iFillAllTheFieldsExceptEmailAndPasswordAndClickRegister(DataTable userInfo) {
        Map<String, String> userData = userInfo.asMaps().get(0);
        registerPage = new RegisterPage(driver);

        registerPage.setFirstNameBox(userData.get("firstname"));
        registerPage.setLastNameBox(userData.get("lastname"));
        registerPage.setPhoneBox(userData.get("phone"));
        registerPage.setCountriesDropDown();
        registerPage.setiAgreeCheckBox();
        registerPage.clickRegisterBtn();


    }

    @Then("the success message should not be displayed")
    public void theSuccessMessageShouldNotBeDisplayed() {

        registerPage.isRegisterMessageDisplayed();
    }

    @When("I fill all the mandatory fields and click on register button")
    public void iFillAllTheMandatoryFieldsAndClickOnRegisterButton(DataTable userInfo) {

        Map<String, String> userData = userInfo.asMaps().get(0);
        registerPage = new RegisterPage(driver);


        registerPage.setEmailBox(userData.get("email"));
        registerPage.setPasswordBox(userData.get("password"));
        registerPage.clickRegisterBtn();
    }

    @Then("I should see the success message")
    public void iShouldSeeTheSuccessMessage() {
        registerPage.check_Resgisteration_Succuss_Message();
    }

    @When("I navigate to the recover password page")
    public void iNavigateToTheRecoverPasswordPage()  {
        navigateToRecoverPasswordPage();
    }


    @When("I fill the email field with {string} and click on recover password button")
    public void i_fill_the_email_field_with_and_click_on_recover_password_button(String email) {
        this.email = email;
        recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.setEmailBox(email);
        recoverPasswordPage.clickRecoverPassBtn();
    }

    @Then("I should get a message redirecting to fetch the new password from the mailId given.")
    public void iShouldGetAMessageRedirectingToFetchTheNewPasswordFromTheMailIdGiven() {
        recoverPasswordPage.isRecoverPassMessageDisplayed(email);
    }

    @When("I click on recover password button")
    public void iClickOnRecoverPasswordButton() {
        recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickRecoverPassBtn();

    }

    @Then("I should not see the recover password email trigger message")
    public void iShouldNotSeeTheRecoverPasswordEmailTriggerMessage() {
        recoverPasswordPage.isRecoverPassMessageNotDisplayed();
    }
}
