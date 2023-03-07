import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.luma.components.ProductContainer;
import com.solvd.luma.pages.HomePage;
import com.solvd.luma.pages.PantsPromoPage;
import com.solvd.luma.pages.ShirtsPromoPage;
import com.solvd.luma.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiscountApplicationTest extends AbstractTest {
    @Test
    public void homePagePantsDiscountTest() {
        //Check if the 20% of discount is applied when adding a pant from the promo page to the cart
        HomePage homePage = new HomePage(getDriver());
        PantsPromoPage pantsPromoPage = homePage.openPantsPromoPage();
        ProductContainer productContainer = pantsPromoPage.getItems().get(1);
        productContainer.selectSizeByIndex(0);
        productContainer.selectColorByIndex(0);
        productContainer.addToCart();
        Assert.assertTrue(productContainer.getProductAddedToCartAlert().isElementPresent());
        ShoppingCartPage shoppingCartPage = pantsPromoPage.goToCartPage();
        Assert.assertTrue(shoppingCartPage.isDiscountApplied(0.20));
    }

    @Test
    public void homePageTeesDiscountTest() {
        //Check if the 25% of discount is applied when adding 4 unities of the same shirt to the cart
        HomePage homePage = new HomePage(getDriver());
        ShirtsPromoPage shirtsPromoPage = homePage.openShirtsPromoPage();
        ProductContainer productContainer = shirtsPromoPage.getItems().get(2);
        productContainer.selectSizeByIndex(2);
        productContainer.selectColorByIndex(1);
        productContainer.addToCart();
        Assert.assertTrue(productContainer.getProductAddedToCartAlert().isElementPresent());
        ShoppingCartPage shoppingCartPage = shirtsPromoPage.goToCartPage();
        shoppingCartPage.setItemAmount("4");
        Assert.assertTrue(shoppingCartPage.getItemAmount().equals("4"));
        Assert.assertTrue(shoppingCartPage.isDiscountApplied(0.25));
    }

}
