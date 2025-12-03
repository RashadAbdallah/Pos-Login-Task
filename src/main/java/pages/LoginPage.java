package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;


    By log_in_label = By.id("newland.raya.aman:id/textView");
    By mobile_number_textbox = By.id("newland.raya.aman:id/mob_num_login_pos_et");
    By log_in_button = By.id("newland.raya.aman:id/login_pos_btn");
    By pas_label = By.id("newland.raya.aman:id/textView3");
    By pass_textbox  = By.id("newland.raya.aman:id/pass_login_pos_et");
    By pass_button  = By.id("newland.raya.aman:id/login_pos_btn");
    By main_page_label = By.id("newland.raya.aman:id/home_services_txt");


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void performLogin(String user, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// STEP 1: Login Page Verification
        String loginLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(log_in_label)).getText();
        Assert.assertEquals(loginLabel, "تسجيل الدخول");

// STEP 2: Mobile Section
        var mobile_field = wait.until(ExpectedConditions.visibilityOfElementLocated(mobile_number_textbox));
        mobile_field.click();
        mobile_field.clear();
        mobile_field.sendKeys(user);
        driver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(log_in_button)).click();

// STEP 3: Password Section
        String passLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(pas_label)).getText();
        Assert.assertEquals(passLabel, "الرقم السرى");

        var pass_field = wait.until(ExpectedConditions.visibilityOfElementLocated(pass_textbox));
        pass_field.click();
        pass_field.clear();
        pass_field.sendKeys(pass);
        driver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(pass_button)).click();

// STEP 4: Main Page Verification
        String mainPageLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(main_page_label)).getText();
        Assert.assertEquals(mainPageLabel, "خدمات الدفع");
    }
}