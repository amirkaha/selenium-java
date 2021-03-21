package firstseleniumcode;

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
    static WebDriver driver;



    @BeforeEach
    public static void initWebDriver() { driver = new ChromeDriver();

    }

    @Test
    public static void calculatorTest() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.loadPage();
        homepage.enterLoan("5000");
        homepage.enterInterest("2.49%");
        homepage.enterYears(5);
        homepage.clickCalculate();
        Thread.sleep(1000);

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
        Thread.sleep(4000);
    }

    @AfterSuite
    public static void cleanUp(){
      //  driver.manage().deleteAllCookies();
      //  driver.close();
    }




}

