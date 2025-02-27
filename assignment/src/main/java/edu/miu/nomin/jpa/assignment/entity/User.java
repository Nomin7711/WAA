package edu.miu.nomin.jpa.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id@GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    public User() {}
    public User(String name) {
        this.name = name;
    }
}
