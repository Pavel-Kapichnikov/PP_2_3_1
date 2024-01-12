package web.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 2, max = 30, message = " Name should be between 2 and 30 characters")
    @NotBlank(message = " Name should not be empty")
    private String name;
    @Size(min = 2, max = 30, message = " Last Name should be between 2 and 30 characters")
    @NotBlank(message = " Last Name should not be empty")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = " Age should not be null")
    @Min(value = 0, message = " Age should be greater then 0")
    private Integer age;

    public User() {
    }

    public User(long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = (31 * result) ^ Objects.hashCode(id);
        result = (31 * result) ^ Objects.hashCode(name);
        result = (31 * result) ^ Objects.hashCode(lastName);
        result = (31 * result) ^ Objects.hashCode(age);
        return result;
    }
}
