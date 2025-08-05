package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine gidiniz.
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add element butonuna basınız
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(1000);
        addElement.click();

        //Delete butonunun görünür olduğunu test ediniz
        WebElement deleteButon = driver.findElement(By.xpath("//*[text()='Delete']"));
        if(deleteButon.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }


        //Delete butonuna basınız
        Thread.sleep(1000);
        deleteButon.click();

        //Add/Remove Elements yazısının görünür olduğunu kontrol ediniz
        if(driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        //Browser kapatıldı
        Thread.sleep(2000);
        driver.close();



    }
}
