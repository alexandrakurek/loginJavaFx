package registration_form.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserDao {
    private static Map<UUID, User> users = new HashMap<>();

    public static void add(User user) {
        UUID id = UUID.randomUUID();
        user.setId(id);
        users.put(id, user);
    }


    public static boolean existByUsername(String username) {
        return users.values().stream()
//                .filter(user -> user.getUsername().equals(username))
//                .findAny()
//                .isPresent();
                .anyMatch(user -> user.getUsername().equals(username));
    }

    public static boolean login(String username, String password) {
        Optional<User> foundUser = users.values().stream() // wchodzimy w strumien
                .filter(user -> user.getUsername().equals(username))
                .findAny(); // zwraca optionala

        if (foundUser.isPresent()) { // to jest nasz optional
            return foundUser.get().getPassword().equals(password);
        }
        return false;
    }
}
