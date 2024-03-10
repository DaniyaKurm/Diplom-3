package ru.netology.qa.diplom.data;

import com.github.javafaker.Faker;

import lombok.Value;

import java.time.Year;
import java.time.YearMonth;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    private DataHelper() {
    }

    private static Faker faker = new Faker(new Locale("en"));
    private static Faker fakerRus = new Faker(new Locale("ru"));

    @Value
    public static class CardInfo {
        String cardNumber;
        String cardStatus;
    }

    public static CardInfo getCardApproved() {
        return new CardInfo("2202 2222 2222 2222", "APPROVED");
    }

    public static CardInfo getCardDeclined() {
        return new CardInfo("2204 4444 4444 4444", "DECLINED");
    }

