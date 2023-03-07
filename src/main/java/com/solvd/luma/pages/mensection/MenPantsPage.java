package com.solvd.luma.pages.mensection;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luma.components.FilterContentBlock;
import com.solvd.luma.components.ProductContainer;
import com.solvd.luma.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenPantsPage extends AbstractPage {

    @FindBy(css = ".filter-content")
    private FilterContentBlock filterContentBlock;

    @FindBy(css = ".product-item-info")
    private List<ProductContainer> items;

    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private ExtendedWebElement cartLink;

    public MenPantsPage(WebDriver driver) {
        super(driver);
    }

    public FilterContentBlock getFilterContentBlock() {
        return filterContentBlock;
    }

    public List<ProductContainer> getItems() {
        return items;
    }

    public ShoppingCartPage goToCartPage() {
        cartLink.click();
        return new ShoppingCartPage(driver);
    }

}
