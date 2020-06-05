//Задание 3
//        1.Открыть oz.by
//        2.В правом верхнем углу нажать на кнопку"Оплата"
//        3.Переключиться на открывшееся окно оплаты
//        4.Нажать на кнопку"закрыть это окно".
package tSmirnova_hW_auto01.Oz_tasks_all;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OzTask3 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oz.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@class=\"top-panel__hnav__li top-panel__hnav__li_r\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> handles = driver.getWindowHandles();
        for (String s : handles) {
            driver.switchTo().window(s);
        }

        driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}