package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Benzer özelliklere sahip webelement'ler için relative locator kullanabiliriz.
        Syntax;
        driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near()) gibi
        methodlar ile bener özelliklere sahip webelementleri locatini almadan o webelemente ulaşabiliriz.
         */
        //amazona gidelim
        driver.get("https://amazon.com");
        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));//-->//*[@*='text']
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bike altındaki elemente tıklayalım
        WebElement hybridBikes=driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        WebElement electricBike= driver.findElement(with(By.tagName("a")).below(hybridBikes));
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        completeBike.click();




    }
}
