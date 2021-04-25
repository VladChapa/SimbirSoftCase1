import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LetterCountTest {
    public WebDriver driver;
    public ElementObject eo;


    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        eo = new ElementObject(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void checkLetter() {
        Integer count;
        driver.navigate().to("http://yandex.ru");
        eo.clickEnter();
        eo.sendLogin("Chapoid");
        eo.clickLoginEnter();
        eo.sendPass("24102014");
        eo.clickLoginEnter();
        eo.clickMailButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //все вкладки
        driver.switchTo().window(tabs.get(1)); //переход на новую вкладку

        count = eo.getCountLetters();
        eo.createLetter();
        eo.sendTo("Chapoid@yandex.ru");
        eo.sendTheme("Simbirsoft theme");
        eo.sendText("Найдено " + count + " писем/ьма");
        eo.clickSendButton();
        Assert.assertEquals(eo.getCountLetters(), count++);
    }

    @AfterClass
    public void after() {
        driver.close();
    }
}