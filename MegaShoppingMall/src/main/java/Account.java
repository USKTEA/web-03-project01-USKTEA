import java.util.Objects;

public class Account {
    String id;
    String password;
    int point;
    String grade;

    public Account(String[] information) {
        this.id = information[0];
        this.password = information[1];
        this.point = Integer.parseInt(information[2]);
        this.grade = information[3];
    }

    public Account() {

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        Account otherAccount = (Account) other;

        return Objects.equals(id, otherAccount.id);
    }

    @Override
    public String toString() {
        return "아이디: " + id + ", " + "비밀번호: " + password + ", " + "잔액: " + point + ", " + "등급: " + grade;
    }
}
