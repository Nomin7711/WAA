package edu.miu.nomin.jpa.assignment.repository;

import edu.miu.nomin.jpa.assignment.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
