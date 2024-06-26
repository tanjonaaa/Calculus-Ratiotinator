package org.example.model;

import org.example.model.affirmation.Affirmation;
import org.example.model.affirmation.Mensonge;
import org.example.model.affirmation.Vérité;
import org.example.model.conjonction.Donc;
import org.example.model.conjonction.Et;
import org.example.model.conjonction.Ou;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AffirmationTest {

    @Test
    void statutDeVéritéEstVrai() {
        Vérité louEstBeau = new Vérité("Lou est beau");

        assertEquals("vrai", louEstBeau.getStatut());
    }

    @Test
    void statutDeMensongeEstFaux() {
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");

        assertEquals("faux", louEstPauvre.getStatut());
    }

    @Test
    void statutDAffirmationEstJeNeSaisPasParDefaut() {
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");

        assertEquals("jenesaispas", louEstGénéreux.getStatut());
    }

    @Test
    void louEstPauvreEtLouEstGénéreuxEstFaux() {
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Et pauvreEtGénéreux = new Et(louEstPauvre, louEstGénéreux);

        Affirmation louEstPauvreEtLouEstGénéreux = new Affirmation(pauvreEtGénéreux);

        assertEquals("faux", louEstPauvreEtLouEstGénéreux.getStatut());
    }

    @Test
    void phraseDeLouEstPauvreEtLouEstGénéreuxEst() {
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Et pauvreEtGénéreux = new Et(louEstPauvre, louEstGénéreux);

        Affirmation louEstPauvreEtLouEstGénéreux = new Affirmation(pauvreEtGénéreux);

        assertEquals("Lou est pauvre et Lou est généreux", louEstPauvreEtLouEstGénéreux.getPhrase());
    }

    @Test
    void louEstBeauDoncLouEstPauvreEstFaux() {
        Vérité louEstBeau = new Vérité("Lou est beau");
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Donc beauDoncPauvre = new Donc(louEstBeau, louEstPauvre);

        Affirmation louEstBeauDoncLouEstPauvre = new Affirmation(beauDoncPauvre);

        assertEquals("faux", louEstBeauDoncLouEstPauvre.getStatut());
    }

    @Test
    void louEstPauvreDoncLouEstGénéreuxEstVrai() {
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Donc pauvreDonGénéreux = new Donc(louEstPauvre, louEstGénéreux);

        Affirmation louEstPauvreDoncLouEstGénéreux = new Affirmation(pauvreDonGénéreux);

        assertEquals("vrai", louEstPauvreDoncLouEstGénéreux.getStatut());
    }

    @Test
    void louEstBeauOuLouEstGénéreuxDoncLouEstPauvreEstFaux() {
        Vérité louEstBeau = new Vérité("Lou est beau");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Ou beauOuGénéreux = new Ou(louEstBeau, louEstGénéreux);

        Affirmation louEstBeauOuLouEstGénéreux = new Affirmation(beauOuGénéreux);

        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Donc doncLouEstPauvre = new Donc(louEstBeauOuLouEstGénéreux, louEstPauvre);

        Affirmation louEstBeauOuLouEstGénéreuxDoncLouEstPauvre = new Affirmation(doncLouEstPauvre);

        assertEquals("faux", louEstBeauOuLouEstGénéreuxDoncLouEstPauvre.getStatut());
    }

    @Test
    void phraseDeLouEstBeauOuLouEstGénéreuxDoncLouEstPauvre() {
        Vérité louEstBeau = new Vérité("Lou est beau");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Ou beauOuGénéreux = new Ou(louEstBeau, louEstGénéreux);

        Affirmation louEstBeauOuLouEstGénéreux = new Affirmation(beauOuGénéreux);

        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Donc doncLouEstPauvre = new Donc(louEstBeauOuLouEstGénéreux, louEstPauvre);

        Affirmation louEstBeauOuLouEstGénéreuxDoncLouEstPauvre = new Affirmation(doncLouEstPauvre);

        assertEquals("Lou est beau ou Lou est généreux. Donc Lou est pauvre", louEstBeauOuLouEstGénéreuxDoncLouEstPauvre.getPhrase());
    }

    @Test
    void jeNeSaisPasSiLouEstPauvreOuLouEstGénéreux() {
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Ou pauvreOuGénéreux = new Ou(louEstPauvre, louEstGénéreux);

        Affirmation louEstPauvreOuLouEstGénéreux = new Affirmation(pauvreOuGénéreux);

        assertEquals("jenesaispas", louEstPauvreOuLouEstGénéreux.getStatut());
    }

    @Test
    void jeNeSaisPasSiLouEstBeauEtLouEstGénéreux() {
        Vérité louEstBeau = new Vérité("Lou est beau");
        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Et beauEtGénéreux = new Et(louEstBeau, louEstGénéreux);

        Affirmation louEstBeauEtLouEstGénéreux = new Affirmation(beauEtGénéreux);

        assertEquals("jenesaispas", louEstBeauEtLouEstGénéreux.getStatut());
    }

    @Test
    void jeNeSaisPasSiLouEstBeauOuLouEstPauvreDoncLouEstGénéreux() {
        Vérité louEstBeau = new Vérité("Lou est beau");
        Mensonge louEstPauvre = new Mensonge("Lou est pauvre");
        Ou beauOuPauvre = new Ou(louEstBeau, louEstPauvre);

        Affirmation louEstBeauOuLouEstPauvre = new Affirmation(beauOuPauvre);

        Affirmation louEstGénéreux = new Affirmation("Lou est généreux");
        Donc beauOuPauvreDoncGénéreux = new Donc(louEstBeauOuLouEstPauvre, louEstGénéreux);

        Affirmation louEstBeauOuLouEstPauvreDonclouEstGénéreux = new Affirmation(beauOuPauvreDoncGénéreux);

        assertEquals("jenesaispas", louEstBeauOuLouEstPauvreDonclouEstGénéreux.getStatut());
    }
}