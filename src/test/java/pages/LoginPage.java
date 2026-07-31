package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {
    String
            trelloUser = System.getProperty("trelloUser", PropertyReader.getProperty("trelloUser")),
            trelloPassword = System.getProperty("trelloPassword", PropertyReader.getProperty("trelloPassword"));

    private static final String
            ELEMENT_LOG_IN_MESSAGE = "div[data-testid='header-suffix'][id='ProductHeadingSuffix']",
            ELEMENT_PLACEHOLDER_MAIL = "#username-uid1",
            ELEMENT_PLACEHOLDER_PASS = "#password",
            BUTTON_CONTINUE_LOGIN = "#login-submit",
            ELEMENT_RESET_PASS = "#resetPassword",
            ERROR_MESSAGE_EMPTY_EMAIL = "#username-uid1-error",
            ERROR_MESSAGE_INCORRECT_EMAIL = "//div//div//div//div[contains(text(),'@')]",
            ELEMENT_CHECKBOX_REMEMBER = "//input[@type='checkbox'] [@name='remember']",
            BUTTON_PASSKEY = "//span[text()='Passkey']",
            BUTTON_GOOGLE = "//span[text()='Google']",
            BUTTON_MS = "//span[text()='Microsoft']",
            BUTTON_APPLE = "//span[text()='Apple']",
            BUTTON_SLACK = "//span[text()='Slack']",
            FORGOT_PASS_CHECK_ELEMENT = "#reset-password-email-submit",
            AUTHORIZATION_CHECK_TWO_FACTOR = "div[data-testid='otp-input-index-0-container']";

    @Step("Проверка отображения элемента 'Войдите, чтобы продолжить'")
    public void checkLoginToContinueElement() {
        log.info("Check Login to continue element");
        $(ELEMENT_LOG_IN_MESSAGE).shouldBe(Condition.exist, Duration.ofSeconds(8));
    }

    @Step("Проверка отображения ошибки при пустом email")
    public void checkEmailEmpty() {
        sleep(4000);
        log.info("Check email empty, enter");
        $(ELEMENT_PLACEHOLDER_MAIL).setValue("").pressEnter();
        sleep(4000);
        log.info("Check error message email empty");
        $(ERROR_MESSAGE_EMPTY_EMAIL).shouldBe(Condition.exist);
    }

    @Step("Проверка отображения ошибки некоректного email")
    public void checkEmailIncorrect() {
        sleep(4000);
        log.info("Check email incorrect, enter");
        $(ELEMENT_PLACEHOLDER_MAIL).setValue("qwqw").pressEnter();
        sleep(4000);
        log.info("Check error message email incorrect");
        $x(ERROR_MESSAGE_INCORRECT_EMAIL).shouldBe(Condition.exist);
    }

    @Step("Проверка отображения чекбокса 'Запонить меня'")
    public void checkCheckbox() {
        log.info("Check checkbox");
        $x(ELEMENT_CHECKBOX_REMEMBER).shouldNotBe(checked);
        sleep(2000);
    }

    @Step("Проверка отображения кнопок авторизации")
    public void checkAuthorizationButtons() {
        log.info("Check authorization buttons");
        List<String> authorizationElements = List.of(
                BUTTON_PASSKEY,
                BUTTON_GOOGLE,
                BUTTON_MS,
                BUTTON_APPLE,
                BUTTON_SLACK
        );
        authorizationElements.forEach(selector -> {
            log.info("Check authorization button");
            $x(selector).shouldHave();
            sleep(2000);
        });
    }

    @Step("Проверка функции Forgot Password")
    public void checkForgotPass() {
        sleep(4000);
        log.info("Check Forgot Password element, click");
        $(ELEMENT_RESET_PASS).shouldBe().click();
        sleep(2000);
        log.info("Check Forgot Password message");
        $(FORGOT_PASS_CHECK_ELEMENT).shouldBe(Condition.exist);
    }

    @Step("Проверка авторизции позитивный сценарий")
    public void checkAuthorizationPositive() {
        sleep(2000);
        log.info("Check authorization positive. Login entry");
        $(ELEMENT_PLACEHOLDER_MAIL).setValue(trelloUser);
        sleep(2000);
        log.info("Click button continue");
        $(BUTTON_CONTINUE_LOGIN).shouldBe().click();
        sleep(8000);
        log.info("Password entry");
        $(ELEMENT_PLACEHOLDER_PASS).setValue(trelloPassword);
        sleep(2000);
        log.info("Click button log in");
        $(BUTTON_CONTINUE_LOGIN).shouldBe().click();
        sleep(2000);
        log.info("Check two-factor message");
        $(AUTHORIZATION_CHECK_TWO_FACTOR).shouldBe(Condition.exist);
    }
}
