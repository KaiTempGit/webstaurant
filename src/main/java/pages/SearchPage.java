package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

import java.util.List;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    @FindBy(id = "searchval")
    public WebElement searchField;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='details']/a[2]")
    public List<WebElement>  itemDetails;

    @FindBy(xpath = "//*[@id='paging']//li/a")
    public List<WebElement> listSizeOfPages;

    @FindBy(xpath = "//div[@id='paging']//li[last()-1]/a")
    public WebElement lastPageBtn;

    @FindBy(xpath = "//div[@class='btn-container']//input[@value='Add to Cart']")
    public List<WebElement> listOfAddBtn;

    @FindBy(xpath = "//button[contains(text(),'Add To Cart')]")
    public WebElement addToCartOnPopUp;

    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    public WebElement viewCartBtn;

    @FindBy(xpath = "//div[@id='details']/a[@data-testid]")
    public List<WebElement> listOfItemDescription;

    @FindBy(xpath = "//span[@class='itemDescription description']/a")
    public List<WebElement> listOfDescriptionsCart;

    @FindBy(xpath = "//a[@data-testid='cart-nav-link']")
    public WebElement cartBtn;

    @FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//button[contains(text(),'Empty') and contains(@class,'bg-origin-box-border')]")
    public WebElement confirmEmptyCart;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelEmptyCart;

    @FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
    public WebElement emptyCartMsg;
}
