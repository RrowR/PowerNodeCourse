package day16.demo01;

public class Father {
    private String username;

    public Father() {
    }

    public Father(String username) {
        this.username = username;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Father{" +
                "username='" + username + '\'' +
                '}';
    }
}
