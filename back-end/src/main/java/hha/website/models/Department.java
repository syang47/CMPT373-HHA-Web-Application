package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="departments")
public class Department {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Id
    @Column(unique = true)
    private String departmentname;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

    @Column
    private Integer points;

    @Column
    private Integer reportsSubmitted;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MessageBoard> messages;

    /*
    for if one user can belong to many departments
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "department_users",
            joinColumns = {
                @JoinColumn(name = "department_id")
            }, inverseJoinColumns = {
                @JoinColumn(name = "user_id")
    })
    private Set<User> users;*/

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUsers(Set<User> newUsers) {
        users.addAll(newUsers);
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getReportsSubmitted() {
        return reportsSubmitted;
    }

    public void setReportsSubmitted(Integer reportsSubmitted) {
        this.reportsSubmitted = reportsSubmitted;
    }

    public Set<MessageBoard> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageBoard> messages) {
        this.messages = messages;
    }
}
