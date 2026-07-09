package std.optional;

import java.util.Optional;

public record User(Long id, String name, String email, Address address) {
    User(Long id, String name, String email) {
        this(id, name, email, null);
    }

    public User setAddress(Address address) {
        return new User(this.id, this.name, this.email, address);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(this.address);
    }

}
