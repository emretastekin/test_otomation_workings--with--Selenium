package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPractice {
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
    public void amazonTest() {
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div[2]/div/span[2]/span/span/input")).click();
        List<WebElement> ddm = driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());

        for (WebElement w:ddm
             ) {
            System.out.println(w.getText());
        }

        int actualDropDown = ddm.size();
        int expectedDropDown = 40;

        Assert.assertNotEquals(expectedDropDown, actualDropDown);

        WebElement ddmList = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select= new Select(ddmList);
        select.selectByVisibleText("Kitaplar");


        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);

        WebElement searchButton = driver.findElement(By.xpath("//*[@class='nav-search-submit nav-sprite']"));
        searchButton.click();

        WebElement sonucText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-none s-breadcrumb-with-all-filters sf-breadcrumb-all-filters-button-container']"));
        System.out.println(sonucText.getText());

        String actualText = sonucText.getText();
        String expectedText = "Java";
        Assert.assertTrue(actualText.contains(expectedText));
    }

}
























