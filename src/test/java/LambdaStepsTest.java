import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

class LambdaStepsTest extends TestBase{


    @Test
    @Owner("Max")
    @Severity(SeverityLevel.MINOR)
    @Feature("Приоритет продукта")
    @Story("Первый продукт должно предлагать карту МИР")
    @DisplayName("Priority of Debit Card")
    @Description("Этот тест проверяет на какой позиции в списке находиться карта МИР")
    @Link(name = "Tinkoff", url = "https://www.tinkoff.ru/")
    void debitCardTest() {
        step("Открываем страницу дебетовых карт", () -> {
            open("cards/debit-cards/");
        });

        step("Кликаем на 'Предпочтения по карте'", () -> {
            $(".cb3AmHFyX").click();
        });

        step("Выбираем 'Классические' и нажимаем 'Показать карты'", () -> {
            $("[data-index=\"0\"]").click();
            $$(".cb29uWLSI").filterBy(exactText("Показать карты")).get(0).click();
        });

        step("Проверяем, что следующая карта, после основной - это карта Tinkoff Black Мир", () -> {
            $$(".jb1EpsJw2 .ab1ZY3cgg").get(1).shouldHave(text("Дебетовая карта Tinkoff Black МИР"));
        });
    }
}
