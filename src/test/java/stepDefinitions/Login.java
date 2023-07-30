package stepDefinitions;

import static pageObjects.LoginPage.enterEmail;
import static pageObjects.LoginPage.enterPassWord;
import static pageObjects.LoginPage.inCorrectPwdUserNameMessageVerify;
import static pageObjects.LoginPage.logOut;
import static pageObjects.LoginPage.login;
import static utils.CommonFunctions.setLog;
import static utils.CommonFunctions.verifyURL;
import static utils.Constants.LOG_PATH;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {

	@Given("user  is on Login Page")
	public void user_is_on_login_page() {

		verifyURL("account/login");
		PropertyConfigurator.configure(LOG_PATH);
		setLog(Login.class).info("url verified done");

	}

	@When("User enters  Login Credentials username {string} password {string}")
	public void user_enters_login_credentials_username_password(String userName, String passWord) throws InterruptedException, IOException, InvalidFormatException {

		enterEmail(userName);
		enterPassWord(passWord);
		login();
		logOut();
		setLog(Login.class).info("user logged in sc completed");
	}

	@When("User enters  incorrect password {string} and correct userName {string}")
	public void user_enters_incorrect_password(String wrongPwd, String user) throws IOException, InvalidFormatException {
		enterEmail(user);
		enterPassWord(wrongPwd);
		login();
		setLog(Login.class).info("user with wrong pwd  sc completed");
	}

	@When("User enters  incorrect username {string} and correct password {string}")
	public void user_enters_incorrect_userName(String wrongUser, String pwd) throws IOException, InvalidFormatException {
		enterEmail(wrongUser);
		enterPassWord(pwd);
		login();
		setLog(Login.class).info("user with wrong userName  sc completed");
	}

	@Then("user should get Error message")
	public void user_should_get_error_message() {
		
		inCorrectPwdUserNameMessageVerify();
		setLog(Login.class).info("Error message  verify completed");
	}

}

//static method cant be overRidden
//we cant achieve method chaining ,polymorphism
