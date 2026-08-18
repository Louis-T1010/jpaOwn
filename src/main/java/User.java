import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    String name;

    public Long getId() {
        return id;
    }

    User(String name){
        this.name = name;
    }

    public User(){

    }

}
