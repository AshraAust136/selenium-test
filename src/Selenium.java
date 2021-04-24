import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selenium {
    @FindBy(css = ".PlnBa button")
    WebElement closeAd;

    @FindBy(css = ".cLuHeZ .items-center button:nth-child(4)")
    WebElement loginPanel;

    @FindBy(css = "input[name = 'phone']")
    WebElement textBoxUserName;

    @FindBy(css = "input[name = 'password']")
    WebElement textBoxPassword;

    @FindBy(css = ".kuyfle button")
    WebElement buttonLogin;

    @FindBy(css = "a[id = 'all-shops']")
    WebElement buttonAllShops;

    @FindBy(css = ".grid a:nth-child(2)")
    WebElement shopSafwaan;

    @FindBy(css = ".product-grid .flex-col:nth-child(1) button")
    WebElement buttonProductPantBuy;

    @FindBy(css = ".PlnCH .dNDJhI p")
    WebElement assertionText;

    public void test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Ashra\\IdeaProjects\\Evaly_QA_Task_1\\driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        PageFactory.initElements(driver, this);
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        Helper helper = new Helper(driver);

        driver.get("https://evaly.com.bd/");

        helper.waitFor(closeAd);
        closeAd.click();

        helper.waitFor(loginPanel);
        loginPanel.click();

        helper.waitFor(textBoxUserName);
        textBoxUserName.sendKeys("01521515792");

        textBoxPassword.sendKeys("Waseka$nawer94");

        buttonLogin.click();

        helper.waitFor(buttonAllShops);
        buttonAllShops.click();

        helper.waitFor(shopSafwaan);
        shopSafwaan.click();

        helper.waitFor(buttonProductPantBuy);
        buttonProductPantBuy.click();

        helper.waitFor(assertionText);
        String assertText = assertionText.getText();
        System.out.println(assertText);
        assert assertText.equals("Select Variant");
        driver.quit();

    }
}
