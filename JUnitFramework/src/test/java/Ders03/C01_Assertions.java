package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }


    @Test
    public void test1() {
        String actualURL= driver.getCurrentUrl();
        String expectedURL= "amazon";
        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @Test
    public void test2() {
        String actualTitle= driver.getTitle();
        String expectedTitle= "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test3() {
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test4() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "www.facebook.com";
        Assert.assertFalse(actualURL.contains(expectedURL));
    }
}





















