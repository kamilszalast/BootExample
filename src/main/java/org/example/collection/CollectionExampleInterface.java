package org.example.collection;

import java.util.List;
import org.example.dto.User;

public interface CollectionExampleInterface {

    int countOfFemaleUsers(List<User> users);

    int sumOfYearsOfUniqueUsers(List<User> users);

    List<User> getAscendingSortedListByAge(List<User> users);
}
