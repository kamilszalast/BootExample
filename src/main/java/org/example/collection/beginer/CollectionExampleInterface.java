package org.example.collection.beginer;

import java.util.List;
import org.example.dto.User;

/**
 * Zadania polegajace na zrozumieniu kolekcji oraz operacji na nich
 */
public interface CollectionExampleInterface {

    /**
     * Metoda powinna zwrocic ilosc uzytkownikow plci zenskiej
     */
    int countOfFemaleUsers(List<User> users);

    /**
     * Metoda powinna zwracac sume lat uzytkownikow unikalnych
     */
    int sumOfYearsOfUniqueUsers(List<User> users);

    /**
     * Metoda powinna zwracac liste uzytkownikow posortowana naturalnie
     */
    List<User> getAscendingSortedListByAge(List<User> users);


}
