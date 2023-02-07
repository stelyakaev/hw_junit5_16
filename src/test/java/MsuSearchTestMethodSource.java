import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MsuSearchTestMethodSource {

    @BeforeEach
    void SetUp(){
            open("https://international.msu.ru/");
    }


    static Stream<Arguments> msuSearchTest(){
        return Stream.of(
                Arguments.of(List.of("Home", "For partners", "For MSU students", "News", "Contacts"))
               );
    }

    @MethodSource
    @ParameterizedTest(name = "Отображение полей из списка {1} в главном меню")
    @Tag("BLOCKER")
    void msuSearchTest(List<String> buttons){
        $$(".t228__list_item").filter(visible).shouldHave(CollectionCondition.texts(buttons));
    }


}
