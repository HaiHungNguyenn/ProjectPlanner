package com.hunghai.projectplanner_be;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectplannerBeApplicationTests {

    @Autowired
    ProjectRepo repo ;
    @Test
    void contextLoads() {
        Project project = new Project();
        project.setTitle("Sample Project");
        project.setDetail("This is a sample detail.");
        project.setStatus(false);

        repo.save(project);
    }

}
