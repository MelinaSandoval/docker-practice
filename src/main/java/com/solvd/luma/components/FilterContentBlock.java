package com.solvd.luma.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterContentBlock extends AbstractUIObject {
    @FindBy(xpath = "//*[contains(@class,'filter-options-item')]//div[contains(text(),'Size')]")
    private ExtendedWebElement sizeFilter;

    @FindBy(xpath = "//*[contains(@class,'filter-options-item')]//div[contains(text(),'Size')]//..//*[contains(text(),'%d')]")
    private ExtendedWebElement size;

    @FindBy(xpath = "//*[contains(text(),'Clear All')]")
    private ExtendedWebElement clearAllButton;


    @FindBy(xpath = "//*[contains(@class,'filter-options-item')]//div[contains(text(),'Color')]")
    private ExtendedWebElement colorFilter;

    @FindBy(xpath = "//*[contains(@class,'filter-options-item')]//div[contains(text(),'Color')]//..//*[@option-label='%d']")
    private ExtendedWebElement color;

    public FilterContentBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectSize(Sizes siz) {
        sizeFilter.click();
        size.format(siz.name());
    }

    public void selectColor(Colors col) {
        colorFilter.click();
        color.format(col.name());
    }

    public void clearAllFilters() {
        clearAllButton.click();
    }

    public boolean isAnyFilterApplied() {
        return clearAllButton.isElementPresent();
    }


    public enum Sizes {
        XS("XS"), S("S"), M("M"), L("L"), XL("XL");

        Sizes(String x) {
        }
    }

    public enum Colors {
        BLACK("Black"), BLUE("Blue"), ORANGE("Orange");

        Colors(String b) {
        }
    }


}
