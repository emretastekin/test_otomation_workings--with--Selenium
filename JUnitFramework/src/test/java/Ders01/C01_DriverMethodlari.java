package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) {
        //Chromedriver'i setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // --> WebDriver classından driver objesi(nesne) oluşturuldu.

        // "www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr/");

        // sayfayi maksimum boyuta getiriniz
        driver.manage().window().maximize();

        // sayfanin basligini yazdiriniz
        System.out.println("Sitenin Başlığı :" +driver.getTitle());

        // sayfanin URL adresini yazdiriniz
        System.out.println("Sayfa URL : " +driver.getCurrentUrl());

        /*
        sayfanin kaynak kodlarını yazdiriniz
        System.out.println("Sayfanın kaynak kodu : " +driver.getPageSource());
        */

        //Kaynak kodların içinde "Gateway" kelimesinin olduğunu test ediniz
        String actualData = driver.getPageSource();
        String expectedData = "Gateway";

        if (actualData.contains(expectedData)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        // sayfanin window handle kodunu yazdinirınız

        System.out.println("Window Handle : " + driver.getWindowHandle());

        // sayfayi kapatalim
        driver.close();

    }
}
