package org.example.knowledgebase

import org.example.knowledgebase.model.Person
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class OptionalKnowledgeBaseTest extends Specification {
    OptionalKnowledgeBase sut = []

    @Shared
    String _name = "NAME"
    @Shared
    String _surname = "SURNAME"

    @Unroll
    def "GetNameOrElseSurname"() {

        when:
        Person person = new Person(name, surname)
        def result = sut.getNameOrElseSurname(person)

        then:
        result == expected

        where:
        name  | surname  | expected
        _name | _surname | _name
        null  | _surname | _surname
        _name | null     | _name
    }

    @Unroll
    def "GetNameOrElseGetSurname"() {

        when:
        Person person = new Person(name, surname)
        def result = sut.getNameOrElseGetSurname(person)

        then:
        result == expected

        where:
        name  | surname  | expected
        _name | _surname | _name
        null  | _surname | _surname
        _name | null     | _name
    }
}
