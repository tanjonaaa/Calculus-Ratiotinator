package org.example.model.conjonction;

import lombok.Getter;
import org.example.model.affirmation.Affirmation;

@Getter
public abstract sealed class ConjonctionDeCoordination permits Et, Ou, Donc {
    protected final Affirmation premièreAffirmation;
    protected final Affirmation deuxièmeAffirmation;
    protected final String statut;
    protected final String phrase;

    protected ConjonctionDeCoordination(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
        this.premièreAffirmation = premièreAffirmation;
        this.deuxièmeAffirmation = deuxièmeAffirmation;
        this.statut = "jenesaispas";
        this.phrase = "";
    }
}
