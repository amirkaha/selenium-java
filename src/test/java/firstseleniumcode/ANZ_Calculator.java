package firstseleniumcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    private WebDriver driver;

    @BeforeEach
    public void initWebDriver() { driver = new ChromeDriver(); }


    @Test
    public void calculatorTest() {
        HomePage homepage = new HomePage(driver); //creates an instance of calculator landing page, with the returned driver object
        homepage.loadPage(); //loads page
        homepage.enterLoan("5000");  //enters the loan amount
        homepage.enterInterest("2.49%"); //enters the interest amount
        homepage.enterYears(5); //choose how many years
        homepage.clickCalculate(); //clicks calculate

        homepage.calculateEachYear(); //method that loops 30 times to try all year possibilities, and calculates




//        String expectedMessage = "Loan amount must be between $5,000 and $5,000,000";
//        String actualMessage = driver.findElement(By.xpath("//*[@id=\"LoanAmount-error\"]")).getText();
//        Assert.assertEquals(actualMessage,expectedMessage);

//        driver.findElement(By.id("LoanAmount")).clear();

//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-repayment")));
//        String expectedAmount = "$4,232";
//        String actualAmount = driver.findElement(By.id("js-repayment")).getText();
//        Assert.assertEquals(actualAmount,expectedAmount);


//        System.out.print(expectedAmount);
//        System.out.print(actualAmount);

    }

    @AfterEach
    public static void cleanUp(){
      //  driver.manage().deleteAllCookies();
      //  driver.close();
    }




}

