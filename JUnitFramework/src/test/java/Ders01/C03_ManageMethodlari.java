package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        // Chromedriver' i setup ediniz.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // "www.amazon.com.tr" adresine gidiniz.
        driver.get("https://www.amazon.com.tr/");

        // Sayfanin konumunu ve boyutlarini yazdiriniz
        System.out.println("Sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutu : " + driver.manage().window().getSize());

        // Sayfayı simge durumuna getiriniz
        driver.manage().window().minimize();

        // Simge durumunda 2 saniye bekleyip sayfayi maximize yapın
        Thread.sleep(2000);
        driver.manage().window().maximize();

        // Sayfayı fullscreen yapınız.
        Thread.sleep(1000);
        driver.manage().window().fullscreen();

        System.out.println("Sayfanın boyutu : " + driver.manage().window().getSize());

        // Sayfanın konumunu ve boyutunu ayarlanabilsin
        driver.manage().window().setPosition(new Point(20,20));
        driver.manage().window().setSize(new Dimension(800,200));

        System.out.println("Sayfanın boyutu : " + driver.manage().window().getSize());

        // Sayfayi kapatınız
        driver.close();


    }
}






























