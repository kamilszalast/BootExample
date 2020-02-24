package org.example.knowledgebase;

import org.example.knowledgebase.model.Person;

public class OptionalKnowledgeBase {

    /**
     * OrElse NIE JEST Lazy i wykonuje sie ZAWSZE
     */
    public String getNameOrElseSurname(Person person) {
        return person.getOptionalName()
                .orElse(person.getOptionalSurname().orElseThrow(IllegalStateException::new));
    }

    /**
     * OrElseGet JEST Lazy i wykonuje sie tylko w przypadku gdy poptzednie akcje nie zwroca wyniku
     */
    public String getNameOrElseGetSurname(Person person) {
        return person.getOptionalName()
                .orElseGet(() -> person.getOptionalSurname().orElseThrow(IllegalStateException::new));
    }
}
