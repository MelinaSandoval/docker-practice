package com.solvd.luma.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luma.components.NavigationBar;
import com.solvd.luma.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShirtsPromoPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='store.menu']")
    private NavigationBar navigationBar;

    @FindBy(css = ".product-item-info")
    private List<ProductContainer> items;

    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private ExtendedWebElement cartLink;

    public ShirtsPromoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("/promotions/tees-all.html");
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public List<ProductContainer> getItems() {
        return items;
    }

    public ShoppingCartPage goToCartPage() {
        cartLink.click();
        return new ShoppingCartPage(getDriver());
    }
}
