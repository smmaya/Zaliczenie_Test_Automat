package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DeleteAddressPage;
import pages.HelperMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class DeleteAddressDefinitions {
    private WebDriver driver;

    @Given("logged in and at addresses page")
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        LoginPage userLogin = new LoginPage(driver);
        userLogin.userLogin();
    }

    @When("deleting last created address")
    public void deleteAddress() {
        DeleteAddressPage deleteAddress = new DeleteAddressPage(driver);
        deleteAddress.deleteLastCreatedAddress();
        HelperMethod addressDeletionConfirmed = new HelperMethod(driver);
        Assert.assertEquals("Address successfully deleted!", addressDeletionConfirmed.deleteConfirmation());
    }

    @Then("logout and exit browser")
    public void logoutAndExit() {
        DeleteAddressPage logout = new DeleteAddressPage(driver);
        logout.logout();
        HelperMethod httpAddress = new HelperMethod(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=addresses", httpAddress.checkHTTPAddress());
        driver.quit();
    }
}
