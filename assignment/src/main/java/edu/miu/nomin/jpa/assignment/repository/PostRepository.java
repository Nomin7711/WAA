package edu.miu.nomin.jpa.assignment.repository;

import edu.miu.nomin.jpa.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}
