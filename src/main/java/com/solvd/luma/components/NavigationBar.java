package com.solvd.luma.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.luma.pages.mensection.MenJacketPage;
import com.solvd.luma.pages.mensection.MenPantsPage;
import com.solvd.luma.pages.mensection.MenTeesPage;
import com.solvd.luma.pages.womensection.WomenHoodiesAndSweatshirtsPage;
import com.solvd.luma.pages.womensection.WomenItemPage;
import com.solvd.luma.pages.womensection.WomenJacketPage;
import com.solvd.luma.pages.womensection.WomenShortsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractUIObject {
    @FindBy(xpath = "//span[contains(text(),\"%d\")]/..")
    private ExtendedWebElement productCategory;

    @FindBy(xpath = "//span[contains(text(),\"Women\")]/../..//ul//*[contains(text(),\"%d\")]/..")
    private ExtendedWebElement womenProductCategory;

    @FindBy(xpath = "//span[contains(text(),\"Men\")]/../..//ul//*[contains(text(),\"%d\")]/..")
    private ExtendedWebElement menProductCategory;

    public NavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WomenItemPage openWomenPage() {
        productCategory.format(ProductCategories.WOMEN.name()).click();
        return new WomenItemPage(driver);
    }

    public WomenItemPage openMenPage() {
        productCategory.format(ProductCategories.MEN.name()).click();
        return new WomenItemPage(driver);
    }

    public WomenJacketPage openWomenJacketPage() {
        productCategory.format(ProductCategories.WOMEN.name()).hover();
        womenProductCategory.format(CategorySubSections.TOPS).hover();
        womenProductCategory.format(TopsSubSections.JACKETS).click();
        return new WomenJacketPage(driver);
    }

    public WomenHoodiesAndSweatshirtsPage openWomenHoodiesPage() {
        productCategory.format(ProductCategories.WOMEN.name()).hover();
        womenProductCategory.format(CategorySubSections.TOPS).hover();
        womenProductCategory.format(TopsSubSections.HOODIES).click();
        return new WomenHoodiesAndSweatshirtsPage(driver);
    }

    public WomenShortsPage openWomenShortsPage() {
        productCategory.format(ProductCategories.WOMEN.name()).hover();
        womenProductCategory.format(CategorySubSections.BOTTOMS).hover();
        womenProductCategory.format(BottomSubSections.SHORTS).click();
        return new WomenShortsPage(driver);
    }

    public MenJacketPage openMenJacketPage() {
        productCategory.format(ProductCategories.MEN.name()).hover();
        menProductCategory.format(CategorySubSections.TOPS).hover();
        menProductCategory.format(TopsSubSections.JACKETS).click();
        return new MenJacketPage(driver);
    }

    public MenTeesPage openMenHoodiesPage() {
        productCategory.format(ProductCategories.MEN.name()).hover();
        menProductCategory.format(CategorySubSections.TOPS).hover();
        menProductCategory.format(TopsSubSections.TEES).click();
        return new MenTeesPage(driver);
    }

    public MenPantsPage openMenPantsPage() {
        productCategory.format(ProductCategories.MEN.name()).hover();
        menProductCategory.format(CategorySubSections.BOTTOMS).hover();
        menProductCategory.format(BottomSubSections.PANTS).click();
        return new MenPantsPage(driver);
    }


    public enum CategorySubSections {
        TOPS("Tops"), BOTTOMS("Bottoms");

        CategorySubSections(String tops) {
        }
    }

    public enum TopsSubSections {
        JACKETS("Jackets"), HOODIES("Hoodies & Sweatshirts"), TEES("Tees");

        TopsSubSections(String topCat) {
        }
    }

    public enum BottomSubSections {
        PANTS("Pants"), SHORTS("Shorts");

        BottomSubSections(String pantCat) {
        }
    }

    public enum ProductCategories {
        WHATS_NEW("What's New"), WOMEN("Women"), MEN("Men"), GEAR("Gear"), TRAINING("Training"), SALE("Sale");

        ProductCategories(String s) {
        }
    }


}
