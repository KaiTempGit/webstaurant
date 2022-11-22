package impl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchPage;
import utils.ConfigReader;
import utils.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchImpl {
    private SearchPage page = null;
    WebDriverWait exWait = new WebDriverWait(WebDriverUtils.getDriver(), 10);

    public SearchPage getPage() {
        if (page == null) {
            page = new SearchPage();
        }
        return page;
    }

    List<String> detailStr = new ArrayList<>();
    WebElement btn;
    public static String lastItemDes;


    public void navigateToHomepage() {
        WebDriverUtils.getDriver().get(ConfigReader.readProperty("url"));
    }

    public void inputSearchField(String keyword) {
        getPage().searchField.sendKeys(keyword);
    }

//    Create search method that would allow me to go through each page an item
    public void searchOnEachPage(String keyword) {
        List<WebElement> listOfBtns = WebDriverUtils.getDriver().findElements(By.xpath("//div[@id='paging']//li/a"));
        int lastPageNumber = Integer.parseInt(getPage().lastPageBtn.getText());

        for (int i = 0; i <= listOfBtns.size()-1; i++) {
            btn = WebDriverUtils.getDriver().findElement(By.xpath("//div[@id='paging']//li[" + (i+1) + "]/a"));
            detailStr = new ArrayList<>();

            for (WebElement ea : getPage().itemDetails) {
                detailStr.add(ea.getText());
            }
            for(String ea : detailStr ) {
                if (!ea.contains(keyword)) {
                    System.out.println(ea);
                }
                Assert.assertTrue(ea.contains(keyword));
            }
            if(i < lastPageNumber - 1) {
//                System.out.println("Testing on page : " + btn.getText()); // To keep track of the page that is runnung
                if (i != lastPageNumber){
                    btn.click();
                }
            }
        }
    }

//    The method for getting to Add To Cart Button from the last item
    public WebElement lastBtn() {
        int lastBtnNumber = getPage().listOfAddBtn.size()-1;
        WebElement theLastBtn = getPage().listOfAddBtn.get(lastBtnNumber);
        return theLastBtn;
    }

//    Creating a method that would support different click buttons with the same behavior
    public void clickOn(String buttonValue) {
        switch (buttonValue.toLowerCase()) {
            case "search" :
                getPage().searchBtn.click();
                break;
            case "last page" :
                getPage().lastPageBtn.click();
                break;
            case "last item add to cart" :
                lastItemDes = lastItemDesStr();
                lastBtn().click();
                if (getPage().addToCartOnPopUp.isDisplayed()) {
                    getPage().addToCartOnPopUp.click();
                }
                break;
            case "view cart" :
                getPage().viewCartBtn.click();
                break;
            case "cart" :
                getPage().cartBtn.click();
                break;
            case "empty cart" :
                getPage().emptyCartBtn.click();
                break;
            default:
                System.out.println("There is no such button.....");
        }
    }

//    To confirm empty button
    public void clickConfirm(String buttonText) {
        if (buttonText.equalsIgnoreCase("Empty Cart")) {
            getPage().confirmEmptyCart.click();
        }
        else if (buttonText.equalsIgnoreCase("Cancel")) {
            getPage().cancelEmptyCart.click();
        }
    }

//    To get last item in String format
    public String lastItemDesStr() {
        List<String> temp = new ArrayList<>();
        for (WebElement ea : getPage().listOfItemDescription) {
            temp.add(ea.getText());
        }
//        System.out.println((temp.get(temp.size()-1)));  // <---- To verify during coding
        return temp.get(temp.size()-1);
    }

//    To get the list of item in cart. Just in ase that there are more than one of them
    public List<String> itemInCart() {
        List<String> res = new ArrayList<>();
        for (WebElement ea : getPage().listOfDescriptionsCart) {
            res.add(ea.getText());
        }
//        System.out.println(res); // <---- To verify during coding
        return res;
    }

}
