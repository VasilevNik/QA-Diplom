package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private SelenideElement heading = $$("h3").find(exactText("Оплата по карте"));
    private SelenideElement cardField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $(By.xpath("//span[text()='Владелец']/..//input"));
    private SelenideElement cvvField = $("[placeholder='999']");


    private SelenideElement approvedOperation = $(byText("Успешно"));
    private SelenideElement errorOperation = $(byText("Ошибка"));
    private SelenideElement invalidFormat = $(byText("Неверный формат"));
    private SelenideElement validityPeriodCardSpecifiedIncorrectly = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpired = $(byText("Истёк срок действия карты"));
    private SelenideElement requiredFieldFilling = $(byText("Поле обязательно для заполнения"));

    private SelenideElement continueButton = $(byText("Продолжить"));


    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void fillingData(DataHelper.CardInfo cardInfo) {
        cardField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        cardHolderField.setValue(cardInfo.getCardHolder());
        cvvField.setValue(cardInfo.getCvv());
        continueButton.click();
    }

    public void successPayment() {
        approvedOperation.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void errorPayment() {
        errorOperation.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void errorFormat() {
        invalidFormat.shouldBe(visible);
    }

    public void incorrectlyValuesSpecified() {
        validityPeriodCardSpecifiedIncorrectly.shouldBe(visible);
    }

    public void cardExpiredError() {
        cardExpired.shouldBe(visible);
    }

    public void requiredField() {
        requiredFieldFilling.shouldBe(visible);
    }
}
