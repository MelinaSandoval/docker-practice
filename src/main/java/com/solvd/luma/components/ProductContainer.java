package com.solvd.luma.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// css: ".product-item-info"
public class ProductContainer extends AbstractUIObject {
    @FindBy(xpath = "//div[@data-product-id='%d']//..//a")
    private ExtendedWebElement productLink;
    @FindBy(css = ".product-item .price")
    private ExtendedWebElement productPrice;
    @FindBy(css = "[data-role='priceBox']")
    private ExtendedWebElement priceBox;
    @FindBy(css = ".swatch-opt-%d .size .swatch-option")
    private List<ExtendedWebElement> sizes;
    @FindBy(css = ".swatch-opt-%d .swatch-option.color")
    private List<ExtendedWebElement> colors;

    @FindBy(xpath = "//div[@data-product-id='%d']//..//..//img")
    private ExtendedWebElement productImage;

    @FindBy(css = ".swatch-opt-%d .swatch-option.color.selected")
    private ExtendedWebElement selectedColor;

    @FindBy(css = ".swatch-opt-%d .size .swatch-option.selected")
    private ExtendedWebElement selectedSize;

    @FindBy()
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@role='alert']//div[contains(text(),'You added %d to your')")
    private ExtendedWebElement productAddedToCartAlert;

    public ProductContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductAddedToCartAlert() {
        return productAddedToCartAlert.format(getProductTitle());
    }

    public String getProductTitle() {
        return productLink.getAttribute("title");
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getPrice() {
        return productPrice.getText();
    }


    public String getProductId() {
        return priceBox.getAttribute("data-product-id");
    }

    public List<ExtendedWebElement> getSizes() {
        sizes.forEach(size -> size.format(getProductId()));
        return sizes;
    }

    public List<ExtendedWebElement> getColors() {
        colors.forEach(size -> size.format(getProductId()));
        return colors;
    }

    public boolean itemMatchesColor(String color) {
        productImage.format(getProductId());
        return productImage.getAttribute("alt").contains(color);
    }

    public ExtendedWebElement selectColorByIndex(int index) {
        getColors().get(index).click();
        return getColors().get(index);
    }

    public boolean isColorSelected(int index) {
        return selectColorByIndex(index).getAttribute("aria-checked").equals("true");
    }

    public String getSelectedColor() {
        return selectedColor.getAttribute("option-label");
    }

    public ExtendedWebElement selectSizeByIndex(int index) {
        getSizes().get(index).click();
        return getSizes().get(index);
    }

    public boolean isSizeSelected(int index) {
        return selectSizeByIndex(index).getAttribute("aria-checked").equals("true");
    }

    public String getSelectedSize() {
        return selectedSize.getAttribute("option-label");
    }


    //en el filter, comparar el selectedSize con el el size de la opcion del filtro.


//    option-label="Blue" -> atributo que guarda el color
    //aria-checked="true" -- si el color esta seleccionado.


}
