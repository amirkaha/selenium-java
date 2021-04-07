package SeleniumANZCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class AbstractPage {

    private final static int TIMEOUT = 30;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AbstractPage(WebDriver driver) throws NullPointerException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void enterText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public void waitFor(By by) {
        wait.until(visibilityOfElementLocated(by));
    }

    public void clickOn(By by) {
        getDriver().findElement(by).click();
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public Integer getSliderWidth(WebElement slider) {
        return slider.getSize().getWidth();
    }

    public void moveTheSlider (WebElement slider, Integer amount, Integer y) {
        Actions move = new Actions(getDriver());
        move.moveToElement(slider, ((amount*10)/100), 0).click();
        move.build().perform();
    }
}

