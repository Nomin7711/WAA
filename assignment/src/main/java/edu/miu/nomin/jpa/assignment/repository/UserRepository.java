package edu.miu.nomin.jpa.assignment.repository;

import edu.miu.nomin.jpa.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost();
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) >= :n")
    List<User> findUsersWithMoreThanNPosts(int n);
    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findUsersWithTitle(String title);
}
