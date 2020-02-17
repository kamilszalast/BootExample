package org.example.collection

import org.example.collection.beginer.CollectionsExample
import org.example.dto.User
import org.example.enums.Sex
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.Collectors

class CollectionExampleTest extends Specification {

    CollectionsExample collectionExample = []

    @Shared
    User daniel = new User("Daniel", Sex.M, 8)
    @Shared
    User daniel_clone = new User("Daniel", Sex.M, 8)
    @Shared
    User kamil = new User("Kamil", Sex.M, 3)
    @Shared
    User kamil_clone = new User("Kamil", Sex.M, 3)
    @Shared
    User klaudia = new User("Klaudia", Sex.F, 5)
    @Shared
    User klaudia_clone = new User("Klaudia", Sex.F, 5)
    @Shared
    User sylwia = new User("Sylwia", Sex.F, 7)
    @Shared
    User sylwia_clone = new User("Sylwia", Sex.F, 7)


    @Unroll
    def "Metoda getCountOfDifferentUsers powinna zwrocic #expected gdy lista sklada sie z #users"() {

        when:
        def result = collectionExample.getCountOfDifferentUsers(users)

        then:
        result == expected

        where:
        users                                          | expected
        [kamil, daniel, klaudia]                       | 3
        [kamil, kamil_clone, daniel]                   | 2
        [klaudia, klaudia_clone, sylwia, sylwia_clone] | 2
    }

    @Unroll
    def "Metoda countOfFemaleUsers powinna zwrocic #expected gdy lista sklada sie z #users"() {

        when:
        def result = collectionExample.countOfFemaleUsers(users)

        then:
        result == expected

        where:
        users                        | expected
        [kamil, kamil_clone, daniel] | 0
        [klaudia, sylwia, klaudia]   | 3
        [daniel, sylwia, kamil]      | 1
        [daniel, klaudia, sylwia]    | 2
    }

    @Unroll
    def "Metoda sumOfYearsOfUniqueUsers powinna zwrocic #expected gdy lista to : #users"() {

        when:
        def result = collectionExample.sumOfYearsOfUniqueUsers(users)

        then:
        result == expected

        where:
        users                                          | expected
        [kamil, daniel, klaudia]                       | 16
        [kamil, kamil_clone, daniel]                   | 11
        [klaudia, klaudia_clone, sylwia, sylwia_clone] | 12
    }

    @Unroll
    def "Metoda getAscendingSortedListByAge powinna zwrocic #expected gdy lista to : #users"() {

        when:
        def result = collectionExample.getAscendingSortedListByAge(users)

        then:
        result == expected

        where:
        users                            | expected
        [daniel, daniel_clone, klaudia]  | [klaudia, daniel, daniel_clone]
        [kamil, daniel, klaudia, sylwia] | [kamil, klaudia, sylwia, daniel]
        [daniel]                         | [daniel]
        [kamil, daniel, klaudia, null]   | [kamil, klaudia, daniel]
        null                             | []
    }

    @Unroll
    def "Metoda getUsersWithSupplementedSexType powinna zwrocic #expected gdy lista to : #users"() {

        when:
        List<User> users = createUsersWithName(names as List<String>)
        def result = collectionExample.getUsersWithSupplementedSexType(users)

        then:
        result == expected

        where:
        names                     | expected
        ["Daniel"]                | [Sex.M]
        ["Gosia"]                 | [Sex.F]
        ["Gosia", "Daniel"]       | [Sex.F, Sex.M]
        ["Gosia", null, "Daniel"] | [Sex.F, Sex.U, Sex.M]
        [null]                    | [Sex.U]
        []                        | []
    }
    //Groovy nie wspiera lambd
    List<User> createUsersWithName(List<String> names) {
        return names.stream()
                .map({ name -> createUser(name) })
                .collect(Collectors.&toList()) as List<User>
    }

    User createUser(String name) {
        return Optional.ofNullable(name).isPresent() ? new User(name) : null
    }
}
