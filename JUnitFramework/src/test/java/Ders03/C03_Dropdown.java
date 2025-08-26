package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void dropdowntest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddmList= driver.findElement(By.cssSelector("#dropdown"));
        Thread.sleep(2000);
        Select select= new Select(ddmList);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        List<WebElement> tumddm= driver.findElements(By.xpath("//option"));
        for (WebElement w:tumddm) {
            System.out.println(w.getText());
        }

        System.out.println("Dropdown eleman sayısı = " + tumddm.size() );
        if(tumddm.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }


}
