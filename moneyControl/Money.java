import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public final class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, String currencyCode) {
        if (amount == null) {
            throw new NullPointerException("amount must not be null");
        }
        if (currencyCode == null) {
            throw new NullPointerException("currencyCode must not be null");
        }

        BigDecimal normalized;
        try {
            normalized = amount.stripTrailingZeros();
        } catch (ArithmeticException ex) {
            normalized = amount;
        }

        final Currency validatedCurrency;
        try {
            validatedCurrency = Currency.getInstance(currencyCode.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid ISO 4217 currency code: " + currencyCode, ex);
        }

        this.amount = normalized;
        this.currency = validatedCurrency;
    }

    public static Money of(BigDecimal amount, String currencyCode) {
        return new Money(amount, currencyCode);
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    public String getCurrencyCode() {
        return currency.getCurrencyCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money other = (Money) o;
        return amount.equals(other.amount) && currency.equals(other.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        String amt = amount.stripTrailingZeros().toPlainString();
        return "Money{amount=" + amt + ", currency=" + currency.getCurrencyCode() + "}";
    }
}