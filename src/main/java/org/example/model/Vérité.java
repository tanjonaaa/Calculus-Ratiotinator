package org.example.model;

public final class Vérité extends Affirmation {
    public Vérité(String phrase) {
        super(phrase);
    }

    @Override
    public String getStatut() {
        return "vrai";
    }
}
