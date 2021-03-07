package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ANZ_Calculator {
    static WebDriver driver;



    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");


    }

    @Test(testName = "Submit a WebForm")
    public static void submitForm() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://tools.anz.co.nz/home-loans/repayments-calculator");

        driver.findElement(By.id("LoanAmount")).sendKeys("1000"); //type incorrect amount

        driver.findElement(By.id("InterestRate")).click();

        Thread.sleep(1000);

        String expectedMessage = "Loan amount must be between $5,000 and $5,000,000";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"LoanAmount-error\"]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.findElement(By.id("LoanAmount")).clear();
        driver.findElement(By.id("LoanAmount")).sendKeys("50000"); // enter loan ammount
        driver.findElement(By.xpath("//*[@id=\"dd\"]/div[1]")).click(); //open View ANZ rates drop down
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dd\"]/div[2]/div/div[2]/ul/li[3]/a")).click(); //select 2.89% option

        driver.findElement(By.id("LoanLengthYears")).click(); //open length time drop down
        driver.findElement(By.xpath("//*[@id=\"LoanLengthYears\"]/option[1]")).click(); //select 1 year
        driver.findElement(By.xpath("//*[@id=\"calculatorInner\"]/form/fieldset/input[3]")).click(); //click calculate\

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-repayment")));
        String expectedAmount = "$4,232";
        String actualAmount = driver.findElement(By.id("js-repayment")).getText();
        Assert.assertEquals(actualAmount,expectedAmount);


        System.out.print(expectedAmount);
        System.out.print(actualAmount);
        Thread.sleep(4000);
    }

    @AfterSuite
    public static void cleanUp(){
      //  driver.manage().deleteAllCookies();
      //  driver.close();
    }




}

