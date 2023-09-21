package com.hunghai.projectplanner_be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo repo ;

    public List<Project> getAll() {
        return repo.findAll();
    }

    public Project getProjectDetail(String id) {
        return repo.findById(id).orElse(null);
    }

    public List<Project> getUncompletedProject() {
        return  repo.findAllByStatus(false);
    }
    public List<Project> getCompletedProject() {
        return  repo.findAllByStatus(true);
    }


    public void save(Project project) {
        Project a = new Project();
        a.setId(findMaxID());
        a.setTitle(project.getTitle());
        a.setDetail(project.getDetail());
        a.setStatus(false);
        repo.save(a);
    }

    public void deleteProject(Project project) {
        repo.delete(project);
    }

    public int findMaxID() {
        return repo.findMaxID()+1;
    }

    public void updateProject(String id, Project project) {
        Project x = getProjectDetail(id);
        x.setTitle(project.getTitle());
        x.setDetail(project.getDetail());
        repo.save(x);
    }

    public void changeStatus(String id) {
        Project x = getProjectDetail(id);
        x.setStatus(true);
        repo.save(x);
    }
}
