package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {

    private static final String
            trelloUser = System.getProperty("trelloUser"),
            trelloPassword = System.getProperty("trelloPassword"),
            ELEMENT_LOG_IN_MESSAGE = "//h1[text()='Войдите, чтобы продолжить']",
            ELEMENT_PLACEHOLDER_MAIL = "//input[@placeholder='Введите адрес электронной почты']",
            ELEMENT_PLACEHOLDER_PASS = "#password",
            BUTTON_CONTINUE_LOGIN = "#login-submit",
            ELEMENT_RESET_PASS = "#resetPassword",
            ERROR_MESSAGE_EMPTY_EMAIL = "//div//div//div//div[text()='Введите адрес электронной почты']",
            ERROR_MESSAGE_INCORRECT_EMAIL = "//div//div//div//div[text()='Адрес электронной почты должен содержать текст до и после символа «@»']",
            ELEMENT_CHECKBOX_REMEMBER = "//input[@type='checkbox'] [@name='remember']",
            BUTTON_PASSKEY = "//span[text()='Passkey']",
            BUTTON_GOOGLE = "//span[text()='Google']",
            BUTTON_MS = "//span[text()='Microsoft']",
            BUTTON_APPLE = "//span[text()='Apple']",
            BUTTON_SLACK = "//span[text()='Slack']",
            FORGOT_PASS_CHECK_MESSAGE = "//h1[text()='Не удается войти в систему?']",
            AUTHORIZATION_CHECK_TWO_FACTOR = "//h1[text()='Вам отправлен код по электронной почте']";

    @Step("Проверка отображения элемента 'Войдите, чтобы продолжить'")
    public void checkLoginToContinueElement() {
        log.info("Check Login to continue element");
        $x(ELEMENT_LOG_IN_MESSAGE).shouldBe(Condition.exist, Duration.ofSeconds(8));
    }

    @Step("Проверка отображения ошибки при пустом email")
    public void checkEmailEmpty() {
        sleep(4000);
        log.info("Check email empty, enter");
        $x(ELEMENT_PLACEHOLDER_MAIL).setValue("").pressEnter();
        sleep(4000);
        log.info("Check error message email empty");
        $x(ERROR_MESSAGE_EMPTY_EMAIL).shouldBe(Condition.exist);
    }

    @Step("Проверка отображения ошибки некоректного email")
    public void checkEmailIncorrect() {
        sleep(4000);
        log.info("Check email incorrect, enter");
        $x(ELEMENT_PLACEHOLDER_MAIL).setValue("qwqw").pressEnter();
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
        $x(FORGOT_PASS_CHECK_MESSAGE).shouldBe(Condition.exist);
    }

    @Step("Проверка авторизции позитивный сценарий")
    public void checkAuthorizationPositive() {
        sleep(2000);
        log.info("Check authorization positive. Login entry");
        $x(ELEMENT_PLACEHOLDER_MAIL).setValue(trelloUser);
        sleep(2000);
        log.info("Click button continue");
        $(BUTTON_CONTINUE_LOGIN).shouldBe().click();
        sleep(4000);
        log.info("Password entry");
        $(ELEMENT_PLACEHOLDER_PASS).setValue(trelloPassword);
        sleep(2000);
        log.info("Click button log in");
        $(BUTTON_CONTINUE_LOGIN).shouldBe().click();
        sleep(2000);
        log.info("Check two-factor message");
        $x(AUTHORIZATION_CHECK_TWO_FACTOR).shouldBe(Condition.exist);
    }
}
