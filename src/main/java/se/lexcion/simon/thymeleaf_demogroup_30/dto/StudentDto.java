package se.lexcion.simon.thymeleaf_demogroup_30.dto;

import javax.validation.constraints.*;
import java.util.Objects;

public class StudentDto {

    private int id;

    @NotBlank
    @Size(min = 2, max = 100, message = "Please specify a accepted Name. Must be between 2-100 characters.")
    private String name;

    @NotBlank
    @Email(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid Email")
    private String email;

    @AssertTrue(message = "This is needed!")
    private boolean accept;

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return id == that.id &&
                accept == that.accept &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, accept);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accept=" + accept +
                '}';
    }
}
