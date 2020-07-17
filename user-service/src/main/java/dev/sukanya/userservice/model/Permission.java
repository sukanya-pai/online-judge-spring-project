package dev.sukanya.userservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="permissions")
public class Permission {

    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "permissions")
    private List<Role> roles;

}
