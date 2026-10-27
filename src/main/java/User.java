import javax.naming.directory.InvalidSearchControlsException;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "password_hash")
    private String passwordHash;

    public Long getId() {
        return id;
    }

    public  User(String username, String passwordHash){
        if (username.length() > 99){
            throw new IllegalArgumentException("username character limit exceeded");
        }
        if (!username.matches("^[A-Za-z0-9._]+$")){
            throw new IllegalArgumentException("username contains invalid characters");
        }
        if (username.isBlank && username.isEmpty){
            throw new IllegalArgumentException("username is empty");
        }
        this.name = username;
        this.passwordHash = passwordHash;
    }

    public User(){

    }

}
