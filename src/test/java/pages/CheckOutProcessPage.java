package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class CheckOutProcessPage extends BasePage{

    public CheckOutProcessPage(WebDriver driver) {
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

    // CLOTHES button
    @FindBy(xpath = "//*[@id=\"category-3\"]/a")
    private WebElement clothesLink;
    // article link - Hummingbird printed sweater
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a")
    private WebElement linkToHummingbirdSweater;
    // article item - Hummingbird printed sweater
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/h1")
    private WebElement hummingbirdSweater;
    // get regular price
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/span")
    private WebElement regularPrice;
    // get current discounted price
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    private WebElement currentDiscountedPrice;

    // sizes dropdown box
    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizesDropdown;
    // selected size
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement selectedSizeDropdown;
    // quantity
    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantity;
    // add to cart button
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCart;

    // modal window
    @FindBy(xpath = "//button[contains(text(), 'Continue shopping')]")
    private WebElement modalItemConfirmationWindow;
    // modal window proceed to checkout button
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButton;

    // cart proceed to checkout button
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement cartProceedToCheckoutButton;
    // address radio button
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/h1/span[1]")
    private WebElement addressRadioButton;
    // address confirm button
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private WebElement addressConfirmButton;
    // delivery confirm button
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement deliveryConfirmButton;
    // payment option selector
    @FindBy(id = "payment-option-1")
    private WebElement paymentOption;
    // terms and conditions checkbox
    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsCheckbox;
    // order with an obligation to pay button
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderWithAnObligationToPayButton;
    // order confirmation page
    @FindBy(xpath = "//*[@id=\"content-hook_order_confirmation\"]")
    private WebElement orderConfirmationTitle;
    // user info
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userInfo;
    // order history
    @FindBy(id = "history-link")
    private WebElement historyLink;
    // order payment status
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[4]/span")
    private WebElement paymentStatusText;
    // order total amount
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")
    private WebElement paymentTotalAmount;

    public void userLogin(){
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("sm@sm.pl");
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("1234qweasd");
        buttonSignInt.click();
    }
    public String getUserName(){
        return userInfo.getText();
    }
    public Double checkDiscount(){
        double discountAmount = 0.2;
        String getRegularPrice = regularPrice.getText().substring(1);
        double convertStringToDouble = Double.parseDouble(getRegularPrice);
        return convertStringToDouble - (convertStringToDouble * discountAmount);
    }
    public Double convertDiscountedPrice(){
        return Double.valueOf(currentDiscountedPrice.getText().substring(1));
    }
    public void setClothesLink(){
        clothesLink.click();
    }
    public void setArticle(){
        linkToHummingbirdSweater.click();
    }
    public void setSizeToM(String size){
        sizesDropdown.click();
        sizesDropdown.sendKeys(size);
    }
    public String getSelectedSize(){
        return selectedSizeDropdown.getText();
    }
    public void setQuantity(String amount){
        quantity.click();
        quantity.clear();
        quantity.sendKeys("5");
    }
    public void addToCartButtonAction(){
        addToCart.click();
    }
    public String checkModalWindow(){
        return modalItemConfirmationWindow.getAttribute("class");
    }
    public void proceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    public void continueToCheckoutButton(){
        cartProceedToCheckoutButton.click();
    }
    public String displayAddressName(){
        return addressRadioButton.getText();
    }
    public void continueWithSelectedAddressButton(){
        addressConfirmButton.click();
    }
    public void continueWithDeliveryButton(){
        deliveryConfirmButton.click();
    }
    public void continueWithPaymentButton(){
        paymentOption.click();
    }
    public void agreeToTerms(){
        termsCheckbox.click();
    }
    public void orderWithObligationToPay(){
        orderWithAnObligationToPayButton.click();
    }
    public String orderConfirmationTitle(){
        return orderConfirmationTitle.getAttribute("id");
    }
    public void clickOnUserName(){
        userInfo.click();
    }
    public void historyLinkButton(){
        historyLink.click();
    }
    public String verifyPaymentLabel(){
        return paymentStatusText.getText();
    }
    public String verifyTotalAmount(){
        return paymentTotalAmount.getText();
    }

    public void takeOrderScreenShot() throws Exception{
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./src/test/screenshots/screenshot.png"));
        System.out.println("Screenshot");
    }

}
