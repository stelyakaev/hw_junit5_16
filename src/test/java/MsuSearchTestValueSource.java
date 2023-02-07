import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MsuSearchTestValueSource {

    @BeforeEach
    void SetUp(){
            open("https://international.msu.ru/");
    }


    @ValueSource(strings = {
            "Home",
            "For partners",
            "For MSU students",
            "News",
            "Contacts"
    })
    @ParameterizedTest(name = "Отображение поля {0} в главном меню")
    @Tag("BLOCKER")
    void MsuMainMenu(String arg){
        $$(".t228__list").find(Condition.text(arg)).shouldHave(Condition.text(arg));
    }


}
