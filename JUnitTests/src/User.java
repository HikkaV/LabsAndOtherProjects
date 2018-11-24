import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
    private static Map<Integer, User> allUsers= new HashMap<>();
    private static int countId = 0;


    @Override
    public int hashCode() {

        return Objects.hash(name, age, sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex.equals( user.sex);
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public User(String name, int age, String sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {

            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(String sex) {
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()) {
            if (user.sex.equals(sex) ){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getHowManyUsers(String sex) {
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user : allUsers.values()) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(String sex) {
        int countAge = 0;
        for (User user : getAllUsers(sex)) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(String sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }
}
