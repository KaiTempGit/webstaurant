package steps;

import impl.SearchImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverUtils;

import java.util.List;

public class SearchSteps {

    SearchImpl impl = new SearchImpl();

    @Given("user navigate to WebstaurantStore homepage")
    public void user_navigate_to_webstaurant_store_homepage() {
        impl.navigateToHomepage();
    }
    @When("user input {string} in search field")
    public void user_input_in_search_field(String keyword) {
        impl.inputSearchField(keyword);
    }
    @When("user click on {string} button")
    public void user_click_on_button(String buttonName) {
        impl.clickOn(buttonName);
    }

    @Then("user should see every product with {string} in it's title")
    public void userShouldSeeEveryProductWithInItSTitle(String keyword) {
        impl.searchOnEachPage(keyword);
    }

    @Then("user should see {string} button")
    public void userShouldSeeButton(String btnTextValue) {
//        System.out.println("Actual Text Value : "  + impl.getPage().viewCartBtn.getText()); // <--- To visually see the element
//        System.out.println("Expect Text Value : "  + btnTextValue); // <--- To visually see the element
        Assert.assertEquals(impl.getPage().viewCartBtn.getText(), btnTextValue);
    }

    @Then("user should see {string} on page title")
    public void userShouldSeeOnPageTitle(String keyword) {
//        System.out.println(WebDriverUtils.getDriver().getTitle()); // <--- To visually see the title
        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().contains(keyword));
    }


    @And("user should see details of the added item in cart page")
    public void userShouldSeeDetailsOfTheAddedItemInCartPage() {
        Assert.assertTrue(impl.itemInCart().contains(SearchImpl.lastItemDes));
    }

    @And("user click confirm on {string} button in the popup")
    public void userClickConfirmOnButtonInThePopup(String btnText) {
        impl.clickConfirm(btnText);
    }

    @Then("user should Your cart is empty. message")
    public void userShouldYourCartIsEmptyMessage() {
//        System.out.println(impl.getPage().emptyCartMsg.getText()); // <--- To visually see the element
        Assert.assertTrue(impl.getPage().emptyCartMsg.getText().equals("Your cart is empty."));
    }
}
