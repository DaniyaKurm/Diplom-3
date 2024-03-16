package ru.netology.qa.diplom.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.netology.qa.diplom.page.HomePage;
import ru.netology.qa.diplom.page.PaymentGatePage;
import ru.netology.qa.diplom.data.DataHelper;
import ru.netology.qa.diplom.data.SQLHelper;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Payment Gate Tests")
public class PaymentGateTest {

    private final PaymentGatePage paymentGatePage = new PaymentGatePage();
    private final HomePage homePage = new HomePage();

    String approvedCardNumber = DataHelper.getCardApproved().getCardNumber();
    String approvedCardStatus = DataHelper.getCardApproved().getCardStatus();
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

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        homePage.homePage();
        homePage.payment();
        paymentGatePage.paymentGatePage();
    }

    @AfterAll
    public static void shouldCleanBase() {
        SQLHelper.cleanBase();
    }

    @Test
    @DisplayName("Should be open the page for buying a tour on card payment")
    void shouldBeOpenThePageForBuyingATourOnCardPayment() {
        // No need for test steps here since it's just checking if the page is open
    }

    @Test
    @DisplayName("Should be displayed success notification when the bank approves the transaction with valid card details during card payment")
    void shouldDisplaySuccessNotificationWhenBankApprovesTransactionWithValidCardDetailsDuringCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 15 random numeric characters when entering card number")
    void shouldBeEntered15RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(randomCardNumber15Digits, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be empty input field when entering card number")
    void shouldBeEmptyInputFieldWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(emptyField, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 random special characters when entering card number")
    void shouldBeEntered16RandomSpecialCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(random16SpecialCharacters, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Cyrillic characters when entering card number")
    void shouldBeEntered16RandomCyrillicCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(random16CyrillicString, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }


    @Test
    @DisplayName("Should be entered 3 numeric characters in month field when making card payment")
    void shouldBeEntered3NumericCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random3Digits, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in month field when making card payment")
    void shouldBeEntered1NumericCharacterInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random1Digits, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }


    @Test
    @DisplayName("Should be empty input field in month field when making card payment")
    void shouldBeEmptyInputFieldInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, emptyField, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in month field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random2SpecialCharacters, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in month field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random2CyrillicString, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered invalid month greater than 12 when making card payment")
    void shouldBeEnteredInvalidMonthGreaterThan12WhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, randomValueGreater12, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in year field when making card payment")
    void shouldBeEntered3NumericCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random3Digits, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in year field when making card payment")
    void shouldBeEntered1NumericCharacterInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random1Digits, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be empty input field in year field when making card payment")
    void shouldBeEmptyInputFieldInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, emptyField, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in middle in year field when making card payment")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, yearWithSpaceInTheMiddle, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in year field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random2SpecialCharacters, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in year field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random2CyrillicString, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered Cyrillic name in owner field when making card payment")
    void shouldBeEnteredCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, invalidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Cyrillic name in owner field when making card payment")
    void shouldBeEnteredUppercaseCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, uppercaseInvalidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Latin name in owner field when making card payment")
    void shouldBeEnteredUppercaseLatinNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, uppercaseValidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field in owner field when making card payment")
    void shouldBeEmptyInputFieldInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, emptyField, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 special characters in owner field when making card payment")
    void shouldBeEntered16SpecialCharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, random16SpecialCharacters, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }


    @Test
    @DisplayName("Should be entered 3 numeric characters in CVC field when making card payment")
    void shouldBeEntered4NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random4Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters in CVC field when making card payment")
    void shouldBeEntered2NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random2Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be empty input field in CVC field when making card payment")
    void shouldBeEmptyInputFieldInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, emptyField);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters with space in CVC field when making card payment")
    void shouldBeEntered3NumericCharactersWithSpaceInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3DigitNumberWithSpace);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 3 random special characters in CVC field when making card payment")
    void shouldBeEntered3RandomSpecialCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3SpecialCharacters);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Cyrillic characters in CVC field when making card payment")
    void shouldBeEntered3RandomCyrillicCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3CyrillicString);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be displayed the card approved status in the database")
    void shouldBeDisplayedTheCardApprovedStatusInTheDatabase() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        paymentGatePage.getBankApprovedOperationTitleText();
        paymentGatePage.getBankApprovedOperationContentText();
        assertEquals(approvedCardStatus, SQLHelper.getCardStatus("payment_entity"));
    }

    @Test
    @DisplayName("Should be amount pay is 45_000")
    void shouldBeAmountPayIs45_000() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        paymentGatePage.getBankApprovedOperationTitleText();
        paymentGatePage.getBankApprovedOperationContentText();
        assertEquals(45_000, SQLHelper.getAmountPay());
    }

}