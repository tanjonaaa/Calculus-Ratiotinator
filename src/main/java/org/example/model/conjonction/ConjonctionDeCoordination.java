package org.example.model.conjonction;

import lombok.AllArgsConstructor;
import org.example.model.affirmation.Affirmation;

@AllArgsConstructor
public sealed class ConjonctionDeCoordination permits Et, Ou, Donc {
    private final Affirmation premièreAffirmation;
    private final Affirmation deuxièmeAffirmation;
}
