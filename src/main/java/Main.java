import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class Main{
    public static void main(String[] args) {
        User user = new User("mike","TEST_HASH_NOT_FOR_AUTH");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-factory");
        UserRepo ur = new UserRepo(emf);
        UserService us = new UserService(ur);
        us.createUser(user);
    }
}