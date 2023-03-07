package com.solvd.luma.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luma.components.NavigationBar;
import com.solvd.luma.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='store.menu']")
    private NavigationBar navigationBar;

    @FindBy(xpath = "//*[contains(text(), 'Hot Sellers')]")
    private ExtendedWebElement hotSellers;

    @FindBy(css = ".block-promo.home-pants")
    private ExtendedWebElement pantsPromoLink;

    @FindBy(css = ".block-promo.home-t-shirts")
    private ExtendedWebElement shirtsPromoLink;

    @FindBy(css = ".product-item-info")
    private List<ProductContainer> hotSellerProducts;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public PantsPromoPage openPantsPromoPage() {
        pantsPromoLink.click();
        return new PantsPromoPage(getDriver());
    }

    public ShirtsPromoPage openShirtsPromoPage() {
        shirtsPromoLink.click();
        return new ShirtsPromoPage(getDriver());
    }

    public List<ProductContainer> getHotSellerItems() {
        return hotSellerProducts;
    }

    @Override
    public boolean isPageOpened() {
        return hotSellers.isElementPresent();
    }
}
