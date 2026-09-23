import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

void main() {
    System.out.println("hi");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-factory");
    UserRepo ur = new UserRepo(emf);
    UserService us = new UserService(ur);
    us.createUser("mike");
}