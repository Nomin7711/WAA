package edu.miu.nomin.jpa.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Comment {

    @Id@GeneratedValue
    private Long id;
    private String name;
}
