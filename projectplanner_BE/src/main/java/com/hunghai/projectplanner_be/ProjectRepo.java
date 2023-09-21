package com.hunghai.projectplanner_be;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, String> {
    Optional<Project> findById(String id);

    List<Project> findAllByStatus(boolean b);

    @Query("SELECT MAX(p.id) FROM Project p")
    int findMaxID();
}
