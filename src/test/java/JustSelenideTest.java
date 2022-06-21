import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class JustSelenideTest extends TestBase {

    @Test
    void debitCardTest() {
        //Открываем страницу дебетовых карт
        open("cards/debit-cards/");

        //Кликаем на "Предпочтения по карте"
        $(".cb3AmHFyX").click();

        //Выбираем "Классические" и нажимаем "Показать карты"
        $("[data-index=\"0\"]").click();
        $$(".cb29uWLSI").filterBy(exactText("Показать карты")).get(0).click();

        // Проверяем, что следующая карта, после основной - это карта Tinkoff Black Мир
        $$(".jb1EpsJw2 .ab1ZY3cgg").get(1).shouldHave(text("Дебетовая карта Tinkoff Black МИР"));
    }
}
