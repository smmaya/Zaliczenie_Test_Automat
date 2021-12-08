package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelperMethod extends BasePage{
    public HelperMethod(WebDriver driver) {
        super(driver);
    }

    // get the user's name to check if successfully signed in
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userNameCheck;
    // confirm the address has been added
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement addressAddedSuccessfully;
    // confirm the address has been deleted
    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement addressDeletedSuccessfully;

    public String userIsLoggedIn(){
        return userNameCheck.getText();
    }
    public String checkHTTPAddress(){
        return driver.getCurrentUrl();
    }
    public String addConfirmation() {return addressAddedSuccessfully.getText(); }
    public String deleteConfirmation() {return addressDeletedSuccessfully.getText(); }
    public void delayTimer(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
