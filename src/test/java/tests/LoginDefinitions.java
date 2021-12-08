package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HelperMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginDefinitions {
    private WebDriver driver;

    @Given("login form is open")
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("login form is filled out")
    public void loginToUserProfile() {
        LoginPage userLogin = new LoginPage(driver);
        userLogin.userLogin();
    }

    @Then("user is successfully logged in")
    public void loginSuccess() {
        HelperMethod userStatus = new HelperMethod(driver);
        Assert.assertEquals("Sławek Majchrzak", userStatus.userIsLoggedIn());
    }

    @And("go to Addresses to add a new address")
    public void goToAddressesAndAssertLandingPage() {
        HelperMethod httpAddress = new HelperMethod(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses", httpAddress.checkHTTPAddress());
        HelperMethod pause = new HelperMethod(driver);
        pause.delayTimer(1000);
        driver.quit();
    }

}
