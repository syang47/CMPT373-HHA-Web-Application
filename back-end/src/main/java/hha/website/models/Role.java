package hha.website.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

    private RoleId name;
    @Id
    private String id;

    public RoleId getName() {
        return name;
    }

    public void setName(RoleId name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
