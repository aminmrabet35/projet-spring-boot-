package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "t_school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_school")
    private Integer idSchool;

    @Column(name = "cl_name_school")
    private String name;

    @Column(name = "cl_phone")
    private Integer phone;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference("school-departments")
    private List<Departement> departments;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference("school-students")
    private List<Student> students;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference("school-instructors")
    private List<Instructor> instructors;
}