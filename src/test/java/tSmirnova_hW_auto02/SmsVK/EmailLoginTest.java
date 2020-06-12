package tSmirnova_hW_auto02.SmsVK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailLoginTest {

    private WebDriver driver = new ChromeDriver();
    private static String EMAIL_USERNAME;
    private static String EMAIL_PASSWORD;

    @BeforeClass
    public void setUpData() {
        EMAIL_USERNAME = "test@test.com";
        EMAIL_PASSWORD = "12345";
        System.out.println("User for email login is generated!");
    }

    @Test
    public void emailLoginTest() {
        driver.manage().window().maximize();
        driver.get("https://mail.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("q")));
        WebElement username = driver.findElement(By.id("mailbox:login"));
        WebElement inputBtn = driver.findElement(By.xpath("//label[@id='mailbox:submit']/input"));

        username.sendKeys(EMAIL_USERNAME);
        inputBtn.click();

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox:password")));
        password.sendKeys(EMAIL_USERNAME);
        inputBtn.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}