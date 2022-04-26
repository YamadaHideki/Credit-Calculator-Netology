public class CreditCalculator {
    private double yearPercent = 15;

    public Double getAnnuityMonthPayment(Double money, int countMonthPayment) {
        return money * (getLoanPaymentMonthRate() / (1 - Math.pow(1 + getLoanPaymentMonthRate(), -countMonthPayment)));
    }

    public Double getAllMoneyBackInBank(Double money, int countMonthPayment) {
        return getAnnuityMonthPayment(money, countMonthPayment) * countMonthPayment;
    }

    public Double getOverpaymentsForTheEntirePeriod(Double money, int countMonthPayment) {
        return getAllMoneyBackInBank(money, countMonthPayment) - money;
    }

    private Double getLoanPaymentMonthRate() {
        return yearPercent / (100 * yearPercent);
    }

    public double getYearPercent() {
        return yearPercent;
    }

    public void setYearPercent(double yearPercent) {
        this.yearPercent = yearPercent;
    }
}
