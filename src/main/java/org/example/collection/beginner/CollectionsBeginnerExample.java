package org.example.collection.beginner;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

import com.sun.istack.internal.Nullable;
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
/*        long currentTime = System.currentTimeMillis();
        int female_Counter=0;
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getSex() == Sex.F)
                female_Counter++;
        }
        System.out.println("Czas: "+ (System.currentTimeMillis()-currentTime));
        return female_Counter;*/
        return (int) users.stream()
                .filter(this::isFemale)
                .count();
    }

    private boolean isFemale(User element) {
        return element.getSex() == Sex.F;
    }

    @Override
    public int sumOfYearsOfUniqueUsers(List<User> users) {
        return users.stream()
                .distinct()
                .mapToInt(User::getAge)
                .sum();
    }

    @Override
    public List<User> getNaturalSortedUsersByAge(List<User> users) {
        users = Optional.ofNullable(users)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
/*        Optional obsluguje nam Nulla, wiec nie wywali nullpointera
        potem getuje, bo nie da sie od razu streamowac,
        nastepnie filtruje obiekty, bez nullowych
        potem sortowanie , a komparatorem jest wiek
        na koncu tworze liste ze streamu obiektow klasy User
        */
        return users;
    }

    // map dziala tak ze przyjmuje cokolwiek zwraca cokolwiek
    @Override
    public List<User> getUsersWithCorrectedAge(List<User> users) {
        return users.stream()
                .map(this::ageFromDate)
                .collect(Collectors.toList());
    }

    private User ageFromDate(User user) {
        LocalDate date1 = user.getBirthday();
        if (date1.isAfter(LocalDate.now()) || date1.isEqual(LocalDate.now()))
            user.setAge(0);
        else {
            user.setAge(Period.between(date1, LocalDate.now()).getYears());
        }
        return user;
    }

    @Override
    public List<Sex> getUsersWithCorrectedGender(List<User> users) {
        return Optional.ofNullable(users)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::sexFromName)
                .collect(Collectors.toList());
    }

    private Sex sexFromName(@Nullable User user) {
        if (user == null)
            return Sex.U;
        else if (user.getName().charAt(user.getName().length() - 1) == 'a')
            return Sex.F;
        else if (Character.isLetter(user.getName().charAt(user.getName().length() - 1)))
            return Sex.M;
        else return Sex.U;
    }

    public List<User> getUsersSortedByNameAndAge(List<User> users) {
        //zliczenie i usuniecie nulli
        users = Optional.ofNullable(users)
                .orElse(Collections.emptyList());
        int NullNumber = Collections.frequency(users,null);
        users.removeAll(Collections.singleton(null));

        Comparator<User> byAge = Comparator.comparing(User::getAge);
        Comparator<User> byName = Comparator.comparing(user -> user.getName().charAt(0));
        users.sort(byName.thenComparing(byAge));

        //i dodanie nulli
        for (int i = 0; i < NullNumber; i++) {
            users.add(null);
        }
        return users;
    }

/*
        List<User> TempList = new ArrayList<>();
        List<User> ReturnedList = new ArrayList<>();

        ArrayList<List<User>> ListsOfLists = new ArrayList<>();
        int NullNumber = NullNumber(users);
        while (users.remove(null)) {
        }

        int j = 0;
        TempList.add(users.get(0));
        ListsOfLists.add(TempList);
        for (int i = 0; i < users.size() - 1; i++) {
            //ta lista juz nie ma nulli wiec nie trzeba ich uwzgledniac
            if (users.get(i).getName().charAt(0) == users.get(i++).getName().charAt(0)) {
                ListsOfLists.get(j).add(users.get(i++));
            } else {
                j++;
                ListsOfLists.get(j).add(users.get(i++));
            }
        }

        //dodanie nulli na koniec ostatniej listy
        for (int i = 0; i < NullNumber; i++) {
            ListsOfLists.get(j) = ListsOfLists.get(j).stream()
                    .sorted(Comparator.comparingInt(User::getAge))
                    .collect(Collectors.toList());

            ListsOfLists.get(j).add(null);
        }
        //zwrocenie wszystkich elementow jako jednej listy
        return ListsOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
*/


}
