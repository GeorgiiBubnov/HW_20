package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {
    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }


    @Test
    @DisplayName("Проверка описание статьи")
    void checkDescriptionTest() {
        //back();

        step("Отправляем запрос на поиск", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверяем описание", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_description")).shouldHave(text("Automation for Apps")));
    }


        @Test
        @DisplayName("Проверка наличия заголовка")
        void checkNewsHeaderTest () {
            step("Проверка наличия заголовка в новостях", () -> {
                $(id("org.wikipedia.alpha:id/view_card_header_title")).shouldHave(text("In the news"));
            });
        }


    }

