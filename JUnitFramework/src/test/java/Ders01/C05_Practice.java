package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Facebook sayfasine gidin ve sayfa başlığını(title) facebook olduğunu doğrulayın
        //Sayfa başlığı doğru değilse başlığı yazdırın
        driver.get("https://www.facebook.com");

        if (driver.getTitle().contains("facebook")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Actual başlık : " + driver.getTitle());
        }

        //Sayfa URL'nin facebook kelimesi içerdiğini doğrulayın, içermiyorsa actual URL'i yazdırın
        if(driver.getCurrentUrl().contains("facebook")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Actual URL : " + driver.getCurrentUrl());
        }

        //"https://www.walmart.com/" sayfasına gidin

        driver.navigate().to("https://www.walmart.com/");

        //Tekrar facebook sayfasına dönün
        driver.navigate().back();

        //sayfayı yenileyin
        Thread.sleep(2000);
        driver.navigate().refresh();

        //sayfayı maksimize edin
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //browserı kapat
        driver.close();


    }
}



















