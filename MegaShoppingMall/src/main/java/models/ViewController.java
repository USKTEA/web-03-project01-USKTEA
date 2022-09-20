package models;

public class ViewController {
    Session session = new Session();

    public void setSession(User user) {
        session.set(user);
    }
}
