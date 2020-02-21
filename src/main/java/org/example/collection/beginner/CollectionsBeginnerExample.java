package org.example.collection.beginner;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.example.dto.User;
import org.example.enums.Sex;

public class CollectionsBeginnerExample implements CollectionBeginnerExampleInterface {

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
    public int getCountOfFemaleUsers(List<User> users) {
        return 0;
    }

    @Override
    public int sumOfYearsOfUniqueUsers(List<User> users) {
        return 0;
    }

    @Override
    public List<User> getNaturalSortedUsersByAge(List<User> users) {
        return Collections.emptyList();
    }

    @Override
    public List<User> getUsersSortedByNameAndAge(List<User> users) {
        return Collections.emptyList();
    }

    @Override
    public List<User> getUsersWithCorrectedAge(List<User> users) {
        return Collections.emptyList();
    }

    @Override
    public List<Sex> getUsersWithCorrectedGender(List<User> users) {
        return Collections.emptyList();
    }
}
