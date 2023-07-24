package ru.netology.data;

import lombok.Value;

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

    public static CardInfo getApprovedCard() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo("4444 4444 4444 4442", "10", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getAnInvalidCard() {
        return new CardInfo("4444 4444 4444 447", "10", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getNonexistentCard() {
        return new CardInfo("4444 4444 4444 4477", "10", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getEmptyCard() {
        return new CardInfo("", "10", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardWith1MonthSymbol() {
        return new CardInfo("4444 4444 4444 4441", "2", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardExceeding12Months() {
        return new CardInfo("4444 4444 4444 4441", "13", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardBelowCurrentMonthThisYear() {
        return new CardInfo("4444 4444 4444 4441", "06", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardNullMonth() {
        return new CardInfo("4444 4444 4444 4441", "00", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardEmptyMonth() {
        return new CardInfo("4444 4444 4444 4441", "", "23", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardWith1YearSymbol() {
        return new CardInfo("4444 4444 4444 4441", "10", "2", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardWithAnExpiredYear() {
        return new CardInfo("4444 4444 4444 4441", "10", "22", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardExceeding5Years() {
        return new CardInfo("4444 4444 4444 4441", "10", "29", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardNullYear() {
        return new CardInfo("4444 4444 4444 4441", "10", "00", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardEmptyYear() {
        return new CardInfo("4444 4444 4444 4441", "10", "", "Ivan Ivanov", "777");
    }

    public static CardInfo getCardHolderCyrillic() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Николай", "777");
    }

    public static CardInfo getCardHolderNumbers() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "777", "777");
    }

    public static CardInfo getCardHolderSpecialSymbols() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "_$%#№", "777");
    }

    public static CardInfo getCardHolderEmpty() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "", "777");
    }

    public static CardInfo getCardWith1CVVSymbol() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Ivan Ivanov", "2");
    }

    public static CardInfo getCardWith2CVVSymbol() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Ivan Ivanov", "22");
    }

    public static CardInfo getCardNullCVV() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Ivan Ivanov", "000");
    }

    public static CardInfo getCardEmptyCVV() {
        return new CardInfo("4444 4444 4444 4441", "10", "23", "Ivan Ivanov", "");
    }
}
