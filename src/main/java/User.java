public class User {

    private int userId;
    private String name;
    private int town;

    public User() {
    }

    public User(int userId, String name, int town) {
        this.userId = userId;
        this.name = name;
        this.town = town;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTown() {
        return town;
    }

    public void setTown(int town) {
        this.town = town;
    }
}
