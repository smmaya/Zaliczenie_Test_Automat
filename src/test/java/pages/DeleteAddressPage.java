package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeleteAddressPage extends BasePage {
    public DeleteAddressPage(WebDriver driver) {
        super(driver);
    }

    // logout before quitting
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
    private WebElement logoutFromAccount;

    public void deleteLastCreatedAddress() {
        List<WebElement> addresses = driver.findElements(By.xpath("//*[starts-with(@class, 'address-')]"));
        for (WebElement address : addresses) {
            address.getText();
        }
        WebElement listOfAddresses = addresses.get(1);
        List<WebElement> lastAddress = listOfAddresses.findElements(By.xpath("//*[contains(@data-link-action, 'delete-address')]"));
            lastAddress.get(1).click();
    }

    public void logout() {
        logoutFromAccount.click();
    }
}

