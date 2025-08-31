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

public class C05_Alerts {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement resultText = driver.findElement(By.xpath("//*[@id='result']"));
        String actualText = resultText.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        System.out.println("Alert Message : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expectedText = "successfuly";
        Assert.assertNotEquals(expectedText, actualText);



    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Emre");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

    }

}






















