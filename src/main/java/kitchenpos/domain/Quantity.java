package kitchenpos.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import kitchenpos.exception.NegativeQuantityException;

@Embeddable
public class Quantity {
    private static final int MIN_QUANTITY = 0;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    protected Quantity() {}

    private Quantity(long quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(long quantity) {
        validateQuantity(quantity);
        return new Quantity(quantity);
    }

    public long getValue() {
        return quantity;
    }

    private static void validateQuantity(long quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new NegativeQuantityException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Quantity quantity1 = (Quantity)o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
