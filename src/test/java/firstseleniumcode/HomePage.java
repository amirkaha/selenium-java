package firstseleniumcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    public final static By loanInput = By.id("Loa3nAmount");
    public final static By interestInput = By.id("InterestRate");
    public final static By selectYears = By.id("LoanLengthYears");
    public final static By yearsDropDown = By.xpath("//*[@id=\"LoanLengthYears\"]/option[1]");
    public final static By calculate = By.xpath("//*[@id=\"calculatorInner\"]/form/fieldset/input[3]");

    public HomePage (WebDriver driver)  { super (driver); }

    public void loadPage() { getDriver().get("https://tools.anz.co.nz/home-loans/repayments-calculator"); }

    public void enterLoan (String loanAmount) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(loanInput));
        getDriver().findElement(loanInput).sendKeys(loanAmount);
    }

    public void enterInterest (String interestAmount) {
        getDriver().findElement(interestInput).sendKeys(interestAmount);
    }

    public void enterYears (int yearAmount) {
        getDriver().findElement(selectYears).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(yearsDropDown ));
        getDriver().findElement(By.xpath("//*[@id=\"LoanLengthYears\"]/option[" + yearAmount + "]"));
    }

    public void clickCalculate () {
        getDriver().findElement(calculate).click();
    }


}
