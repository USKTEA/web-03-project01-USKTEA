package models;

import java.util.Optional;

public class Session {
    User sessionUser; //TODO seessionUser 있으면 로그인 유지, 로그아웃 구현해야함

    public void set(User user) {
        this.sessionUser = user;
    }

    public Optional<User> getUser() {
        if (sessionUser == null) {
            return Optional.empty();
        }

        return Optional.of(sessionUser);
    }
}
