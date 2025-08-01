package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Navigatemethodlari {
    public static void main(String[] args) throws InterruptedException {
        // Chromedriver'ı setup ediniz.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // "www.amazon.com.tr" adresine gidiniz
        driver.navigate().to("https://www.amazon.com.tr");

        // google anasayfasına gidiniz
        driver.navigate().to("https://www.google.com");

        // Tekrar amazon sayfasına gidiniz.
        Thread.sleep(1000);
        driver.navigate().back();

        // Tekrar google sayfasına gidiniz.
        Thread.sleep(1000);
        driver.navigate().forward();

        // Sayfayi yenileyiniz
        Thread.sleep(1000);
        driver.navigate().refresh();

        // Sayfayi kapatiniz
        driver.quit();
    }
}
