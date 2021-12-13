package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckOutProcessPage;
import pages.HelperMethod;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CheckoutProcessDefinitions {
    private WebDriver driver;

    @Given("existing user is successfully logged in")
    public void existing_user_is_successfully_logged_in() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        CheckOutProcessPage userLogin = new CheckOutProcessPage(driver);
        userLogin.userLogin();
        CheckOutProcessPage userName = new CheckOutProcessPage(driver);
        assertEquals("Sławek Majchrzak", userName.getUserName());
    }

    @When("clicked on Clothes link in the upper menu")
    public void clicked_on_clothes_link_in_the_upper_menu() {
        CheckOutProcessPage clothesLink = new CheckOutProcessPage(driver);
        clothesLink.setClothesLink();
    }

    @Then("page with clothing articles is displayed")
    public void page_with_clothing_articles_is_displayed() {
        HelperMethod articlesPage = new HelperMethod(driver);
        assertEquals("https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category", articlesPage.checkHTTPAddress());
    }

    @When("selecting a Hummingbird Printed Sweater article")
    public void selecting_a_hummingbird_printed_sweater_article() {
        CheckOutProcessPage selectArticle = new CheckOutProcessPage(driver);
        selectArticle.setArticle();
    }

    @Then("that article's details page is displayed")
    public void that_article_s_details_page_is_displayed() {
        HelperMethod articleDetailsPage = new HelperMethod(driver);
        assertEquals("https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s", articleDetailsPage.checkHTTPAddress());
    }

    @Then("checking if discount is applied correctly")
    public void checking_if_discount_is_applied_correctly() {
        CheckOutProcessPage checkDiscount = new CheckOutProcessPage(driver);
        assertEquals(checkDiscount.checkDiscount(), checkDiscount.convertDiscountedPrice());
    }

    @When("^selecting \"(.*)\" from the dropdown box$")
    public void selecting_from_the_dropdown_box(String size) {
        CheckOutProcessPage setSize = new CheckOutProcessPage(driver);
        setSize.setSizeToM(size);
    }

    @Then("^the \"(.*)\" size is selected$")
    public void the_size_is_selected(String size) {
        CheckOutProcessPage checkSize = new CheckOutProcessPage(driver);
        Assert.assertEquals("M", checkSize.getSelectedSize());
    }

    @When("^changing \"(.*)\" to \"(.*)\" and clicking Add to Cart button$")
    public void changing_quantity_and_clicking_add_to_cart_button(String quantity, String amount) {
        CheckOutProcessPage setAmount = new CheckOutProcessPage(driver);
        setAmount.setQuantity(amount);
        CheckOutProcessPage addToCart = new CheckOutProcessPage(driver);
        addToCart.addToCartButtonAction();
    }

    @Then("a popup window with selected stuff appears")
    public void a_popup_window_with_selected_stuff_appears() {
        CheckOutProcessPage checkModal = new CheckOutProcessPage(driver);
        Assert.assertEquals( "btn btn-secondary", checkModal.checkModalWindow());
    }

    @When("clicking on Proceed to Checkout button")
    public void clicking_on_proceed_to_checkout_button() {
        CheckOutProcessPage proceed = new CheckOutProcessPage(driver);
        proceed.proceedToCheckoutButton();
    }

    @Then("redirected ot the cart page")
    public void redirected_ot_the_cart_page() {
        HelperMethod cart = new HelperMethod(driver);
        assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show", cart.checkHTTPAddress());
    }

    @When("selecting Proceed to Checkout button")
    public void selecting_proceed_to_checkout_button() {
        CheckOutProcessPage proceed = new CheckOutProcessPage(driver);
        proceed.continueToCheckoutButton();
    }

    @Then("address selection page is displayed")
    public void address_selection_page_is_displayed() {
        CheckOutProcessPage addressName = new CheckOutProcessPage(driver);
        assertEquals("2", addressName.displayAddressName());
    }

    @When("clicking Continue with a selected address")
    public void clicking_continue_with_a_selected_address() {
        CheckOutProcessPage addressConfirm = new CheckOutProcessPage(driver);
        addressConfirm.continueWithSelectedAddressButton();
    }

    @When("clicking Continue with selected PrestaShop delivery")
    public void clicking_continue_with_selected_presta_shop_delivery() {
        CheckOutProcessPage deliveryConfirm = new CheckOutProcessPage(driver);
        deliveryConfirm.continueWithDeliveryButton();
    }

    @When("checking Pay By Check selector")
    public void checking_pay_by_check_selector() {
        CheckOutProcessPage paymentConfirm = new CheckOutProcessPage(driver);
        paymentConfirm.continueWithPaymentButton();
    }

    @When("agreeing with the terms of service")
    public void agreeing_with_the_terms_of_service() {
        CheckOutProcessPage termsConfirm = new CheckOutProcessPage(driver);
        termsConfirm.agreeToTerms();
    }

    @When("clicking on Order With An Obligation To Pay button")
    public void clicking_on_order_with_an_obligation_to_pay_button() {
        CheckOutProcessPage orderObligationButton = new CheckOutProcessPage(driver);
        orderObligationButton.orderWithObligationToPay();
    }

    @Then("order confirmation page is displayed")
    public void order_confirmation_page_is_displayed() {
        CheckOutProcessPage orderButton = new CheckOutProcessPage(driver);
        assertEquals("content-hook_order_confirmation", orderButton.orderConfirmationTitle());
    }

    @Then("centering the page and taking a screenshot")
    public void centering_the_page_and_taking_a_screenshot() throws Exception {
        CheckOutProcessPage screenshot = new CheckOutProcessPage(driver);
        screenshot.takeOrderScreenShot();
    }

    @When("clicking on the user's name")
    public void clicking_on_the_user_s_name() {
        CheckOutProcessPage userName = new CheckOutProcessPage(driver);
        userName.clickOnUserName();
    }

    @When("clicking on the Order History and Details button")
    public void clicking_on_the_order_history_and_details_button() {
        CheckOutProcessPage historyButton = new CheckOutProcessPage(driver);
        historyButton.historyLinkButton();
    }

    @Then("Orders History page is displaying a list of orders")
    public void orders_history_page_is_displaying_a_list_of_orders() {
        HelperMethod historyList = new HelperMethod(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=history", historyList.checkHTTPAddress());
    }

    @Then("check the status name as Awaiting Check Payment of the latest order")
    public void check_the_status_name_as_awaiting_check_payment_of_the_latest_order() {
        CheckOutProcessPage statusLabel = new CheckOutProcessPage(driver);
        Assert.assertEquals("Awaiting check payment", statusLabel.verifyPaymentLabel());
        System.out.println("Status text: " + statusLabel.verifyPaymentLabel());
    }

    @Then("check the total amount of the latest order")
    public void check_the_total_amount_of_the_latest_order() {
        CheckOutProcessPage totalAmount = new CheckOutProcessPage(driver);
        Assert.assertEquals("143.60", totalAmount.verifyTotalAmount().substring(1));
        System.out.println("Total amount: " + totalAmount.verifyTotalAmount().substring(1));
        driver.quit();
    }
}
