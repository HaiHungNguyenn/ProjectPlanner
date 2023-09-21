package com.hunghai.projectplanner_be;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "detail")
    private String detail;
    @Basic
    @Column(name = "status")
    private boolean status;

    public Project(String title, String detail, boolean status){
        this.title = title;
        this.detail = detail;
        this.status = status;
    }
    public boolean getStatus() {
        return this.status;
    }
}
