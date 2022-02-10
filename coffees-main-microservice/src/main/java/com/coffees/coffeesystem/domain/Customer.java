package com.coffees.coffeesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 35)
    @Column(name = "customer_name", length = 35, nullable = false)
    private String customerName;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "customer_phone", length = 10, nullable = false, unique = true)
    private String customerPhone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties(value = { "customer" }, allowSetters = true)
    private Set<Coffee> coffees = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Customer id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Customer customerName(String customerName) {
        this.setCustomerName(customerName);
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public Customer customerPhone(String customerPhone) {
        this.setCustomerPhone(customerPhone);
        return this;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Set<Coffee> getCoffees() {
        return this.coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        if (this.coffees != null) {
            this.coffees.forEach(i -> i.setCustomer(null));
        }
        if (coffees != null) {
            coffees.forEach(i -> i.setCustomer(this));
        }
        this.coffees = coffees;
    }

    public Customer coffees(Set<Coffee> coffees) {
        this.setCoffees(coffees);
        return this;
    }

    public Customer addCoffee(Coffee coffee) {
        this.coffees.add(coffee);
        coffee.setCustomer(this);
        return this;
    }

    public Customer removeCoffee(Coffee coffee) {
        this.coffees.remove(coffee);
        coffee.setCustomer(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", customerName='" + getCustomerName() + "'" +
            ", customerPhone='" + getCustomerPhone() + "'" +
            "}";
    }
}
