package org.example.collection.beginner

import org.example.dto.User
import org.example.enums.Sex
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.util.stream.Collectors

class CollectionBeginnerExampleTest extends Specification {

    CollectionsBeginnerExample collectionExample = []

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
        def result = collectionExample.getCountOfFemaleUsers(users)

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
        def result = collectionExample.getNaturalSortedUsersByAge(users)

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

    @Shared
    User ada18 = new User("Ada", 18)
    @Shared
    User agn16 = new User("Agnieszka", 16)
    @Shared
    User ald17 = new User("Aldona", 17)
    @Shared
    User dam18 = new User("Damian", 18)
    @Shared
    User dan16 = new User("Daniel", 16)
    @Shared
    User dag16 = new User("Dagmara", 16)
    @Shared
    User mac16 = new User("Maciek", 16)
    @Shared
    User mar17 = new User("Marek", 17)
    @Shared
    User mon18 = new User("Monika", 18)

    @Unroll
    def "Metoda getSortedUsers powinna zwrocic #expected dla parametru #users"() {

        when:
        def result = collectionExample.getUsersSortedByNameAndAge(users)

        then:
        result == expected

        where:
        users                                                                       | expected
        []                                                                          | []
        [ada18, agn16]                                                              | [agn16, ada18]
        [dag16, dan16]                                                              | [dag16, dan16]
        [ada18, null, agn16]                                                        | [agn16, ada18, null]
        [ada18, agn16, ald17]                                                       | [agn16, ald17, ada18]
        [dag16, dam18, dan16]                                                       | [dag16, dan16, dam18]
        [ada18, agn16, ald17, dag16, dam18, dan16, mac16, mar17, mon18]             | [agn16, ald17, ada18, dag16, dan16, dam18, mac16, mar17, mon18]
        [ada18, agn16, null, ald17, dag16, dam18, dan16, null, mac16, mar17, mon18] | [agn16, ald17, ada18, dag16, dan16, dam18, mac16, mar17, mon18, null, null]
        [null]                                                                      | [null]
        null                                                                        | []
    }

    def "Metoda getUsersWithCorrectAge"() {

        when:
        List<User> result = collectionExample.getUsersWithCorrectedAge(createUsersWithBirthDay())

        then:
        result.get(0).getName() == "Daniel"
        result.get(0).getAge() == 3

        result.get(1).getName() == "Jacek"
        result.get(1).getAge() == 0

        result.get(2).getName() == "Kamil"
        result.get(2).getAge() == 0

        result.get(3).getName() == "Arek"
        result.get(3).getAge() == 1

        result.get(4).getName() == "Klaudia"
        result.get(4).getAge() == 0

        result.get(5).getName() == "Gosia"
        result.get(5).getAge() == 2

        result.get(6).getName() == "Sylwia"
        result.get(6).getAge() == 0
    }

    @Unroll
    def "Metoda getUsersWithSupplementedSexType powinna zwrocic #expected gdy lista to : #names"() {

        when:
        List<User> users = createUsersWithName(names as List<String>)
        def result = collectionExample.getUsersWithCorrectedGender(users)

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
        ["Gosi@"] | [Sex.U]
    }

    static List<User> createUsersWithName(List<String> names) {
        return names.stream()
                .map({ name -> createUser(name) })
                .collect(Collectors.&toList()) as List<User>
    }

    static User createUser(String name) {
        return Optional.ofNullable(name).isPresent() ? new User(name) : null
    }

    static List<User> createUsersWithBirthDay() {
        User u1 = new User("Daniel", LocalDate.now().minusYears(3))
        User u2 = new User("Jacek", LocalDate.now().plusYears(5))
        User u3 = new User("Kamil", LocalDate.now().minusDays(364))
        User u4 = new User("Arek", LocalDate.now().minusDays(365))
        User u5 = new User("Klaudia", LocalDate.now())
        User u6 = new User("Gosia", LocalDate.now().minusMonths(24))
        User u7 = new User("Sylwia", LocalDate.now().plusMonths(36))
        return Arrays.asList(u1, u2, u3, u4, u5, u6, u7)
    }
}
