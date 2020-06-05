package tSmirnova_hW_auto01.Email_all;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Email {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mail.ru/");

        driver.findElement(By.xpath("//*[@id=\"mailbox:login\"]")).sendKeys("nick_name0193");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]")).sendKeys("nick0987");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div/a/span/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("div[data-type=\"to\"] input")).sendKeys("nick_name0193@mail.ru");
        driver.findElement(By.name("Subject")).sendKeys("My letter for me");

        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span")).click();
        driver.findElement(By.xpath("/html/body/div[16]/div/div/div[2]/button[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span/span")).click();

        driver.findElement(By.xpath("//*[@id=\"PH_logoutLink\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]")).sendKeys("nick0987");
        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("span.llc__subject.llc__subject_unread > span"));
        System.out.println(elements.get(0).getText().equals("My letter for me"));

        boolean testResult = elements.get(0).getText().equals("My letter for me");

        if(testResult){
            System.out.println("Letter can be read.");
        }else{
            System.out.println("Letter can't be read.");
        }

        driver.quit();

    }
}