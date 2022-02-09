package com.coffees.coffeesystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Coffee.
 */
@Entity
@Table(name = "coffee")
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 4, max = 30)
    @Column(name = "coffee_name", length = 30, nullable = false)
    private String coffeeName;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "coffee_type", length = 20, nullable = false)
    private String coffeeType;

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "coffee_size", length = 20, nullable = false)
    private String coffeeSize;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "coffee_price", length = 10, nullable = false)
    private String coffeePrice;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Coffee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoffeeName() {
        return this.coffeeName;
    }

    public Coffee coffeeName(String coffeeName) {
        this.setCoffeeName(coffeeName);
        return this;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeType() {
        return this.coffeeType;
    }

    public Coffee coffeeType(String coffeeType) {
        this.setCoffeeType(coffeeType);
        return this;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCoffeeSize() {
        return this.coffeeSize;
    }

    public Coffee coffeeSize(String coffeeSize) {
        this.setCoffeeSize(coffeeSize);
        return this;
    }

    public void setCoffeeSize(String coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    public String getCoffeePrice() {
        return this.coffeePrice;
    }

    public Coffee coffeePrice(String coffeePrice) {
        this.setCoffeePrice(coffeePrice);
        return this;
    }

    public void setCoffeePrice(String coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coffee)) {
            return false;
        }
        return id != null && id.equals(((Coffee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Coffee{" +
            "id=" + getId() +
            ", coffeeName='" + getCoffeeName() + "'" +
            ", coffeeType='" + getCoffeeType() + "'" +
            ", coffeeSize='" + getCoffeeSize() + "'" +
            ", coffeePrice='" + getCoffeePrice() + "'" +
            "}";
    }
}
