package org.example.model;

import lombok.Getter;

@Getter
public sealed class Affirmation permits Vérité, Mensonge {
    private final String phrase;
    private final String statut;

    public Affirmation(String phrase) {
        this.phrase = phrase;
        this.statut = "jenesaispas";
    }
}
