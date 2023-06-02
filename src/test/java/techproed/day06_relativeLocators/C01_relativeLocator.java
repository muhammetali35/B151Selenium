package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_relativeLocator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //amazona gidelim
        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));//-->//*[@*='text']
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bike altındaki elemente tıklayalım
        //Webelementlerin yazısını konsola yazdıralım
        WebElement hybridBikes=driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBikes.getText());
        WebElement electricBike= driver.findElement(with(By.tagName("a")).below(hybridBikes));
        System.out.println(electricBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        System.out.println(completeBike.getText());

        //Bikes altındaki tüm linkleri(webelementleri) konsola yazdıralım
        List<WebElement> linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));

        /*
        XPath kullanımında bir sayfadaki  webelementlere mğdahale etmek istediğimizde wpath ile locate aldığımızda
        birden fazla sonuç verebilir.[position()>=10 and position()<=16] bu kullanımla aralık belirterek istediğimiz
        werileri seçip müdahale edebiliriz.
         */
        //Lambda ile yazdırdık
        linlkerListesi.forEach(t-> System.out.println(t.getText()));

        //foreach  ile yazdırdık
        for (WebElement w : linlkerListesi) {
            System.out.println(w.getText());
        }
        System.out.println("----------------------------------------------------------------");

        //Bu linklerin hepsini tıklayalım ve sayfa başlıklarını alalım
        for (int i = 0; i < linlkerListesi.size(); i++) {
            linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));
            System.out.println(linlkerListesi.get(i).getText());
            linlkerListesi.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);


        }






    }
}
