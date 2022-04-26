import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreditCalculatorTest {
    private final CreditCalculator creditCalculator = new CreditCalculator();

    // процент годовых
    private static final double yearPercent = 15;

    // количество платежей
    private static final int countPayment = 12;

    // количество занятых денег
    private static final double borrowedMoney = 300000;

    public static double annuityPayment;
    public static double allMoneyBackInBank;
    public static double calculationOfOverpayments;

    @BeforeAll
    public static void beforeAll() {
        // процентная ставка по кредиту в месяц
        double loanPaymentMonthRate = yearPercent / (100 * yearPercent);
        annuityPayment = borrowedMoney * (loanPaymentMonthRate / (1 - Math.pow(1 + loanPaymentMonthRate, -countPayment)));
        allMoneyBackInBank = annuityPayment * countPayment;
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
