package seleniumanzcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.assertEquals;

public class CalculatorPage extends AbstractPage {

    public final static By LOAN_AMOUNT = By.id("LoanAmount");
    public final static By SELECT_YEARS = By.id("LoanLengthYears");
    public final static By YEARS_DROP_DOWN = By.xpath("//*[@id=\"LoanLengthYears\"]/option[1]");
    public final static By CALCULATE = By.xpath("//*[@id=\"calculatorInner\"]/form/fieldset/input[3]");
    public final static By REPAYMENT = By.id("js-repayment");
    public final static By REPAYMENT_SLIDER = By.id("js-repaymentSlider");
    public final static By SLIDER_INTEREST_RATE = By.xpath("//*[@id=\"js-repaymetAdjustAjaxRefresh\"]/div[2]/span[2]");
    public final static By SCENARIO_LEGEND = By.id("scenarioLegend");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage loadPage() {
        get("https://tools.anz.co.nz/home-loans/repayments-calculator");
        return this;
    }

    public CalculatorPage enterYears(int yearAmount) {
        clickOn(SELECT_YEARS);
        waitFor(YEARS_DROP_DOWN);
        findElement(By.xpath("//*[@id=\"LoanLengthYears\"]/option[" + yearAmount + "]")).click();
        return this;
    }

    public CalculatorPage enterLoan(String loanAmount) {
        waitFor(LOAN_AMOUNT);
        enterText(LOAN_AMOUNT, loanAmount);
        return this;
    }

    public CalculatorPage clickCalculate() {
        waitFor(CALCULATE);
        clickOn(CALCULATE);
        waitFor(CALCULATE);
        return this;
    }

    public void monthlyRepaymentMatches(String expected) {
        waitFor(REPAYMENT);
        String actual = getText(REPAYMENT);
            assertEquals(actual, expected);
    }

    public void newInterestRateMatches(String expected) {
        waitFor(SCENARIO_LEGEND);
        waitFor(SLIDER_INTEREST_RATE);
        String actual = getText(SLIDER_INTEREST_RATE);
            assertEquals(actual, expected);
    }

    public CalculatorPage sliderCanMove(WebDriver driver) {
        waitFor(REPAYMENT_SLIDER);
        WebElement slider = findElement(REPAYMENT_SLIDER);
        int sliderWidth = getSliderWidth(slider);
        moveTheSlider(driver, slider,sliderWidth); //method that moves the slider
        return this;
    }

    public int getSliderWidth(WebElement slider) {
        return slider.getSize().getWidth();
    }

    public void moveTheSlider(WebDriver driver, WebElement slider, int sliderWidth) {
        Actions move = new Actions(driver);
        move.moveToElement(slider, ((sliderWidth*10)/100), 0).click();
        move.build().perform();
    }
}
