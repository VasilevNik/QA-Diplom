package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String cardHolder;
        private String cvv;
    }

    public static String getCurrentMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getLastMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getCurrentYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getLastYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getNextYear() {
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }

    static Faker faker = new Faker(new Locale("en"));

    public static String getCardHolder() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getCVV() {
        return Integer.toString(faker.number().numberBetween(100, 999));
    }


    public static CardInfo getApprovedCard() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo("4444 4444 4444 4442", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getAnInvalidCard() {
        return new CardInfo("4444 4444 4444 447", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getNonexistentCard() {
        return new CardInfo("4444 4444 4444 4477", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getEmptyCard() {
        return new CardInfo("", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardWith1MonthSymbol() {
        return new CardInfo("4444 4444 4444 4441", "2", getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardExceeding12Months() {
        return new CardInfo("4444 4444 4444 4441", "13", getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardBelowCurrentMonthThisYear() {
        return new CardInfo("4444 4444 4444 4441", getLastMonth(), getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardNullMonth() {
        return new CardInfo("4444 4444 4444 4441", "00", getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardEmptyMonth() {
        return new CardInfo("4444 4444 4444 4441", "", getCurrentYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardWith1YearSymbol() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "2", "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardWithAnExpiredYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getLastYear(), "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardExceeding5Years() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getNextYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardNullYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "00", "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardEmptyYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "", "Ivan Ivanov", getCVV());
    }

    public static CardInfo getCardHolderCyrillic() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Николай", getCVV());
    }

    public static CardInfo getCardHolderNumbers() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "777", getCVV());
    }

    public static CardInfo getCardHolderSpecialSymbols() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "_$%#№", getCVV());
    }

    public static CardInfo getCardHolderEmpty() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "", getCVV());
    }

    public static CardInfo getCardWith1CVVSymbol() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", "2");
    }

    public static CardInfo getCardWith2CVVSymbol() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", "22");
    }

    public static CardInfo getCardNullCVV() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", "000");
    }

    public static CardInfo getCardEmptyCVV() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), "Ivan Ivanov", "");
    }
}
