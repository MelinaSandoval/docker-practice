package com.solvd.luma.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//td[@class='amount']//span[@data-th='Subtotal']")
    private ExtendedWebElement subTotal;

    @FindBy(xpath = "//tr[@class='totals']//td[@data-th='Discount']//span//span")
    private ExtendedWebElement discount;

    @FindBy(css = ".grand.totals .price")
    private ExtendedWebElement total;

    @FindBy(xpath = "//*[@id='editing-view-port']/div")
    private ExtendedWebElement itemAmountInputField;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("/checkout/cart/");
    }

    public String getItemAmount() {
        return itemAmountInputField.getText();
    }

    public void setItemAmount(String amount) {
        itemAmountInputField.sendKeys(Keys.valueOf(amount));
    }

    public boolean isDiscountApplied(double discPercentage) {
        if (!discount.isElementPresent()) {
            return false;
        }
        String sub = subTotal.getText().replace("$", "");
        double subTotal = Double.parseDouble(sub);
        String disc = discount.getText().replace("$", "");
        double discount = Double.parseDouble(disc);
        String tot = total.getText().replace("$", "");
        double total = Double.parseDouble(disc);

        return discount == subTotal * discPercentage && total == subTotal - discount;
    }
}
