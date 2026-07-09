package std.optional;

import java.util.Optional;

public class UserRepository {
    public static User findUserById(Long id) {
        if (id == null) {
            return null;
        }
        // return new User(id, name, email);
        return new User(id, "matthew", "some@email");
    }

    public static Optional<User> findOptionalUserById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        // return new User(id, name, email);
        return Optional.of(new User(id, "matthew", "some@email"));
    }
}
