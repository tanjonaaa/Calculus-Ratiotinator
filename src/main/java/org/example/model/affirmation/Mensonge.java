package org.example.model.affirmation;

public final class Mensonge extends Affirmation {
    public Mensonge(String phrase) {
        super(phrase);
    }

    @Override
    public String getStatut() {
        return "faux";
    }
}
