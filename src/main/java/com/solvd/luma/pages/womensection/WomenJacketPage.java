package com.solvd.luma.pages.womensection;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luma.components.FilterContentBlock;
import com.solvd.luma.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenJacketPage extends AbstractPage {
    @FindBy(css = ".filter-content")
    private FilterContentBlock filterContentBlock;

    @FindBy(css = ".product-item-info")
    private List<ProductContainer> items;

    public WomenJacketPage(WebDriver driver) {
        super(driver);
    }

    public FilterContentBlock getFilterContentBlock() {
        return filterContentBlock;
    }

    public List<ProductContainer> getItems() {
        return items;
    }
}
