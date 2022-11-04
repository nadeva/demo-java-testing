Feature: Calcul d'impôt sur le revenu
  On teste ici le traitement de bout en bout

  Scenario: Célibataire
    Given Un revenu annuel de 36000 euros avec 1 parts
    When L'impot est calculé
    Then Le fisc demande 3641.95 euros


  Scenario: Couple enfants
    Given Un revenu annuel de 40000 euros avec 3 parts
    When L'impot est calculé
    Then Le fisc demande 585.75 euros


  Scenario Outline: Valeurs multiples
    Given Un revenu annuel de <revenuBrut> euros avec <nombreDePart> parts
    When L'impot est calculé
    Then Le fisc demande <impot> euros

    Examples:
      | revenuBrut | nombreDePart | impot   |
      | 36000      | 1            | 3641.95 |
      | 40000      | 3            | 585.75   |
