package hudTestAuto;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class testRegister {
//    Go to Etsy Join page and assert the Title.
//    Assert and enter email, first name and an invalid password.
//    Assert and click Register.
//    Assert the error message after click Register.
    public WebDriver driver = new HtmlUnitDriver();
    static Logger log = Logger.getLogger("com.gargoylesoftware");

    public void checkElementPresent(WebElement el, String elName) {
        assertTrue(el.isDisplayed(),"I can't find this element : " + elName);
    }

    @Test
    public void assertElements() {
        // disable display gargoylesoftware warnings
        log.setLevel(Level.OFF);
        driver.get("https://www.etsy.com/join");

        System.out.println("Title of the page is " + driver.getTitle());
        WebElement inputEmail = driver.findElement(By.id("join_neu_email_field"));
        WebElement inputName = driver.findElement(By.id("join_neu_first_name_field"));
        WebElement inputPwd = driver.findElement(By.id("join_neu_password_field"));
        WebElement registerBtn = driver.findElement(By.name("submit_attempt"));

        assertEquals("Join | Etsy", driver.getTitle(), "Page Title did not match.");
        checkElementPresent(inputEmail, "email");
        checkElementPresent(inputName, "first name");
        checkElementPresent(inputPwd, "password");
        checkElementPresent(registerBtn, "register button");
        System.out.println("Title, Email, First Name, Password and Register button elements found in the page.");
    }

    @Test
    public void assertEmailValidations () {
        log.setLevel(Level.OFF);
        driver.get("https://www.etsy.com/join");
        WebElement inputEmail = driver.findElement(By.id("join_neu_email_field"));
        WebElement inputName = driver.findElement(By.id("join_neu_first_name_field"));
        WebElement inputPwd = driver.findElement(By.id("join_neu_password_field"));
        WebElement registerBtn = driver.findElement(By.name("submit_attempt"));
        inputEmail.sendKeys("a");
        inputName.sendKeys("Alfonso Hicks");
        inputPwd.sendKeys("a");
        registerBtn.click();
        WebElement validPw = driver.findElement(By.id("aria-join_neu_email_field-error"));
        assertEquals("Please enter a valid email address.", validPw.getText(), "Validation message for email did not match.");
        System.out.println("Validations are available for email format.");
    }

    @Test
    public void assertNameValidations () {
        log.setLevel(Level.OFF);
        driver.get("https://www.etsy.com/join");
        WebElement inputEmail = driver.findElement(By.id("join_neu_email_field"));
        WebElement inputName = driver.findElement(By.id("join_neu_first_name_field"));
        WebElement inputPwd = driver.findElement(By.id("join_neu_password_field"));
        WebElement registerBtn = driver.findElement(By.name("submit_attempt"));
        inputEmail.sendKeys("abc@abc.com");
        inputName.sendKeys("Alfonso");
        inputPwd.sendKeys("a");
        inputName.clear();
        registerBtn.click();
        WebElement validPw = driver.findElement(By.id("aria-join_neu_first_name_field-error"));
        assertEquals("First name can't be blank.", validPw.getText(), "Validation message for blank first names did not match.");
        System.out.println("Validations are available for blank first name.");
    }

    @Test
    public void assertPwValidations () {
        log.setLevel(Level.OFF);
        driver.get("https://www.etsy.com/join");
        WebElement inputEmail = driver.findElement(By.id("join_neu_email_field"));
        WebElement inputName = driver.findElement(By.id("join_neu_first_name_field"));
        WebElement inputPwd = driver.findElement(By.id("join_neu_password_field"));
        WebElement registerBtn = driver.findElement(By.name("submit_attempt"));
        inputEmail.sendKeys("abc@abc.com");
        inputName.sendKeys("Alfonso Hicks");
        inputPwd.sendKeys("a");
        registerBtn.click();
        WebElement validPw = driver.findElement(By.id("aria-join_neu_password_field-error"));
        assertEquals("Must be at least 6 characters.", validPw.getText(), "Validation message for pwd did not match.");
        System.out.println("Validations are available for length of password.");
    }

}
