package org.example.knowledgebase.model;

import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Person {

    private final String name;
    private final String surname;

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getOptionalSurname() {
        return Optional.ofNullable(surname);
    }

}
