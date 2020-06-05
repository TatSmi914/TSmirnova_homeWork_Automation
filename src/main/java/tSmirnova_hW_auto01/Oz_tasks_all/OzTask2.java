//Задание 2
//        1. Открыть oz.by
//        2. Проверить, что слева отображаются все фильтры (Продукты и деликатесы … Здоровье, медтехника).
//        3. Для хранения имен фильтров завести коллекцию (expectedResults)
//        4. Названия фильтров собрать в коллекцию (actualResults)
//        5. Сравнить две коллекции.

package tSmirnova_hW_auto01.Oz_tasks_all;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OzTask2 {

    public static void main(String[] args) {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Продукты, деликатесы");
        expectedResults.add("Книги");
        expectedResults.add("Косметика, парфюмерия");
        expectedResults.add("Дом, сад, зоотовары");
        expectedResults.add("Развлечения, творчество");
        expectedResults.add("Канцтовары, учёба");
        expectedResults.add("Сувениры, подарки");
        expectedResults.add("Детям и мамам");
        expectedResults.add("Туризм, отдых, спорт");
        expectedResults.add("Техника, электроника");
        expectedResults.add("Здоровье, медтехника");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oz.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> actualResults = driver.findElements(By.xpath("//li[@class=\"main-nav__list__li main-nav__list__li_wnav\"]"));

        int lists = 0;
        for (int i = 0; i < expectedResults.size(); i++) {
            if (expectedResults.get(i).equals(actualResults.get(i).getText())) {
                lists++;
            }
        }
        if (lists == expectedResults.size()) {
            System.out.println("Lists are coincided.");
        } else {
            System.out.println("Lists are NOT coincided.");
        }

        driver.quit();
    }
}