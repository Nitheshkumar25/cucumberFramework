package stepDefinitions;

import static pageObjects.LoginPage.enterEmail;
import static pageObjects.LoginPage.enterPassWord;
import static pageObjects.LoginPage.inCorrectPwdUserNameMessageVerify;
import static pageObjects.LoginPage.logOut;
import static pageObjects.LoginPage.login;
import static utils.CommonFunctions.verifyURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {
@Test
	@Given("user  is on Login Page")
	public void user_is_on_login_page() {

		verifyURL("account/login");
	}

	@When("User enters  Login Credentials username {string} password {string}")
	public void user_enters_login_credentials_username_password(String userName, String passWord) throws InterruptedException, IOException, InvalidFormatException {

		enterEmail(userName);
		enterPassWord(passWord);
		login();
		logOut();
	}

	@When("User enters  incorrect password {string} and correct userName {string}")
	public void user_enters_incorrect_password(String wrongPwd, String user) throws IOException, InvalidFormatException {
		enterEmail(user);
		enterPassWord(wrongPwd);
		login();

	}

	@When("User enters  incorrect username {string} and correct password {string}")
	public void user_enters_incorrect_userName(String wrongUser, String pwd) throws IOException, InvalidFormatException {
		enterEmail(wrongUser);
		enterPassWord(pwd);
		login();

	}

	@Then("user should get Error message")
	public void user_should_get_error_message() {
		
		inCorrectPwdUserNameMessageVerify();
	}

}

//static method cant be overRidden
//we cant achieve method chaining ,polymorphism
