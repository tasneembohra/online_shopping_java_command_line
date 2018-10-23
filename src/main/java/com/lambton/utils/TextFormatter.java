package com.lambton.utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class TextFormatter {
    public static String currency(double money) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String moneyString = format.format(money);
        return moneyString;
    }
}
