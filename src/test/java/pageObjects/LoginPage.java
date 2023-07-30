package pageObjects;

import static utils.CommonFunctions.click;
import static utils.CommonFunctions.typeText;
import static utils.CommonFunctions.verifyErrorMessage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static utils.CommonFunctions.findElement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class LoginPage {

    public static void enterEmail(String email) throws IOException, InvalidFormatException {
         typeText(email,findElement(1,0,1));
    }

    public static void enterPassWord(String password) {
        typeText(password, findElement(2,0,1));
    }

    public static void login() {
        click(findElement(3,0,1));
    }

    public static void logOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        click(findElement(4,0,1));
        click(findElement(5,0,1));
    }

    public static void inCorrectPwdUserNameMessageVerify() {

        verifyErrorMessage("Warning: No match for E-Mail Address and/or Password.", findElement(6,0,1));
    }



}
