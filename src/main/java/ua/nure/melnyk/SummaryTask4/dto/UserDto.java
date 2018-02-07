package ua.nure.melnyk.SummaryTask4.dto;

import ua.nure.melnyk.SummaryTask4.model.Role;
import ua.nure.melnyk.SummaryTask4.model.Status;
import ua.nure.melnyk.SummaryTask4.model.User;

import java.util.Objects;

/**
 * User Data transfer object
 *
 *
 *
 */
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private Role role;


    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        //this.role = user.getRole();
        //this.status = user.getStatus();
    }

    public UserDto(int id, String name, String email, String password, Role role,Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id &&
                Objects.equals(name, userDto.name) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                role == userDto.role;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, password, role);
    }
}
