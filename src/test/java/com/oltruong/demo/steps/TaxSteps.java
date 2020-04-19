package com.oltruong.demo.steps;


import org.assertj.core.data.Offset;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.oltruong.demo.ImpotRevenu;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxSteps {

    private double revenuBrut;
    private int nombreDeParts;
    private double impotAPayer;

    @Given("Un revenu annuel de (\\d+) euros avec (\\d+) parts")
    public void initData(double revenuBrut, int nombreDeParts) throws Exception {
        this.revenuBrut = revenuBrut;
        this.nombreDeParts = nombreDeParts;

    }

    @When("L'impot est calculé")
    public void computeTax() throws Throwable {
        impotAPayer = ImpotRevenu.calculImpots(revenuBrut, nombreDeParts);
    }

    @Then("Le fisc demande (.+) euros")
    public void checkAmount(double estimatedRevenue) throws Exception {
        assertThat(impotAPayer).isCloseTo(estimatedRevenue, Offset.offset(0.009));
    }

}

