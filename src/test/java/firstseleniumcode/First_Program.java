package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public static void submitForm(){

        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.id("first-name")).sendKeys("Amir");
        driver.findElement(By.id("last-name")).sendKeys("Yousef");
        driver.findElement(By.linkText("Submit")).click();


    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }




}

