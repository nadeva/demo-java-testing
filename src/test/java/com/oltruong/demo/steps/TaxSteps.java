package com.oltruong.demo.steps;


import org.assertj.core.data.Offset;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.oltruong.demo.ImpotRevenu;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxSteps {

    private double revenuBrut;
    private int nombreDeParts;
    private double impotAPayer;

    @Given("Un revenu annuel de {int} euros avec {int} parts")
    public void initData(double revenuBrut, int nombreDeParts) throws Exception {
        this.revenuBrut = revenuBrut;
        this.nombreDeParts = nombreDeParts;

    }

    @When("L'impot est calculé")
    public void computeTax() throws Throwable {
        impotAPayer = ImpotRevenu.calculImpots(revenuBrut, nombreDeParts);
    }

    @Then("Le fisc demande {double} euros")
    public void checkAmount(double estimatedRevenue) throws Exception {
        assertThat(impotAPayer).isCloseTo(estimatedRevenue, Offset.offset(0.009));
    }

}

