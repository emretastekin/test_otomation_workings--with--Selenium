package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    WebDriver driver;
    @Before
    public void setUp() {
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
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement createNewButton = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createNewButton.click();
        WebElement firstName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        WebElement lastName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]"));
        WebElement email = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]"));
        WebElement password = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[7]"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement genderM = driver.findElement(By.xpath("(//*[@class='_58mt'])[2]"));
        WebElement genderF = driver.findElement(By.xpath("(//*[@class='_58mt'])[1]"));

        firstName.sendKeys("emre");
        lastName.sendKeys("tastekin");
        email.sendKeys("abc@gmail.com");
        password.sendKeys("123456");
        day.sendKeys("6");
        month.sendKeys("Nis");
        year.sendKeys("2002");

        if(!genderM.isSelected()){
            genderM.click();
        }

        Thread.sleep(1000);
        genderF.click();
    }













}
