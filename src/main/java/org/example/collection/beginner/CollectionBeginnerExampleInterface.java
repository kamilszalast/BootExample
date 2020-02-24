package org.example.collection.beginner;

import java.util.List;
import org.example.dto.User;
import org.example.enums.Sex;

/**
 * Zadania polegajace na zrozumieniu kolekcji oraz operacji na nich
 */
public interface CollectionBeginnerExampleInterface {

    /**
     * Metoda powinna zwrocic ilosc uzytkownikow plci zenskiej
     */
    int getCountOfFemaleUsers(List<User> users);

    /**
     * Metoda powinna zwracac sume lat uzytkownikow unikalnych
     */
    int sumOfYearsOfUniqueUsers(List<User> users);

    /**
     * Metoda powinna zwracac liste uzytkownikow posortowana naturalnie
     */
    List<User> getNaturalSortedUsersByAge(List<User> users);

    /**
     * Metoda przyjmuje liste uzytkownikow posortowana wedlug nazwy. Nalezy nie naruszajac sortowania po pierwszej literze nazwy uzytkownika
     * posortowac ich po wieku i zwrocic posortowana liste uzytkownikow. W przypadku gdy wiek jest rowny dla kilku osob ustawiamy je
     * alfabetycznie, a wartosci nierozpoznane ustawiamy na koniec listy.
     */
    List<User> getUsersSortedByNameAndAge(List<User> users);

    /**
     * Metoda powinna zwrocic liste uzytkownikow z uzupelnionym wiekiem. Kazdy uzytkownik ma pole LocalDate birthDay i na jego podstawie
     * uzupelniamy wiek uzytkownika. W sytuacji gdy today < birthday -> age = 0
     */
    List<User> getUsersWithCorrectedAge(List<User> users);

    /**
     * Metoda powinna zwrocic liste plci uzytkownikow. Zalozenie jest takie ze nazwa uzytkownika z suffixem -a oznacza kobiete w przeciwnym
     * razie mezczyzne (jesli imie konczy sie litera), a wartosci nierozpoznane jako Sex.U Kolejnosc elementow plci ma odpowiadac kolejnosci
     * listy users.
     */
    List<Sex> getUsersWithCorrectedGender(List<User> users);
}
