package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // email input field
    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    private WebElement inputEmail;
    // password input field
    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement inputPassword;
    // sign in button
    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement buttonSignInt;
    // click on Addresses button
    @FindBy(xpath = "//*[@id=\"addresses-link\"]")
    private WebElement buttonAddresses;

    public void userLogin(){
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("sm@sm.pl");
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("1234qweasd");
        buttonSignInt.click();
        buttonAddresses.click();
    }

}
