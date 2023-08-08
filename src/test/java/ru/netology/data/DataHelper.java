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

    public static String getCardHolder() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getCardHolderNameCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getCVV() {
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(100, 999));
    }


    public static CardInfo getApprovedCard() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo("4444 4444 4444 4442", getCurrentMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getAnInvalidCard() {
        return new CardInfo("4444 4444 4444 447", getCurrentMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getNonexistentCard() {
        return new CardInfo("4444 4444 4444 4477", getCurrentMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getEmptyCard() {
        return new CardInfo("", getCurrentMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardWith1MonthSymbol() {
        return new CardInfo("4444 4444 4444 4441", "2", getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardExceeding12Months() {
        return new CardInfo("4444 4444 4444 4441", "13", getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardBelowCurrentMonthThisYear() {
        return new CardInfo("4444 4444 4444 4441", getLastMonth(), getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardNullMonth() {
        return new CardInfo("4444 4444 4444 4441", "00", getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardEmptyMonth() {
        return new CardInfo("4444 4444 4444 4441", "", getCurrentYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardWith1YearSymbol() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "2", getCardHolder(), getCVV());
    }

    public static CardInfo getCardWithAnExpiredYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getLastYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardExceeding5Years() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getNextYear(), getCardHolder(), getCVV());
    }

    public static CardInfo getCardNullYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "00", getCardHolder(), getCVV());
    }

    public static CardInfo getCardEmptyYear() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), "", getCardHolder(), getCVV());
    }

    public static CardInfo getCardHolderCyrillic() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolderNameCyrillic(), getCVV());
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
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolder(), "2");
    }

    public static CardInfo getCardWith2CVVSymbol() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolder(), "22");
    }

    public static CardInfo getCardNullCVV() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolder(), "000");
    }

    public static CardInfo getCardEmptyCVV() {
        return new CardInfo("4444 4444 4444 4441", getCurrentMonth(), getCurrentYear(), getCardHolder(), "");
    }
}
