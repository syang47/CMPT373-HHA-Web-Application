package hha.website.models;

import com.sun.istack.NotNull;

import java.util.Set;

public class DepartmentDTO {
    private Set<User> users;

    @NotNull
    private String departmentname;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDepartment() {
        return departmentname;
    }

    public void setDepartment(String departmentname) {
        this.departmentname = departmentname;
    }
}
