package kitchenpos.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Quantity implements Comparable<Quantity> {

    @Column(nullable = false)
    private long quantity;

    public Quantity(long quantity) {
        this.quantity = validate(quantity);
    }

    protected Quantity() {
    }

    private long validate(long quantity) {
        if (quantity < 0) {
            throw new InvalidQuantityException();
        }
        return quantity;
    }

    public long getValue() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity that = (Quantity) o;
        return compareTo(that) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public int compareTo(Quantity o) {
        return Long.compare(quantity, o.quantity);
    }
}