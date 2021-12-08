package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddAddressPage;
import pages.HelperMethod;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class AddNewAddressDefinitions {
    private WebDriver driver;

    @Given("user logged in and at the Addresses page")
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage userLogin = new LoginPage(driver);
        userLogin.userLogin();
    }

    @When("clicking the link Create New Address")
    public void checkLandingPage() {
        AddAddressPage newAddress = new AddAddressPage(driver);
        newAddress.redirectToAddAddressForm();
        HelperMethod httpAddress = new HelperMethod(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=address", httpAddress.checkHTTPAddress());
    }

    @Then("^fill out and save the form \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void createNewAddress(String alias, String street, String city, String zipCode, String country, String phone) {
        AddAddressPage newAddress = new AddAddressPage(driver);
        newAddress.submittingNewAddress(alias, street, city, zipCode, country, phone);
        HelperMethod newAddressConfirmed = new HelperMethod(driver);
        Assert.assertEquals("Address successfully added!", newAddressConfirmed.addConfirmation());
    }

    @And("check if the newly created address is correct")
    public void checkCreatedAddress() {
        AddAddressPage checkAddress = new AddAddressPage(driver);
        checkAddress.listExistingAddresses();
        Assert.assertEquals("second address\n" +
                "Sławek Majchrzak\n" +
                "Jagiellońska 28\n" +
                "Gdańsk\n" +
                "80-555\n" +
                "United Kingdom\n" +
                "1231231230", checkAddress.compareAddresses());
        HelperMethod pause = new HelperMethod(driver);
        pause.delayTimer(1000);
        driver.quit();
    }

}
