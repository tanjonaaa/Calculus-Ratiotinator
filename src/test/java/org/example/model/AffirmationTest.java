package org.example.model;

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
}