package seleniumanzcalculator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

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
    public void recordFailure(ITestResult result) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter ("src/main/resources/reports/" + result.getName() + ".html");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest logger = extentReports.createTest(result.getName());


        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            logger.log(Status.FAIL,  result.getName() + " test has failed");

            try {
                Files.move(screenshot, new File("src/main/resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            logger.log(Status.PASS, result.getName() + " test has passed");
        }
        extentReports.flush();

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

