package com.oltruong.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.oltruong.demo.ImpotRevenu.calculImpots;
import static org.assertj.core.api.Assertions.assertThat;

;

public class ImpotRevenuTest {

    @DisplayName("Célibataire")
    @Test
    public void calculImpotsCelibataire() throws Exception {
        assertThat(calculImpots(36000, 1))
                .isEqualTo(3641.95);
    }

    @DisplayName("👨‍👧‍👦Avec enfants")
    @Test
    public void calculImpotsEnfants() throws Exception {
        assertThat(calculImpots(62000, 3))
                .isEqualTo(2763.75);
        assertThat(calculImpots(40000, 3))
                .isEqualTo(585.75);
    }

    @DisplayName("👨‍👧‍👦Avec enfants")
    @Test
    public void calculCreditImpot() throws Exception {
        assertThat(ImpotRevenu.calculCreditImpot(62000))
                .isEqualTo(0);
    }


}