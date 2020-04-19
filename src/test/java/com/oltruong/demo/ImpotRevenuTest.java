package com.oltruong.demo;

import org.junit.Test;

import static com.oltruong.demo.ImpotRevenu.calculImpots;
import static org.assertj.core.api.Assertions.assertThat;

public class ImpotRevenuTest {

    @Test
    public void calculImpotsCelibataire() throws Exception {
        assertThat(calculImpots(36000, 1))
                .isEqualTo(3737.75);
    }

    @Test
    public void calculImpotsEnfants() throws Exception {
        assertThat(calculImpots(62000, 3))
                .isEqualTo(2816.88);
        assertThat(calculImpots(40000, 3))
                .isEqualTo(638.88);
    }

}