package home.project.products.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

import static home.project.products.ProductsApplication.IMAGE_PATTERN;
import static home.project.products.ProductsApplication.PHONE_PATTERN;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = PHONE_PATTERN)
    private String phoneNumber;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(regexp = IMAGE_PATTERN)
    private String photo;

    @Size(min = 8, max = 24)
    private String password;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, String email, String photo, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.photo = photo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("\nUSER:\n");
        sb.append("Id: ").append(this.id);
        sb.append("\nFirst Name: ").append(this.firstName);
        sb.append("\nLast Name: ").append(this.lastName);
        sb.append("\nPhone Number: ").append(this.phoneNumber);
        sb.append("\nEmail: ").append(this.email);
        sb.append("\nPhoto: ").append(this.photo);
        sb.append("\nPassword: ").append(this.password).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
