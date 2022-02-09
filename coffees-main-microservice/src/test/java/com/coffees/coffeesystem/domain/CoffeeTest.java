package com.coffees.coffeesystem.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.coffees.coffeesystem.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Coffee.class);
        Coffee coffee1 = new Coffee();
        coffee1.setId(1L);
        Coffee coffee2 = new Coffee();
        coffee2.setId(coffee1.getId());
        assertThat(coffee1).isEqualTo(coffee2);
        coffee2.setId(2L);
        assertThat(coffee1).isNotEqualTo(coffee2);
        coffee1.setId(null);
        assertThat(coffee1).isNotEqualTo(coffee2);
    }
}
