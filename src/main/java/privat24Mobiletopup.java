import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class privat24Mobiletopup {

    @Test
    public void checkMobiletopup() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        By countryBtn = By.xpath("//button[@data-qa-node='phone-code']");
        By countryDropDownInput = By.xpath("//input[@placeholder='Пошук']");
        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        By sum = By.xpath("//input[@data-qa-node='amount']");
        By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By submitButton = By.xpath("//button[@data-qa-node='submit']");

//Fill the form
        driver.get("https://next.privat24.ua/mobile");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(countryBtn).click();
        driver.findElement(countryDropDownInput).sendKeys("+380");
        driver.findElement(countryBtn).click();
        driver.findElement(phoneNumber).sendKeys("993215702");
        driver.findElement(sum).sendKeys("300");
        driver.findElement(cardNumber).sendKeys("4263982640269299");
        driver.findElement(expDate).sendKeys("0223");
        driver.findElement(cvv).sendKeys("837");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(firstName).sendKeys("Sebastian");
        driver.findElement(lastName).sendKeys("Perreira");
        driver.findElement(submitButton).click();

//Сhecking
        By actualPhoneNumber = By.xpath("//*[@data-qa-node='details']");
        By actualCardNumber = By.xpath("//*[@data-qa-node='card']");
        By actualSum = By.xpath("(//*[@data-qa-node='amount'])[2]");

        Assert.assertEquals("Поповнення телефону. На номер +380993215702", driver.findElement(actualPhoneNumber).getText());
        Assert.assertEquals("4263 **** **** 9299", driver.findElement(actualCardNumber).getText());
        Assert.assertEquals("300 UAH", driver.findElement(actualSum).getText());
        driver.close();


    }

}
