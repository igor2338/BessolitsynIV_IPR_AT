package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import tests.ui.SlideData;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class HomePage {

    private static final String
            ELEMENT_LOG_IN = "a[data-testid = 'login']",
            ELEMENT_LOGIN = "//a[@data-testid = 'login']",
            MAIN_MENU_TAB = "button[data-testid='bignav-tab']",
            TAB_FEATURES = "//button[text()='Features']",
            TAB_SOLUTIONS = "//header//div//div//div//button[@data-testid='bignav-tab'] [text()='Solutions']",
            TAB_PLANS = "//header//div//div//div//button[@data-testid='bignav-tab'] [text()='Plans']",
            TAB_RESOURCES = "//header//div//div//div//button[@data-testid='bignav-tab'] [text()='Resources']",
            MAIN_MENU_TAB_PRICING = "//a[text() = 'Pricing']",
            PLACEHOLDER_ELEMENT = "input[placeholder='Email']",
            SIGN_UP_BUTTON = "//button[text() = 'Sign up - it’s free!']",
            SIGN_UP_BUTTON_CHECK_URL = "/signup?application=trello--direct-signup&continue=https",
            MAIN_MENU_TAB_FEATURES_CHECK = "//h3[text()='Explore the features that help your team succeed']",
            MAIN_MENU_TAB_SOLUTIONS_CHECK = "//h3[text()='Take a page out of these pre-built Trello playbooks designed for all teams']",
            MAIN_MENU_TAB_PLANS_CHECK = "//p[text()='For individuals or small teams looking to keep work organized.']",
            MAIN_MENU_TAB_RESOURCES_CHECK = "//h3[text()='Learn & connect']",
            MAIN_MENU_TAB_PRICING_CHECK = "//h1[text() = 'Trello your way.']",
            TAB_FEATURES_INBOX = "//nav//a//p[text()='Inbox']",
            TAB_FEATURES_INBOX_CHECK = "//h1[text()='Trello Inbox']",
            TAB_FEATURES_AUTOMATION = "//nav//a//div//p[text()='Automation']",
            TAB_FEATURES_AUTOMATION_CHECK = "//h1[text()='Automate your workflow with Trello']",
            TAB_FEATURES_TEMPLATES = "//nav//a//div//p[text()='Templates']",
            TAB_FEATURES_TEMPLATES_CHECK = "//span[@data-testid='SearchIcon']",
            TAB_FEATURES_INTEGRATION = "//nav//a//div//p[text()='Integrations']",
            TAB_FEATURES_INTEGRATION_CHECK = "//h1[text()='Connect Trello to everything']",
            TAB_FEATURES_POWER = "//nav//a//div//p[text()='Power-Ups']",
            TAB_FEATURES_POWER_CHECK = "//span[@data-testid='PowerUpIcon']",
            TAB_FEATURES_PLANNER = "//nav//a//div//p[text()='Planner']",
            TAB_FEATURES_PLANNER_CHECK = "//h1[text()='Trello Planner']",
            TAB_SOLUTIONS_MARKET = "//nav//a//p[text()='Marketing teams']",
            TAB_SOLUTIONS_MARKET_CHECK = "//h1[text()='Trello For Marketing Teams']",
            TAB_SOLUTIONS_PRODUCT = "//nav//a//div//p[text()='Product management']",
            TAB_SOLUTIONS_PRODUCT_CHECK = "//h1[text()='Trello For Product Management Teams']",
            TAB_SOLUTIONS_ENGINE = "//nav//a//div//p[text()='Engineering teams']",
            TAB_SOLUTIONS_ENGINE_CHECK = "//h1[text()='Trello for Engineering Teams']",
            TAB_SOLUTIONS_DESIGN = "//nav//a//div//p[text()='Design teams']",
            TAB_SOLUTIONS_DESIGN_CHECK = "//h1[text()='Trello For Design Teams']",
            TAB_SOLUTIONS_STARTUPS = "//nav//a//div//p[text()='Startups']",
            TAB_SOLUTIONS_STARTUPS_CHECK = "//div//h1[text()='Trello For Startups']",
            TAB_SOLUTIONS_REMOTE = "//nav//a//div//p[text()='Remote teams']",
            TAB_SOLUTIONS_REMOTE_CHECK = "//h1[text()='Trello For Remote Teams']",
            TAB_SOLUTIONS_CASES = "//div//a[text()='See all use cases'] [@href='/use-cases']",
            TAB_SOLUTIONS_CASES_CHECK = "//h1[text()='See Trello in action']",
            TAB_PLANS_STANDARD = "//nav//a//div//p[text()='Standard']",
            TAB_PLANS_STANDARD_CHECK = "//h1[text()='Trello Standard']",
            TAB_PLANS_PREMIUM = "//nav//a//div//p[text()='Premium']",
            TAB_PLANS_PREMIUM_CHECK = "//h1[text()='Trello Premium']",
            TAB_PLANS_ENTERPRISE = "//nav//a//div//p[text()='Enterprise']",
            TAB_PLANS_ENTERPRISE_CHECK = "//div//h1[text()='Trello Enterprise']",
            TAB_PLANS_TOUR = "//div//div//div//div//div//div//div//div//a//span[text()='Take a tour of Trello']",
            TAB_PLANS_TOUR_CHECK = "//h1[text()='Your productivity powerhouse']",
            TAB_PLANS_VIEW = "//div//div//div//div//div//div//div//div/div/div//a//span[text()='View Trello pricing']",
            TAB_PLANS_VIEW_CHECK = "//h1[text()='Trello your way.']",
            TAB_RESOURCES_GUIDE = "//nav//a//div//p[text()='Trello guide']",
            TAB_RESOURCES_GUIDE_CHECK = "//h1[text()='Getting started with Trello']",
            TAB_RESOURCES_REMOTE = "//nav//a//div//p[text()='Remote work guide']",
            TAB_RESOURCES_REMOTE_CHECK = "//h1[text()='How to embrace remote work']",
            TAB_RESOURCES_CUSTOMER = "//nav//a//div//p[text()='Customer stories']",
            TAB_RESOURCES_CUSTOMER_CHECK = "//h1[text()='Trello Customer Stories']",
            TAB_RESOURCES_HELP = "//nav//a//div//p[text()='Help resources']",
            TAB_RESOURCES_HELP_CHECK = "//h1[text()='Trello support']",
            TAB_RESOURCES_WEBINARS = "//nav//a//div//p[text()='Webinars']",
            TAB_RESOURCES_WEBINARS_CHECK = "//h1[text()='Trello Webinars']",
            TAB_RESOURCES_DEVELOPER = "//nav//a//div//p[text()='Developers']",
            TAB_RESOURCES_DEVELOPER_CHECK = "//div//div//div//div//div//div//div//div//a[text()='Developer'] [@aria-label='Developer home']",
            DOT_BUTTON = "[data-testid^='dot_']",
            DOT_SLIDE = "//h4[text()='",
            DOT_IMG = "img[alt='",
            WHITE_BLUE_BUTTON_INTEGRATIONS = "(//a[@data-uuid and @href='/integrations'])[3]",
            WHITE_BLUE_BUTTON_AUTOMATION = "(//a[@data-uuid and @href='/butler-automation'])[3]",
            WHITE_BLUE_BUTTON_PRICING = "(//a[@data-uuid and @href='/pricing'])[3]",
            WHITE_BLUE_BUTTON_INTEGRATIONS_CHECK = "//h2[text()='Featured integrations']",
            WHITE_BLUE_BUTTON_AUTOMATION_CHECK = "//h1[text()='Automate your workflow with Trello']",
            WHITE_BLUE_BUTTON_PRICING_CHECK = "//h1[text()='Trello your way.']";

    @Step("Открытие главной страницы")
    public void openHomePage() {
        log.info("Open login page");
        open();
    }

    @Step("Проверка отображения элементов Log In")
    public void isHomePageOpened() {
        log.info("Check elements Log In");
        $$(ELEMENT_LOG_IN).shouldBe(size(1));
    }


    @Step("Проверка отображения главного меню")
    public void checkMainMenuTabs() {
        log.info("Check main menu tabs");
        $$(MAIN_MENU_TAB).shouldHave(CollectionCondition.texts("Features", "Solutions", "Plans", "Resources"));
        $x(MAIN_MENU_TAB_PRICING).shouldHave();
    }

    @Step("Проверка отображения всплывающего окна")
    public void checkPopUpWindow() {
        log.info("Check pop-up window");
        Map<String, String> expectedMatches = Map.of(
                "Features", MAIN_MENU_TAB_FEATURES_CHECK,
                "Solutions", MAIN_MENU_TAB_SOLUTIONS_CHECK,
                "Plans", MAIN_MENU_TAB_PLANS_CHECK,
                "Resources", MAIN_MENU_TAB_RESOURCES_CHECK);
        expectedMatches.forEach((buttonText, elementSelector) -> {
            $(MAIN_MENU_TAB).click();
            $x(elementSelector).shouldBe(Condition.exist, Duration.ofSeconds(8));
        });
    }

    @Step("Проверка элемента Pricing")
    public void clickPricing() {
        log.info("Click Pricing");
        $x(MAIN_MENU_TAB_PRICING).shouldBe().click();
        sleep(2000);
        $x(MAIN_MENU_TAB_PRICING_CHECK).shouldBe(visible, Duration.ofSeconds(8));
    }

    @Step("Проверка элемента Placeholder")
    public void checkPlaceholder() {
        log.info("Check Placeholder");
        ElementsCollection emailFields = $$(PLACEHOLDER_ELEMENT);
        emailFields.get(0).shouldHave(Condition.attribute("placeholder", "Email"));
        emailFields.get(1).shouldHave(Condition.attribute("placeholder", "Email"));
    }

    @Step("Проверка кнопки Sign up")
    public void checkButtonSignUp() {
        log.info("Check ButtonSignUp");
        String buttonSelector = SIGN_UP_BUTTON;
        $$x(buttonSelector).get(0).click();
        webdriver().shouldHave(WebDriverConditions.urlContaining(SIGN_UP_BUTTON_CHECK_URL));
        back();
        $$x(buttonSelector).get(0).shouldBe(visible);
        $$x(buttonSelector).get(1).click();
        webdriver().shouldHave(WebDriverConditions.urlContaining(SIGN_UP_BUTTON_CHECK_URL));
        back();
    }

    @Step("Проверка Features")
    public void checkFeatures() {
        Map<String, String> steps = new LinkedHashMap<>();
        steps.put(TAB_FEATURES_INBOX, TAB_FEATURES_INBOX_CHECK);
        steps.put(TAB_FEATURES_AUTOMATION, TAB_FEATURES_AUTOMATION_CHECK);
        steps.put(TAB_FEATURES_TEMPLATES, TAB_FEATURES_TEMPLATES_CHECK);
        steps.put(TAB_FEATURES_INTEGRATION, TAB_FEATURES_INTEGRATION_CHECK);
        steps.put(TAB_FEATURES_POWER, TAB_FEATURES_POWER_CHECK);
        steps.put(TAB_FEATURES_PLANNER, TAB_FEATURES_PLANNER_CHECK);
        steps.forEach((buttonLocator, elementLocator) -> {
            log.info("Click Features");
            $x(TAB_FEATURES).click();
            sleep(1000);
            log.info("Click on links Features");
            $x(buttonLocator).click();
            sleep(1000);
            $x(elementLocator).shouldBe(visible);
            sleep(2000);
            log.info("back Features, refresh");
            back();
            refresh();
            sleep(2000);
        });
    }

    @Step("Проверка Solutions")
    public void checkSolutions() {
        Map<String, String> steps = new LinkedHashMap<>();
        steps.put(TAB_SOLUTIONS_MARKET, TAB_SOLUTIONS_MARKET_CHECK);
        steps.put(TAB_SOLUTIONS_PRODUCT, TAB_SOLUTIONS_PRODUCT_CHECK);
        steps.put(TAB_SOLUTIONS_ENGINE, TAB_SOLUTIONS_ENGINE_CHECK);
        steps.put(TAB_SOLUTIONS_DESIGN, TAB_SOLUTIONS_DESIGN_CHECK);
        steps.put(TAB_SOLUTIONS_STARTUPS, TAB_SOLUTIONS_STARTUPS_CHECK);
        steps.put(TAB_SOLUTIONS_REMOTE, TAB_SOLUTIONS_REMOTE_CHECK);
        steps.put(TAB_SOLUTIONS_CASES, TAB_SOLUTIONS_CASES_CHECK);
        steps.forEach((buttonLocator, elementLocator) -> {
            log.info("Click Solutions");
            $x(TAB_SOLUTIONS).click();
            sleep(1000);
            log.info("Click on links Solutions");
            $x(buttonLocator).click();
            sleep(1000);
            log.info("Check element Solutions");
            $x(elementLocator).shouldBe(visible);
            sleep(2000);
            log.info("back Solutions, refresh");
            back();
            refresh();
            sleep(2000);
        });
    }

    @Step("Проверка Plans")
    public void checkPlans() {
        log.info("Click Plans");
        Map<String, String> steps = new LinkedHashMap<>();
        steps.put(TAB_PLANS_STANDARD, TAB_PLANS_STANDARD_CHECK);
        steps.put(TAB_PLANS_PREMIUM, TAB_PLANS_PREMIUM_CHECK);
        steps.put(TAB_PLANS_ENTERPRISE, TAB_PLANS_ENTERPRISE_CHECK);
        steps.put(TAB_PLANS_TOUR, TAB_PLANS_TOUR_CHECK);
        steps.put(TAB_PLANS_VIEW, TAB_PLANS_VIEW_CHECK);
        steps.forEach((buttonLocator, elementLocator) -> {
            log.info("Click Plans");
            $x(TAB_PLANS).click();
            sleep(1000);
            log.info("Click on links Plans");
            $x(buttonLocator).click();
            sleep(1000);
            log.info("Check element links Plans");
            $x(elementLocator).shouldBe(visible);
            sleep(2000);
            log.info("back Plans, refresh");
            back();
            refresh();
            sleep(2000);
        });
    }

    @Step("Проверка Resources")
    public void checkResources() {
        log.info("Click Resources");
        Map<String, String> steps = new LinkedHashMap<>();
        steps.put(TAB_RESOURCES_GUIDE, TAB_RESOURCES_GUIDE_CHECK);
        steps.put(TAB_RESOURCES_REMOTE, TAB_RESOURCES_REMOTE_CHECK);
        steps.put(TAB_RESOURCES_CUSTOMER, TAB_RESOURCES_CUSTOMER_CHECK);
        steps.put(TAB_RESOURCES_HELP, TAB_RESOURCES_HELP_CHECK);
        steps.put(TAB_RESOURCES_WEBINARS, TAB_RESOURCES_WEBINARS_CHECK);
        steps.put(TAB_RESOURCES_DEVELOPER, TAB_RESOURCES_DEVELOPER_CHECK);
        steps.forEach((buttonLocator, elementLocator) -> {
            log.info("Click Resources");
            $x(TAB_RESOURCES).click();
            sleep(1000);
            log.info("Click on links Resources");
            $x(buttonLocator).click();
            sleep(1000);
            log.info("Check element");
            $x(elementLocator).shouldBe(visible);
            sleep(2000);
            log.info("back Resources, refresh");
            back();
            refresh();
            sleep(2000);
        });
    }

    @Step("Проверка элемента Log In")
    public void clickLogIn() {
        log.info("Click Log In");
        $x(ELEMENT_LOGIN).shouldBe().click();
    }


    @Step("Проверка точек-кнопок и их зависимостей")
    public void clickDotButtons() {
        Map<Integer, SlideData> slidesData = new LinkedHashMap<>();
        slidesData.put(0, new SlideData("Inbox", "Illustration of a team Trello Board"));
        slidesData.put(1, new SlideData("Boards", "An illustration of a list on a Trello board"));
        slidesData.put(2, new SlideData("Planner", "An illustration of Trello Planner"));

        for (int i = 0; i < 3; i++) {
            var currentSlide = slidesData.get(i);
            var dot = $$(DOT_BUTTON).get(i);
            log.info("Click dot button");
            dot.shouldBe(Condition.visible, Condition.enabled).click();

            var title = $x(DOT_SLIDE + currentSlide.getTitleText() + "']");
            title.scrollIntoView(true);
            log.info("Check title text");
            title.shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .shouldHave(Condition.exactText(currentSlide.getTitleText()));

            var imageSelector = DOT_IMG + currentSlide.getImageAlt() + "']";
            var image = $(imageSelector);
            image.scrollIntoView(true);
            log.info("Check image alt");
            image.shouldBe(Condition.visible, Duration.ofSeconds(10));
        }
    }

    @Step("Проверка ховер эффекта бело-синих кнопок")
    public void checkHoverWhiteAndBlueButtons() {
        log.info("Check hover white and blue buttons");
        List<String> hoverElements = List.of(
                WHITE_BLUE_BUTTON_INTEGRATIONS,
                WHITE_BLUE_BUTTON_AUTOMATION,
                WHITE_BLUE_BUTTON_PRICING
        );
        String normalColor = "rgba(255, 255, 255, 1)";
        String hoverColor = "rgba(222, 235, 255, 1)";
        hoverElements.forEach(selector -> {
            log.info("Check default color");
            $x(selector).shouldBe(Condition.exist).shouldHave(Condition.cssValue("background-color", normalColor));
            sleep(2000);
            log.info("Cursor on the button");
            $x(selector).hover();
            sleep(2000);
            log.info("Check color hover");
            $x(selector).shouldBe(Condition.exist).shouldHave(Condition.cssValue("background-color", hoverColor));
            sleep(2000);
            log.info("Cursor on body");
            $("body").hover();
        });
    }

    @Step("Проверка кликабельности бело-синих кнопок")
    public void clickWhiteAndBlueButtons() {
        Map<String, String> steps = new LinkedHashMap<>();
        steps.put(WHITE_BLUE_BUTTON_INTEGRATIONS, WHITE_BLUE_BUTTON_INTEGRATIONS_CHECK);
        steps.put(WHITE_BLUE_BUTTON_AUTOMATION, WHITE_BLUE_BUTTON_AUTOMATION_CHECK);
        steps.put(WHITE_BLUE_BUTTON_PRICING, WHITE_BLUE_BUTTON_PRICING_CHECK);
        steps.forEach((buttonLocator, elementLocator) -> {
            log.info("Click white and blue buttons");
            $x(buttonLocator).click();
            log.info("Check opened page");
            $x(elementLocator).shouldBe(visible);
            log.info("back");
            back();
        });
    }
}
