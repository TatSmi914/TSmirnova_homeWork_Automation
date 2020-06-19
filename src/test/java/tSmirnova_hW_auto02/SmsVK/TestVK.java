package tSmirnova_hW_auto02.SmsVK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestVK {

    private WebDriver driver = new ChromeDriver();
    private static String EMAIL_USERNAME;
    private static String EMAIL_PASSWORD;

    @BeforeClass
    public void setUpData() {
        EMAIL_USERNAME = "";
        EMAIL_PASSWORD = "";
        System.out.println("User for email login is generated!");
    }

    @Test
    public void emailLoginTest() {
        driver.manage().window().maximize();
        driver.get("https://vk.com/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("index_login_form")));

        WebElement username = driver.findElement(By.id("index_email"));
        WebElement password = driver.findElement(By.id("index_pass"));
        WebElement inputBtn = driver.findElement(By.id("index_login_button"));

        username.sendKeys(EMAIL_USERNAME);
        password.sendKeys(EMAIL_PASSWORD);
        inputBtn.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("l_msg")));
        driver.findElement(By.id("l_msg")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"l_msg\"]/a/span/span[2]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui_rmenu_all\"]/span")));

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"im_dialogs_search\"]"));
        searchField.sendKeys("Natalia Lapshina");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"_im_dialog_link\"]")));

        driver.findElement(By.xpath("//span[@class=\"_im_dialog_link\"]")).click();
        //WebElement smsField = driver.findElement(By.xpath("//*[@id=\"im_editable0\"]"));
        WebElement smsField = driver.findElement(By.id("im_editable0"));
        smsField.sendKeys("message_1");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"im-send-btn im-chat-input--send _im_send im-send-btn_send\"]")));
        driver.findElement(By.xpath("//button[@class=\"im-send-btn im-chat-input--send _im_send im-send-btn_send\"]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() =\"message_1\"]")));
        WebElement expectedResult = driver.findElement(By.xpath("//div[text() =\"message_1\"]"));

        Assert.assertTrue(expectedResult.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}