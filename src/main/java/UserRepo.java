import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class UserRepo {
    private final EntityManagerFactory emf;
    public UserRepo(EntityManagerFactory emf){
        this.emf = emf;
    }
    public User createUser(String name){
        User user = new User(name);
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(user);
                tx.commit();
            }catch(RuntimeException e){
                if(tx.isActive()){
                    try {
                        tx.rollback();
                    }catch(RuntimeException rbE){
                        e.addSuppressed(rbE);
                    }
                }
                throw e;
            }
        }
        return user;
    }
}
