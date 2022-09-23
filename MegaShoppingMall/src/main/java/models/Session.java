package models;

import java.util.Optional;

public class Session {
    private User sessionUser;

    public void set(User user) {
        this.sessionUser = user;
    }

    public Optional<User> getUser() {
        if (sessionUser == null) {
            return Optional.empty();
        }

        return Optional.of(sessionUser);
    }

    public void logOut() {
        this.sessionUser = null;
    }
}
