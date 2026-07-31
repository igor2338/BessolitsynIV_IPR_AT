package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Owner("Бессолицын Игорь")
public class HomeTest extends BaseTest {

    @Test(testName = "Проверка открытия главной страницы", priority = 1,
            description = "Проверка открытия главной страницы")
    @Description("Проверка открытия главной страницы")
    public void openLoginPageTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
    }

    @Test(testName = "Проверка наличия вкладок главной страницы", priority = 2,
            description = "Проверка наличия вкладок главной страницы")
    @Description("Проверка наличия вкладок главной страницы")
    public void checkTabElementsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkMainMenuTabs();
    }

    @Test(testName = "Проверка всплывающего окна вкладок главной страницы", priority = 3,
            description = "Проверка всплывающего окна вкладок главной страницы")
    @Description("Проверка всплывающего окна вкладок главной страницы")
    public void checkPopUpWindowTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkPopUpWindow();
    }

    @Test(testName = "Проверка вкладки Features", priority = 4,
            description = "Проверка вкладки Features")
    @Description("Проверка вкладки Features")
    public void checkFeaturesTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkFeatures();
    }

    @Test(testName = "Проверка вкладки Solutions", priority = 5,
            description = "Проверка вкладки Solutions")
    @Description("Проверка вкладки Solutions")
    public void checkSolutionsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkSolutions();
    }

    @Test(testName = "Проверка вкладки Plans", priority = 6,
            description = "Проверка вкладки Plans")
    @Description("Проверка вкладки Plans")
    public void checkPlansTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkPlans();
    }

    @Test(testName = "Проверка вкладки Resources", priority = 7,
            description = "Проверка вкладки Resources")
    @Description("Проверка вкладки Resources")
    public void checkResourcesTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkResources();
    }

    @Test(testName = "Проверка кликабельности элемента Pricing", priority = 8,
            description = "Проверка кликабельности элемента Pricing")
    @Description("Проверка кликабельности элемента Pricing")
    public void clickPricingTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickPricing();
    }

    @Test(testName = "Проверка подложки в поле для email", priority = 9,
            description = "Проверка подложки в поле для email")
    @Description("Проверка подложки в поле для email")
    public void checkPlaceholderTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkPlaceholder();
    }

    @Ignore("Не отрабатывает в GitHub Action")
    @Test(testName = "Проверка кликабельности кнопки SignUp", priority = 10,
            description = "Проверка кликабельности кнопки SignUp")
    @Description("Проверка кликабельности кнопки SignUp")
    public void checkButtonSignUpTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkButtonSignUp();
    }

    @Test(testName = "Проверка кликабельности точек-кнопок и отображение зависимостей", priority = 11,
            description = "Проверка кликабельности точек-кнопок и отображение зависимостей")
    @Description("Проверка кликабельности точек-кнопок и отображение зависимостей")
    public void clickButtonDotsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickDotButtons();
    }

    @Ignore("Не отрабатывает в GitHub Action")
    @Test(testName = "Проверка hover эффекта бело-синих кнопок", priority = 12,
            description = "Проверка hover эффекта бело-синих кнопок")
    @Description("Проверка hover эффекта бело-синих кнопок")
    public void checkHoverWhiteAndBlueButtonsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.checkHoverWhiteAndBlueButtons();
    }

    @Test(testName = "Проверка кликабельности бело-синих кнопок", priority = 13,
            description = "Проверка кликабельности бело-синих кнопок")
    @Description("Проверка кликабельности бело-синих кнопок")
    public void clickWhiteAndBlueButtonsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickWhiteAndBlueButtons();
    }
}
