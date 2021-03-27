package firstseleniumcode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private final static int TIMEOUT = 30;

    private  WebDriver driver;
    private  WebDriverWait wait;

    public AbstractPage(WebDriver driver) throws NullPointerException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,TIMEOUT);
    }
    public WebDriver getDriver() { return driver; }

    public WebDriverWait getWait() {return wait; }

    public void enterText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public void waitFor(By by) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickOn(By by) {
        getDriver().findElement(by).click();
    }
}

