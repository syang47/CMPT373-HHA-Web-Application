package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MSPPRequirement> folder;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CaseStudy> caseStudies;

    @Column
    private Integer reportsSubmitted;

    @Column
    private Integer points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Department getDepartments() {
        return department;
    }

    public void setDepartments(Department departments) {
        this.department = departments;
    }

    /*public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }*/

    public Set<MSPPRequirement> getFolder() {
        return folder;
    }

    public void setFolder(Set<MSPPRequirement> folder) {
        this.folder = folder;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<CaseStudy> getCaseStudies() {
        return caseStudies;
    }

    public void setCaseStudies(Set<CaseStudy> caseStudies) {
        this.caseStudies = caseStudies;
    }

    public Integer getReportsSubmitted() {
        return reportsSubmitted;
    }

    public void setReportsSubmitted(Integer reportsSubmitted) {
        this.reportsSubmitted = reportsSubmitted;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
