package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    public final static By loanInput = By.id("LoanAmount");
    public final static By interestInput = By.id("InterestRate");
    public final static By selectYears = By.id("LoanLengthYears");
    public final static By yearsDropDown = By.xpath("//*[@id=\"LoanLengthYears\"]/option[1]");
    public final static By calculate = By.xpath("//*[@id=\"calculatorInner\"]/form/fieldset/input[3]");
    public final static By repayment = By.id("js-repayment");

    public HomePage(WebDriver driver)  { super (driver); } //this is a constructor, method has same name as class

    public HomePage loadPage() {
        getDriver().get("https://tools.anz.co.nz/home-loans/repayments-calculator");
        return this;
    }

    public HomePage enterLoan (String loanAmount) {
        waitFor(loanInput);
        enterText(loanInput, loanAmount);
        return this;
    }

    public HomePage enterInterest (String interestAmount) throws InterruptedException {
        waitFor(interestInput);
        clickOn(interestInput);
        Thread.sleep(1000);
        enterText(interestInput, interestAmount);
        return this;
    }

    public HomePage enterYears (int yearAmount) {
        clickOn(selectYears);
        waitFor(yearsDropDown);
        getDriver().findElement(By.xpath("//*[@id=\"LoanLengthYears\"]/option[" + yearAmount + "]")).click();
        return this;
    }

    public HomePage calculateEachYear() {
        for (int i = 1; i <= 30; i++) {
            enterYears(i);
            clickCalculate();
        }
        return this;
    }

    public HomePage clickCalculate () {
        waitFor(calculate);
        clickOn(calculate);
        waitFor(calculate);
        return this;
    }

    public void monthlyRepaymentMatches (String expected) {
        waitFor(repayment);
        String actual = getDriver().findElement(repayment).getText();
        Assert.assertEquals(actual,expected);
    }
}
