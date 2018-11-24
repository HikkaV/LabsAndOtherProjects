import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
private User user;
private User user1;
private User user2;
@Before
public  void setUp()throws Exception{
     user = new User("Евгений", 35, Sex.MALE);
     user1 = new User("Марина", 34, Sex.FEMALE);
    user2 = new User("Алина", 7, Sex.FEMALE);
}

    @org.junit.Test
    public void getAllUsers() {
        List<User> expected = User.getAllUsers();
        //создаем список expected и заполняем его данными нашего метода

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологаем метод должен вернуть
       List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
      actual.add(user2);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getAllUsers_NOT_NULL() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @org.junit.Test
    public void getHowManyUsers_MALE() {
    List<User> expected = User.getAllUsers(Sex.MALE);
    List<User> actual = new ArrayList<>();
    actual.add(user1);
    Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void getHowManyUsers_FEMALE() {
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void getAllAgeUsers() {
    }

    @org.junit.Test
    public void getAllAgeUsers1() {
    }

    @org.junit.Test
    public void getAverageAgeOfAllUsers() {
    }

    @org.junit.Test
    public void getAverageAgeOfAllUsers1() {
    }
}