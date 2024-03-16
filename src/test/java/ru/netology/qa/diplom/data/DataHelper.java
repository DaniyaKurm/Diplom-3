package ru.netology.qa.diplom.data;

import com.github.javafaker.Faker;

import lombok.Value;

import java.time.YearMonth;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    private DataHelper() {
    }

    private static final Faker faker = new Faker(new Locale("en"));
    private static final Faker fakerRus = new Faker(new Locale("ru"));

    @Value
    public static class CardInfo {
        String cardNumber;
        String cardStatus;
    }

    public static CardInfo getCardApproved() {
        return new CardInfo("4444 4444 4444 4441", "APPROVED");
    }

    public static CardInfo getCardDeclined() {
        return new CardInfo("4444 4444 4444 4442", "DECLINED");
    }

    public static String getValidExpiryMonth() {
        int currentYear = YearMonth.now().getYear();
        int currentMonth = YearMonth.now().getMonthValue();

        int year = faker.number().numberBetween(currentYear, currentYear + 5);
        int month;

        if (year == currentYear) {
            month = faker.number().numberBetween(currentMonth, 13);
        } else {
            month = faker.number().numberBetween(1, 13);
        }

        return String.format("%02d", month);
    }

    public static String getValidExpiryYear() {
        int currentYear = YearMonth.now().getYear();
        int year = faker.number().numberBetween(currentYear, currentYear + 5);
        int validYear = Math.min(year, currentYear + 5);
        return String.format("%02d", validYear % 100);
    }

    public static String getValidOwner() {
        return faker.name().fullName();
    }

    public static String getUppercaseValidOwner() {
        return getValidOwner().toUpperCase();
    }

    public static String getRandomCardNumber15Digits() {
        String randomCardNumber = faker.business().creditCardNumber();
        return randomCardNumber.substring(0, randomCardNumber.length() - 1);
    }

    public static String getEmptyField() {
        return "";
    }

    public static String getRandom16SpecialCharacters() {
        return faker.regexify("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]{16}");
    }

    public static String getRandom16CyrillicLetter() {
        return fakerRus.regexify("[А-Я]{" + 16 + "}");
    }


    public static String getRandom1Digits() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
    }

    public static String getRandom3Digits() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000));
    }

    public static String getYearWithSpaceInTheMiddle() {
        return getValidExpiryYear().charAt(0) + " " + getValidExpiryYear().charAt(1);
    }

    public static String getRandom2CyrillicString() {
        return fakerRus.regexify("[А-Я]{" + 2 + "}");
    }

    public static String getRandom2SpecialCharacters() {
        return faker.regexify("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]{2}");
    }

    public static String getRandomValueGreater12() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(13, 100));
    }

    public static String getInvalidOwner() {
        return fakerRus.name().fullName();
    }

    public static String getUppercaseInvalidOwner() {
        return getInvalidOwner().toUpperCase();
    }

    public static String getRandom2Digits() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(10, 100));
    }

    public static String getRandom4Digits() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(10_000, 100_000));
    }

    public static String getRandom3DigitNumberWithSpace() {
        int randomThreeDigitNumber = ThreadLocalRandom.current().nextInt(100, 1000);
        return String.format("%d %02d",
                randomThreeDigitNumber / 100,
                randomThreeDigitNumber % 100);
    }

    public static String getRandom3SpecialCharacters() {
        return faker.regexify("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]{3}");
    }

    public static String getRandom3CyrillicString() {
        return fakerRus.regexify("[А-Я]{" + 3 + "}");
    }
}

