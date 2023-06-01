package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdrıralım

        /*
        findelement ile bir webelemente ulaşabilirken,
        birden fazla webelement için findelements() methodu kullanılır.
        Bu webelementlerin sayısına ulaşmak için yada bu webelementlerin yazısını console'a yazdırabilmek
        için List<Webelement> LinklerListesi = driver.findElements(By.locator("locator değeri")) olarak kullanılır.
        Oluşturmuş olduğumuz Lis'i loop ile console'a yazdırabiliriz.
         */

        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayısı= "+ linklerListesi.size());

        /*
        for(WebElement w : linklerListesi){
            if(!w.getText().isEmpty()){

                System.out.println(w.getText());
            }
        }
        */
        //Lambda ile yazdıralım
        linklerListesi.forEach(w-> {if(!w.getText().isEmpty())
                                    {System.out.println(w.getText());}});



        //Shop deals in Electronics webElementinin yazısını yazdıralım
        System.out.println("**********************************************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazisi.getText());

        driver.close();





    }
}
