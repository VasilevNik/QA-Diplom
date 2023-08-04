package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.DataSQL;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardPayment {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @BeforeEach
    void openPage() {
        open("http://localhost:8080");
    }

    @AfterEach
    void cleanBase() {
        DataSQL.cleanDataBase();
    }

    @Test
    public void allValuesEnteredCorrectlyStatusApproved() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getApprovedCard());
        payment.successPayment();
        assertEquals("APPROVED", DataSQL.getCreditStatus());
    }

    @Test
    //Завести ишью, операция проходит успешно
    public void allValuesEnteredCorrectlyStatusDeclined() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getDeclinedCard());
        payment.errorPayment();
        assertEquals("DECLINED", DataSQL.getCreditStatus());
    }

    @Test
    public void enteringCardNumberFewerDigits() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getAnInvalidCard());
        payment.errorFormat();
    }

    @Test
    public void enteringNonExistingCardNumber() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getNonexistentCard());
        payment.errorPayment();
    }

    @Test
    public void emptyCardNumberField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getEmptyCard());
        payment.errorFormat();
    }

    @Test
    public void oneDigitMonthField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardWith1MonthSymbol());
        payment.errorFormat();
    }

    @Test
    public void entering13InMonthField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardExceeding12Months());
        payment.incorrectlyValuesSpecified();
    }

    @Test
    public void enteringValueBelowCurrentInMonthField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardBelowCurrentMonthThisYear());
        payment.incorrectlyValuesSpecified();
    }

    @Test
    public void enteringNullValuesMonthField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardNullMonth());
        payment.incorrectlyValuesSpecified();
    }

    @Test
    public void emptyMonthField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardEmptyMonth());
        payment.errorFormat();
    }

    @Test
    public void oneDigitYearField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardWith1YearSymbol());
        payment.errorFormat();
    }

    @Test
    public void enteringExpiredCardValues() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardWithAnExpiredYear());
        payment.cardExpiredError();
    }

    @Test
    public void enteringCardValuesExceeding5Years() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardExceeding5Years());
        payment.incorrectlyValuesSpecified();
    }

    @Test
    public void enteringNullValuesYearField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardNullYear());
        payment.cardExpiredError();
    }

    @Test
    public void emptyYearField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardEmptyYear());
        payment.errorFormat();
    }

    @Test
    //Завести ишью, проходит кириллица
    public void enteringCyrillicInCardHolderField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardHolderCyrillic());
        payment.errorFormat();
    }

    @Test
    //Завести ишью, в поле владелец проходят цифры
    public void enteringDigitInCardHolderField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardHolderNumbers());
        payment.errorFormat();
    }

    @Test
    //Завести ишью, в поле владелец проходят спец символы
    public void enteringSpecialCharactersInCardHolderField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardHolderSpecialSymbols());
        payment.errorFormat();
    }

    @Test
    public void emptyCardHolderField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardHolderEmpty());
        payment.requiredField();
    }

    @Test
    public void oneDigitCvcCvvField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardWith1CVVSymbol());
        payment.errorFormat();
    }

    @Test
    public void twoDigitCvcCvvField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardWith2CVVSymbol());
        payment.errorFormat();
    }

    @Test
    //завести ишью, проходит cvc с нулями
    public void enteringNullValuesCvcCvvField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardNullCVV());
        payment.errorFormat();
    }

    @Test
    //Завести ишью. Неверная ошибка под полем cvc(Неверный формат),
    //и ненужная ошибка под полем Владелец(Поле обязательно для заполнения)
    public void emptyCvcCvvField() {
        val startPage = new StartPage();
        val payment = startPage.creditCard();
        payment.fillingDataCreditCard(DataHelper.getCardEmptyCVV());
        payment.requiredField();
    }
}
