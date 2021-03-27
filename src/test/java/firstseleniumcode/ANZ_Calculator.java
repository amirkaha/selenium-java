package firstseleniumcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ANZ_Calculator {
    private WebDriver driver;

    @BeforeEach
   // public void initWebDriver() { driver = new ChromeDriver(); }


    @Test
    public void monthlyRepaymentTester() {
        new HomePage( new ChromeDriver()) //creates an instance of calculator landing page, with the returned driver object
            .loadPage().enterLoan("5000").enterYears(8).clickCalculate() //enters loan, year, clicks calculate
            .monthlyRepaymentMatches("$58"); //Assertion - ensures the monthly repayment amount matches whatevers entered, in this case $58.
    }

    @AfterEach
    public static void cleanUp() {
//        getDriver.manage().deleteAllCookies();
//        driver.close();

    }




}

