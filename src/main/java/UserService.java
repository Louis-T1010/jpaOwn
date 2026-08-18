import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-factory");
    EntityManager em = emf.createEntityManager();

    User createUser(String name){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User user = new User(name);
        em.persist(user);
        tx.commit();
        em.close();
        return user;
    }

}
