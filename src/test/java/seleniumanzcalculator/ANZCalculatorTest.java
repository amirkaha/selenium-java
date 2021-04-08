package seleniumanzcalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ANZCalculatorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void monthlyRepaymentShortTerm() {
        new CalculatorPage(driver) //creates an instance of calculator landing page, with the returned driver object
            .loadPage().enterLoan("5000").enterYears(8).clickCalculate() //enters loan, year, clicks calculate
            .monthlyRepaymentMatches("$58"); //Assertion - ensures the monthly repayment amount matches whatevers entered, in this case $58.
    }

    @Test
    public void monthlyRepaymentLongTerm () {
        new CalculatorPage(driver)
                .loadPage().enterLoan("200000").enterYears(30).clickCalculate()
                .monthlyRepaymentMatches("$831");
    }

    @Test
    public void sliderTest() {
        new CalculatorPage(driver)
                .loadPage().enterLoan("5000").enterYears(2).clickCalculate().sliderCanMove()
                .newInterestRateMatches("$97");
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

