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
    def "Method getNameOrElseSurname should return #expected when name is #name and surname is #surname and no thrown exception"() {

        when:
        Person person = new Person(name, surname)
        def result = sut.getNameOrElseSurname(person)

        then:
        noExceptionThrown()
        result == expected

        where:
        name  | surname  | expected
        _name | _surname | _name
        null  | _surname | _surname
    }

    @Unroll
    def "Method getNameOrElseSurname should thrown exception when name is #name and surname is #surname"() {

        when:
        Person person = new Person(name, surname)
        sut.getNameOrElseSurname(person)

        then:
        thrown(IllegalStateException)

        where:
        name  | surname
        _name | null
        null  | null
    }

    @Unroll
    def "Method getNameOrElseGetSurname should return #expected when name is #name and surname is #surname and no thrown exception"() {

        when:
        Person person = new Person(name, surname)
        def result = sut.getNameOrElseGetSurname(person)

        then:
        noExceptionThrown()
        result == expected

        where:
        name  | surname  | expected
        _name | _surname | _name
        null  | _surname | _surname
        _name | null     | _name
    }

    @Unroll
    def "Method getNameOrElseGetSurname should thrown exception when name and surname is null"() {

        when:
        Person person = new Person(null, null)
        sut.getNameOrElseGetSurname(person)

        then:
        thrown(IllegalStateException)
    }
}
