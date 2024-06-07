package org.example.model.affirmation;

import lombok.Getter;
import org.example.model.conjonction.ConjonctionDeCoordination;

@Getter
public sealed class Affirmation permits Vérité, Mensonge {
    private final String phrase;
    private final String statut;
    private final ConjonctionDeCoordination conjonction;

    public Affirmation(String phrase) {
        this.phrase = phrase;
        this.statut = "jenesaispas";
        this.conjonction = null;
    }

    public Affirmation(ConjonctionDeCoordination conjonction) {
        this.phrase = null;
        this.statut = conjonction.getStatut();
        this.conjonction = conjonction;
    }
}
