package com.oltruong.demo;

public class ImpotRevenu {


    public static double calculImpots(double revenuBrut, int nombreDeParts) {

        double revenuNet = revenuBrut * 0.9;
        double revenuSurQuotient = revenuNet / nombreDeParts;

        final int premiereFraction = 10225;
        final double baremePremiereTranche = 0.11;

        final int deuxiemeFraction = 26070;
        final double baremeDeuxiemeTranche = 0.3;

        final int troisiemeFraction = 74545;
        final double baremeTroisiemeTranche = 0.41;

        final int derniereFraction = 160336;
        final double baremeQuatriemeTranche = 0.45;


        double tranche1 = Math.max((Math.min(Math.max(revenuSurQuotient, premiereFraction), deuxiemeFraction) - premiereFraction) * baremePremiereTranche, 0);
        double tranche2 = Math.max((Math.min(Math.max(revenuSurQuotient, deuxiemeFraction), troisiemeFraction) - deuxiemeFraction) * baremeDeuxiemeTranche, 0);
        double tranche3 = Math.max((Math.min(Math.max(revenuSurQuotient, troisiemeFraction), derniereFraction) - troisiemeFraction) * baremeTroisiemeTranche, 0);
        double tranche4 = Math.max((Math.max(revenuSurQuotient, derniereFraction) - derniereFraction) * baremeQuatriemeTranche, 0);

        return (tranche1 + tranche2 + tranche3 + tranche4) * nombreDeParts;
    }

}
