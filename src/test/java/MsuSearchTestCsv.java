import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MsuSearchTestCsv {

    @BeforeEach
    void SetUp(){
            open("https://international.msu.ru/");
    }


    @CsvSource({
            "RU, Home",
            "RU, For partners",
            "RU, For MSU students",
            "RU, News",
            "RU, Contacts"
    })
    @ParameterizedTest (name = "Отображение поля {1} при возможности сменить локаль на {0}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void msuSearchTest(String locale, String button) {
        $$(".t228__list").find(Condition.text(button)).shouldHave(Condition.text(button));

    }


}
