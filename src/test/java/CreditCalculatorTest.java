import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreditCalculatorTest {
    private CreditCalculator creditCalculator = new CreditCalculator();

    // процент годовых
    private static double yearPercent = 15;

    // процентная ставка по кредиту в месяц
    private static double loanPaymentMonthRate = yearPercent / (100 * yearPercent);

    // количество платежей
    private static int countPayment = 12;

    // количество занятых денег
    private static double borrowedMoney = 300000;

    public static double annuityPayment;
    public static double allMoneyBackInBank;
    public static double calculationOfOverpayments;

    @BeforeAll
    public static void beforeAll() {
        annuityPayment = borrowedMoney * (loanPaymentMonthRate / (1 - Math.pow(1 + loanPaymentMonthRate, -countPayment)));
        allMoneyBackInBank = borrowedMoney * (loanPaymentMonthRate / (1 - Math.pow(1 + loanPaymentMonthRate, -countPayment))) * countPayment;
        calculationOfOverpayments = allMoneyBackInBank - borrowedMoney;
    }

    @Test
    public void monthlyPaymentCalculation() {
        Assertions.assertEquals(annuityPayment, creditCalculator.getAnnuityMonthPayment(borrowedMoney, countPayment));
    }

    @Test
    public void allMoneyBackInBank() {
        Assertions.assertEquals(allMoneyBackInBank, creditCalculator.getAllMoneyBackInBank(borrowedMoney, countPayment));
    }

    @Test
    public void calculationOfOverpaymentsForTheEntirePeriod() {
        Assertions.assertEquals(calculationOfOverpayments, creditCalculator.getOverpaymentsForTheEntirePeriod(borrowedMoney, countPayment));
    }
}
