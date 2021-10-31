package nl.novi.testjunitjupiter.model.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @OneToMany(
            targetEntity = nl.novi.testjunitjupiter.model.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<nl.novi.testjunitjupiter.model.model.Authority> authorities = new HashSet<>();

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<nl.novi.testjunitjupiter.model.model.Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(nl.novi.testjunitjupiter.model.model.Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(nl.novi.testjunitjupiter.model.model.Authority authority) {
        this.authorities.remove(authority);
    }

}