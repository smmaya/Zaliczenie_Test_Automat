package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddAddressPage extends BasePage {
    public AddAddressPage(WebDriver driver) {
        super(driver);
    }

    // click on create new address link
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a")
    private WebElement linkCreateNewAddress;

    // input alias
    @FindBy(name = "alias")
    private WebElement inputAlias;
    // input address street
    @FindBy(name = "address1")
    private WebElement inputStreet;
    // input city
    @FindBy(name = "city")
    private WebElement inputCity;
    // input zip code
    @FindBy(name = "postcode")
    private WebElement inputZipCode;
    // input country
    @FindBy(name = "id_country")
    private WebElement inputCountry;
    // phone
    @FindBy(name = "phone")
    private WebElement inputPhoneNumber;
    // button address submit
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement buttonSubmitAddress;

    // sprawdzenie dodanego adresu
    // check alias
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/h4")
    private WebElement checkAlias;
    // check address street
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/address/text()[2]")
    private WebElement checkStreet;
    // check city
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/address/text()[3]")
    private WebElement checkCity;
    // check zip code
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/address/text()[4]")
    private WebElement checkZipCode;
    // check country
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/address/text()[5]")
    private WebElement checkCountry;
    // check phone
    @FindBy(xpath = "//*[@id=\"address-17856\"]/div[1]/address/text()[6]")
    private WebElement checkPhoneNumber;

    public void submittingNewAddress(String alias, String street, String city, String zipCode, String country, String phone) {
        inputAlias.click();
        inputAlias.clear();
        inputAlias.sendKeys(alias);
        inputStreet.click();
        inputStreet.clear();
        inputStreet.sendKeys(street);
        inputCity.click();
        inputCity.clear();
        inputCity.sendKeys(city);
        inputZipCode.click();
        inputZipCode.clear();
        inputZipCode.sendKeys(zipCode);
        inputCountry.click();
        inputCountry.sendKeys(country);
        inputPhoneNumber.click();
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(phone);
        buttonSubmitAddress.click();
    }

    public void redirectToAddAddressForm() {
        linkCreateNewAddress.click();
    }

    public String compareAddresses() {
        List<WebElement> addresses = driver.findElements(By.className("address-body"));
        for (WebElement address : addresses) {
            address.getText();
        }
        WebElement lastAddress = addresses.get(1);
        return lastAddress.getText();
    }

    public String getAliasName() {
        List<WebElement> aliasName = driver.findElements(By.tagName("h4"));
        for (WebElement alias : aliasName) {
            alias.getText();
        }
        WebElement lastAlias = aliasName.get(1);
        return lastAlias.getText();
    }

    public String getAddress() {
        List<WebElement> addresses = driver.findElements(By.tagName("address"));
        for (WebElement address : addresses) {
            address.getText();
        }
        WebElement lastAddress = addresses.get(1);
        return lastAddress.getText();
    }

}
