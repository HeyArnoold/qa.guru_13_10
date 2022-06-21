import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps extends TestBase{

    @Step("Открываем страницу дебетовых карт")
    public void openDebitCardPage() {
        open("cards/debit-cards/");
    }

    @Step("Кликаем на 'Предпочтения по карте'")
    public void clickOnCardPreferences() {
        $(".cb3AmHFyX").click();
    }

    @Step("Выбираем 'Классические' и нажимаем 'Показать карты'")
    public void chooseClassicAndSubmit() {
        $("[data-index=\"0\"]").click();
        $$(".cb29uWLSI").filterBy(exactText("Показать карты")).get(0).click();
    }

    @Step("Проверяем, что следующая карта, после основной - это карта Tinkoff Black Мир")
    public void checkFirstCardOnPage() {
        $$(".jb1EpsJw2 .ab1ZY3cgg").get(1).shouldHave(text("Дебетовая карта Tinkoff Black МИР"));
    }
}
