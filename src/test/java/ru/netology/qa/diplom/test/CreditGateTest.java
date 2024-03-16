package ru.netology.qa.diplom.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.netology.qa.diplom.page.HomePage;
import ru.netology.qa.diplom.page.CreditGatePage;
import ru.netology.qa.diplom.data.DataHelper;
import ru.netology.qa.diplom.data.SQLHelper;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Credit Gate Tests")
public class CreditGateTest {

    private final CreditGatePage creditGatePage = new CreditGatePage();
    private final HomePage homePage = new HomePage();

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        homePage.homePage();
        homePage.credit();
        creditGatePage.creditGatePage();
    }

    @AfterAll
    public static void shouldCleanBase() {
        SQLHelper.cleanBase();
    }

    String declinedCardNumber = DataHelper.getCardDeclined().getCardNumber();
    String declinedCardStatus = DataHelper.getCardDeclined().getCardStatus();
    String randomCardNumber15Digits = DataHelper.getRandomCardNumber15Digits();
    String emptyField = DataHelper.getEmptyField();
    String random16SpecialCharacters = DataHelper.getRandom16SpecialCharacters();
    String random16CyrillicString = DataHelper.getRandom16CyrillicLetter();
    String validExpiryMonth = DataHelper.getValidExpiryMonth();
    String validExpiryYear = DataHelper.getValidExpiryYear();
    String randomValueGreater12 = DataHelper.getRandomValueGreater12();
    String random1Digits = DataHelper.getRandom1Digits();
    String random3Digits = DataHelper.getRandom3Digits();
    String yearWithSpaceInTheMiddle = DataHelper.getYearWithSpaceInTheMiddle();
    String random2SpecialCharacters = DataHelper.getRandom2SpecialCharacters();
    String random2CyrillicString = DataHelper.getRandom2CyrillicString();
    String validOwner = DataHelper.getValidOwner();
    String uppercaseValidOwner = DataHelper.getUppercaseValidOwner();
    String invalidOwner = DataHelper.getInvalidOwner();
    String uppercaseInvalidOwner = DataHelper.getUppercaseInvalidOwner();
    String random2Digits = DataHelper.getRandom2Digits();
    String random4Digits = DataHelper.getRandom4Digits();
    String random3DigitNumberWithSpace = DataHelper.getRandom3DigitNumberWithSpace();
    String random3SpecialCharacters = DataHelper.getRandom3SpecialCharacters();
    String random3CyrillicString = DataHelper.getRandom3CyrillicString();

    @Test
    @DisplayName("Should be open the page for buying a tour on credit")
    void shouldBeOpenThePageForBuyingATourOnCredit() {
        // No need for test steps here since it's just checking if the page is open
    }

    @Test
    @DisplayName("Should be displayed error notification when the bank declines the transaction with invalid card details")
    void shouldDisplayErrorNotificationWhenBankDeclinesTransactionWithInvalidCardDetails() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 15 random numeric characters when entering credit card number")
    void shouldBeEntered15RandomNumericCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData(randomCardNumber15Digits, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be empty input field when entering credit card number")
    void shouldBeEmptyInputFieldWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData(emptyField, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 random special characters when entering credit card number")
    void shouldBeEntered16RandomSpecialCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData(random16SpecialCharacters, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Cyrillic characters when entering credit card number")
    void shouldBeEntered16RandomCyrillicCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData(random16CyrillicString, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in month field when making credit purchase")
    void shouldBeEntered3NumericCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, random3Digits, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in month field when making credit purchase")
    void shouldBeEntered1NumericCharacterInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, random1Digits, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }
    @Test
    @DisplayName("Should be empty input field in month field when making credit purchase")
    void shouldBeEmptyInputFieldInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, emptyField, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

   @Test
    @DisplayName("Should be entered 2 random special characters in month field when making credit purchase")
    void shouldBeEntered2RandomSpecialCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, random2SpecialCharacters, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in month field when making credit purchase")
    void shouldBeEntered2RandomCyrillicCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, random2CyrillicString, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered invalid month greater than 12 when making credit purchase")
    void shouldBeEnteredInvalidMonthGreaterThan12WhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, randomValueGreater12, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in Year field when making credit purchase")
    void shouldBeEntered3NumericCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, random3Digits, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in Year field when making credit purchase")
    void shouldBeEntered1NumericCharacterInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, random1Digits, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be empty input field in Year field when making credit purchase")
    void shouldBeEmptyInputFieldInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, emptyField, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in the middle in Year field when making credit purchase")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, yearWithSpaceInTheMiddle, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", creditGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in year field when making a credit purchase")
    void shouldBeEntered2RandomSpecialCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, random2SpecialCharacters, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in year field when making a credit purchase")
    void shouldBeEntered2RandomCyrillicCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, random2CyrillicString, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered Cyrillic name in the owner field when making a credit purchase")
    void shouldBeEnteredCyrillicNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, invalidOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Cyrillic name in the owner field when making a credit purchase")
    void shouldBeEnteredUppercaseCyrillicNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, uppercaseInvalidOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Latin name in the owner field when making a credit purchase")
    void shouldBeEnteredUppercaseLatinNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, uppercaseValidOwner, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be an empty input field in the owner field when making a credit purchase")
    void shouldBeEmptyInputFieldInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, emptyField, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 special characters in owner field when making a credit purchase")
    void shouldBeEntered16SpecialCharactersInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, random16SpecialCharacters, random3Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in CVC field when making card payment")
    void shouldBeEntered4NumericCharactersInCVCFieldWhenMakingCardPayment() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random4Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Успешно", creditGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", creditGatePage.getBankApprovedOperationContentText());
    }
    @Test
    @DisplayName("Should be entered 2 numeric characters in CVC field when making a credit purchase")
    void shouldBeEntered2NumericCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random2Digits);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be an empty input field in CVC field when making a credit purchase")
    void shouldBeEmptyInputFieldInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, emptyField);
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters with space in CVC field when making a credit purchase")
    void shouldBeEntered3NumericCharactersWithSpaceInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3DigitNumberWithSpace);
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 3 random special characters in CVC field when making a credit purchase")
    void shouldBeEntered3RandomSpecialCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3SpecialCharacters);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Cyrillic characters in CVC field when making a credit purchase")
    void shouldBeEntered3RandomCyrillicCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3CyrillicString);
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be displayed the card declined status in the database")
    void shouldBeDisplayedTheCardDeclinedStatusInTheDatabase() {
        creditGatePage.fillCardData(declinedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        creditGatePage.clickContinueButton();
        creditGatePage.getBankDeclinedOperationTitleText();
        creditGatePage.getBankDeclinedOperationContentText();
        assertEquals(declinedCardStatus, SQLHelper.getCardStatus("credit_request_entity"));
    }

}