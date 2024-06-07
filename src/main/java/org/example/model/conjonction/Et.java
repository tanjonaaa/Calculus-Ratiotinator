package org.example.model.conjonction;

import org.example.model.affirmation.Affirmation;

public final class Et extends ConjonctionDeCoordination {
    public Et(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
        super(premièreAffirmation, deuxièmeAffirmation);
    }

    @Override
    public String getPhrase() {
        return premièreAffirmation.getPhrase() + " et " + deuxièmeAffirmation.getPhrase();
    }

    @Override
    public String getStatut() {
        if (premièreAffirmation.getStatut().equals("vrai") && deuxièmeAffirmation.getStatut().equals("vrai")) {
            return "vrai";
        } else if (premièreAffirmation.getStatut().equals("faux") || deuxièmeAffirmation.getStatut().equals("vraie")) {
            return "faux";
        }
        return super.getStatut();
    }
}
