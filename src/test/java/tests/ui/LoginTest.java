package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

@Owner("Бессолицын Игорь")
public class LoginTest extends BaseTest {

    @Test(testName = "Проверка открытия страницы авторизации", priority = 1,
            description = "Проверка открытия страницы авторизации")
    @Description("Проверка открытия страницы авторизации")
    public void openLoginPageTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
    }

    @Test(testName = "Проверка сообщения пустого email", priority = 2,
            description = "Проверка сообщения пустого email")
    @Description("Проверка сообщения пустого email")
    public void checkEmailEmptyTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
        loginPage.checkEmailEmpty();
    }

    @Test(testName = "Проверка сообщения некорректного email", priority = 3,
            description = "Проверка сообщения некорректного email")
    @Description("Проверка сообщения некорректного email")
    public void checkEmailIncorrectTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
        loginPage.checkEmailIncorrect();
    }

    @Test(testName = "Проверка чекбокса Запомнить меня", priority = 4,
            description = "Проверка чекбокса Запомнить меня")
    @Description("Проверка чекбокса Запомнить меня")
    public void checkCheckboxTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkCheckbox();
    }

    @Test(testName = "Проверка наличия кнопок авторизации", priority = 5,
            description = "Проверка наличия кнопок авторизации")
    @Description("Проверка наличия кнопок авторизации")
    public void checkAuthorizationButtonsTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
        loginPage.checkAuthorizationButtons();
    }

    @Test(testName = "Проверка функции Forgot Password", priority = 6,
            description = "Проверка функции Forgot Password")
    @Description("Проверка функции Forgot Password")
    public void checkForgotPassTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
        loginPage.checkForgotPass();
    }

    @Test(testName = "Проверка авторизации, позитивный сценарий", priority = 7,
            description = "Проверка авторизации, позитивный сценарий")
    @Description("Проверка авторизации, позитивный сценарий")
    public void checkAuthorizationPositiveTest() {
        homePage.openHomePage();
        homePage.isHomePageOpened();
        homePage.clickLogIn();
        loginPage.checkLoginToContinueElement();
        loginPage.checkAuthorizationPositive();
    }
}
