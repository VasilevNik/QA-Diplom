package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement buyButton = $(byText("Купить"));
    private SelenideElement creditButton = $(byText("Купить в кредит"));

    public PaymentPage cashCard() {
        buyButton.click();
        return new PaymentPage();
    }

    public CreditPage creditCard() {
        creditButton.click();
        return new CreditPage();
    }
}
