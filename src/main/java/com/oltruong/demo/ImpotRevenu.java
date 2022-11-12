package com.oltruong.demo;

public class ImpotRevenu {


    public static double calculImpots(double revenuBrut, int nombreDeParts) {

        double revenuNet = getRevenuNet(revenuBrut);
        double revenuSurQuotient = revenuNet / nombreDeParts;

        final int premiereFraction = 10225;
        final double baremePremiereTranche = 0.11;

        final int deuxiemeFraction = 26070;
        final double baremeDeuxiemeTranche = 0.3;

        final int troisiemeFraction = 74545;
        final double baremeTroisiemeTranche = 0.41;

        final int derniereFraction = 160336;
        final double baremeQuatriemeTranche = 0.45;


        double tranche1 = calculTranche(Math.min(Math.max(revenuSurQuotient, premiereFraction), deuxiemeFraction), premiereFraction, baremePremiereTranche);
        double tranche2 = calculTranche(Math.min(Math.max(revenuSurQuotient, deuxiemeFraction), troisiemeFraction), deuxiemeFraction, baremeDeuxiemeTranche);
        double tranche3 = calculTranche(Math.min(Math.max(revenuSurQuotient, troisiemeFraction), derniereFraction), troisiemeFraction, baremeTroisiemeTranche);
        double tranche4 = calculTranche(Math.max(revenuSurQuotient, derniereFraction), derniereFraction, baremeQuatriemeTranche);

        return (tranche1 + tranche2 + tranche3 + tranche4) * nombreDeParts;
    }

    private static double calculTranche(double revenuSurQuotient, int premiereFraction, double baremePremiereTranche) {
        return Math.max((revenuSurQuotient - premiereFraction) * baremePremiereTranche, 0);
    }

    private static double getRevenuNet(double revenuBrut) {
        return revenuBrut * 0.9;
    }

}
