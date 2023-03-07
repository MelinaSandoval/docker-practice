import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.luma.components.FilterContentBlock;
import com.solvd.luma.components.NavigationBar;
import com.solvd.luma.pages.HomePage;
import com.solvd.luma.pages.mensection.MenPantsPage;
import com.solvd.luma.pages.womensection.WomenJacketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilteringFunctionalityTest extends AbstractTest {

    @Test
    public void sizeFilteringTest() {
        HomePage homePage = new HomePage(getDriver());
        NavigationBar navigationBar = homePage.getNavigationBar();
        WomenJacketPage womenJacketPage = navigationBar.openWomenJacketPage();
        FilterContentBlock filterContentBlock = womenJacketPage.getFilterContentBlock();
        filterContentBlock.selectSize(FilterContentBlock.Sizes.XS);
        womenJacketPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedSize().equals(FilterContentBlock.Sizes.XS.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectSize(FilterContentBlock.Sizes.S);
        womenJacketPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedSize().equals(FilterContentBlock.Sizes.S.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectSize(FilterContentBlock.Sizes.M);
        womenJacketPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedSize().equals(FilterContentBlock.Sizes.M.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectSize(FilterContentBlock.Sizes.L);
        womenJacketPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedSize().equals(FilterContentBlock.Sizes.L.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectSize(FilterContentBlock.Sizes.XL);
        womenJacketPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedSize().equals(FilterContentBlock.Sizes.XL.name())));
        filterContentBlock.clearAllFilters();
        Assert.assertFalse(filterContentBlock.isAnyFilterApplied());

    }

    @Test
    public void priceFilteringTest() {
        HomePage homePage = new HomePage(getDriver());
        NavigationBar navigationBar = homePage.getNavigationBar();
        MenPantsPage menPantsPage = navigationBar.openMenPantsPage();
        FilterContentBlock filterContentBlock = menPantsPage.getFilterContentBlock();
        Assert.assertFalse(filterContentBlock.isAnyFilterApplied());
        filterContentBlock.selectColor(FilterContentBlock.Colors.BLACK);
        menPantsPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedColor().equals(FilterContentBlock.Colors.BLACK.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectColor(FilterContentBlock.Colors.BLUE);
        menPantsPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedColor().equals(FilterContentBlock.Colors.BLUE.name())));
        filterContentBlock.clearAllFilters();
        filterContentBlock.selectColor(FilterContentBlock.Colors.ORANGE);
        menPantsPage.getItems().forEach(item ->
                Assert.assertTrue(item.getSelectedColor().equals(FilterContentBlock.Colors.ORANGE.name())));
        filterContentBlock.clearAllFilters();
        Assert.assertFalse(filterContentBlock.isAnyFilterApplied());
    }

}
