package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class First_Program {
    static WebDriver driver;



    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");


    }

    @Test(testName = "Submit a WebForm")
    public static void submitForm() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://portal.foodstuffs-exchange.co.nz");

        //driver.findElement(By.id("first-name")).sendKeys("Amir");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[2]/span/div/div/div/div/div/div/div/div/div/div[1]/div/input")).sendKeys("essam@ggfoods.co.nz");
        driver.findElement(By.xpath("//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/div[2]/span/div/div/div/div/div/div/div/div/div/div[2]/div/div/input")).sendKeys("0200Esna");

        driver.findElement(By.xpath("//*[@id=\"auth0-lock-container-1\"]/div/div[2]/form/div/div/button")).click();


        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"menu\"]/div/div[2]/div/div[2]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"0f8128a1-107d-168d-42ac-c75911fb65de\"]")).click();
       // driver.findELement(By.xpath("//*[@id=\"f6b22891-5498-99ef-6c8f-90542e3f70f2\"]/td[5]")
    }

    @AfterSuite
    public static void cleanUp(){
      //  driver.manage().deleteAllCookies();
      //  driver.close();
    }




}

