package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

public class CalculatorPage extends AbstractPage {

    public final static By loanInput = By.id("LoanAmount");
    public final static By interestInput = By.id("InterestRate");
    public final static By selectYears = By.id("LoanLengthYears");
    public final static By yearsDropDown = By.xpath("//*[@id=\"LoanLengthYears\"]/option[1]");
    public final static By calculate = By.xpath("//*[@id=\"calculatorInner\"]/form/fieldset/input[3]");
    public final static By repayment = By.id("js-repayment");
    public final static By repaymentSlider = By.id("js-repaymentSlider");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    } //this is a constructor, method has same name as class

    public CalculatorPage loadPage() {
        getDriver().get("https://tools.anz.co.nz/home-loans/repayments-calculator");
        return this;
    }

    public CalculatorPage enterLoan(String loanAmount) {
        waitFor(loanInput);
        enterText(loanInput, loanAmount);
        return this;
    }

    public CalculatorPage enterInterest(String interestAmount) throws InterruptedException {
        waitFor(interestInput);
        clickOn(interestInput);
        Thread.sleep(1000);
        enterText(interestInput, interestAmount);
        return this;
    }

    public CalculatorPage enterYears(int yearAmount) {
        clickOn(selectYears);
        waitFor(yearsDropDown);
        findElement(By.xpath("//*[@id=\"LoanLengthYears\"]/option[" + yearAmount + "]")).click();
        return this;
    }

    public CalculatorPage calculateEachYear() {
        for (int i = 1; i <= 30; i++) {
            enterYears(i);
            clickCalculate();
        }
        return this;
    }

    public CalculatorPage clickCalculate() {
        waitFor(calculate);
        clickOn(calculate);
        waitFor(calculate);
        return this;
    }

    public void monthlyRepaymentMatches(String expected) {
        waitFor(repayment);
        String actual = getText(repayment);
        assertEquals(actual, expected);
    }

    public void sliderCanMove() {
        waitFor(repaymentSlider);
        WebElement slider = findElement(repaymentSlider);
        int sliderWidth = getSliderWidth(slider);
        moveTheSlider(slider,sliderWidth,0 ); //method that moves the slider
    }
}
