package firstseleniumcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ANZ_Calculator {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void monthlyRepaymentTester() {
        new CalculatorPage(new ChromeDriver()) //creates an instance of calculator landing page, with the returned driver object
            .loadPage().enterLoan("5000").enterYears(8).clickCalculate() //enters loan, year, clicks calculate
            .monthlyRepaymentMatches("$58"); //Assertion - ensures the monthly repayment amount matches whatevers entered, in this case $58.
    }

    @Test
    public void SliderTest() {
        new CalculatorPage(new ChromeDriver())
                .loadPage().enterLoan("5000").enterYears(2).clickCalculate()
                .sliderCanMove(); //moves the slider
    }

    @AfterEach
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

