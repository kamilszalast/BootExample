package org.example.collection;

import java.util.HashSet;
import java.util.List;
import org.example.dto.User;

public class CollectionsExample implements CollectionExampleInterface {

    /**
     * Nie poprawiajac testu nalezy poprawic kod tak aby testy przechodzily wszystkie na zielono. Kod przed refactorem:
     * <pre>{@code
     *   Set<User> usersSet = new HashSet<>();
     *   users.forEach(usersSet::add);
     *   return usersSet.size();
     * }</pre>
     */
    public int getCountOfDifferentUsers(List<User> users) {
        return new HashSet<>(users).size();
    }


    @Override
    public int countOfFemaleUsers(List<User> users) {
        return 0;
    }


    @Override
    public int sumOfYearsOfUniqueUsers(List<User> users) {
        return 0;
    }


    @Override
    public List<User> getAscendingSortedListByAge(List<User> users) {
        return users;
    }
}
