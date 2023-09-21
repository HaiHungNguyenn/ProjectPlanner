package com.hunghai.projectplanner_be;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping("/")

    public List<Project> getProjectList(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Project getProject(@PathVariable(name = "id") String id){
        return service.getProjectDetail(id);
    }
    @GetMapping("/uncompleted")
    public List<Project> getUncompletedProject(){
        return service.getUncompletedProject();
    }
    @GetMapping("/completed")
    public List<Project> getCompletedProject(){
        return service.getCompletedProject();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/add")
    public void addProject(@RequestBody Project project){service.save(project);}

    @DeleteMapping("/{id}")
    public List<Project> deleteProject(@PathVariable(name="id") String id){
        service.deleteProject(getProject(id));
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void updateProject (@PathVariable(name="id") String id,@RequestBody Project project){service.updateProject(id,project);}

    @PutMapping("/update/{id}")
    public List<Project>changeStatus (@PathVariable(name="id") String id){
        service.changeStatus(id);
        return service.getAll();
    }

}
