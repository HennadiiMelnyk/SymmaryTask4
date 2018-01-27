package ua.nure.melnyk.SummaryTask4.model;

import ua.nure.melnyk.SummaryTask4.dto.UserDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * User Model
 *
 *
 *
 */
public class User implements Serializable {

    private static final long serialVersionUID = 9093829367495162826L;
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean active;


    public User() {

    }

    public User(int id, String name, String email, String password, String role, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active=active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, password);
    }
}
