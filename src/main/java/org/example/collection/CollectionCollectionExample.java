package org.example.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.dto.User;

public class CollectionCollectionExample implements CollectionExampleInterface {

    /**
     * Set jest zbiorem. W zbiorach elementy powinny byc unikalne jesli nie jest to znaczy ze cos jest nie tak :) Pomysl co nalezy zrobic by
     * test w CollectionExampleTest który testuje ta metode dzialal poprawnie: Nie mozesz edytowac testu. Test ma przejsc na zielono.
     */
    public int getCountOfDifferentUsers(List<User> users) {
        Set<User> usersSet = new HashSet<>();
        users.forEach(usersSet::add);
        return usersSet.size();
    }

    /**
     * Metoda zwraca liczbe kobiet z listy Testy masz napisane :) Maja przejsc
     */
    @Override
    public int countOfFemaleUsers(List<User> users) {
        return 0;
    }

    /**
     * metoda ma zwrocic sume lat wszystkich unikalnych uzytkownikow. Czyli jezeli lista ma duplikaty to sumy ich lat nie sumuj. Testy są
     * mają przejść :)
     */
    @Override
    public int sumOfYearsOfUniqueUsers(List<User> users) {
        return 0;
    }

    /**
     * Metoda ma zwrócić posortowaną listę względem wieku :) Testy są mają oczywiście przejść.
     */
    @Override
    public List<User> getAscendingSortedListByAge(List<User> users) {
        return users;
    }
}
