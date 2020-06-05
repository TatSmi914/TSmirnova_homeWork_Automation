//Задание 1
//        1. Открыть oz.by
//        2. Зайти в корзину
//        3. Проверить, что она пустая
//        4. Вернуться назад
//        5. В поиске ввести "Программирование"
//        6. Открыть первый результат
//        7. Добавить его в корзину
//        8. Зайти в корзину и проверить, что товар добавился.


package tSmirnova_hW_auto01.Oz_tasks_all;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OzTask1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oz.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class=\"top-panel__userbar__li top-panel__userbar__cart\"]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (driver.findElement(By.xpath("//div[@class=\"i-textual__plain i-textual__plain_arrow i-textual__plain_limited\"]")).isDisplayed()) {
            System.out.println("Bascket is empty");
        } else {
            System.out.println("Bascket is NOT empty");
        }

        driver.navigate().back();

        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"top-panel__search__input ui-autocomplete-input\"]"));
        searchField.sendKeys("Программирование");
        searchField.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> bookResults = driver.findElements(By.xpath("//a[@class=\"needsclick item-type-card__link item-type-card__link--main\"]"));
        bookResults.get(0).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@class=\"i-button__text\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@class=\"top-panel__userbar__li top-panel__userbar__cart\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().refresh();

        if (driver.findElement(By.xpath("//a[@href=\"https://oz.by/books/more10883310.html\"]")).isDisplayed()) {
            System.out.println("Book is added");
        } else {
            System.out.println("Book is NOT added");
        }

        driver.quit();
    }
}