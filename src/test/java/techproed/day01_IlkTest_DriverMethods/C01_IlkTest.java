package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        //Java uygulamarında system özelliklerini ayarlamak için setProperty methodu ile kullanırız.
        //setProperty methodu ile class'ımıza driver'ın fiziki yolunu belirtiniz.
        System.out.println(System.getProperty("chromeDriver"));
        //getProperty ile "Key" değerini girerek "value"ya ulaşabiliriz.
        WebDriver driver = new ChromeDriver();
        //ChromeDriver türünde yeni bir obje oluşturduk
        driver.get("https://techproeducation.com");//get() methodu ile String olarak girilen url'e gideriz

    }
}
