package ru.itis.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Group extends AbstractEntity{

    @Column
    private Integer course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Timetable> timetables;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

}
