package models;//TODO : findby로 받은 결과값으로 에러메세지 출력하거나 로그인 진행

import models.AccountRepository;

import java.io.FileNotFoundException;
import java.util.Optional;

public class AuthService {
    public Optional<User> findBy(String[] data) throws FileNotFoundException {
        return new AccountRepository().getAccount(data);
    }
}
