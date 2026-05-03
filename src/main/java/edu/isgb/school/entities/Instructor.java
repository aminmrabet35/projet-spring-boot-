package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "t_instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_Instructor")
    private Integer idInstructor;

    @Column(name = "name_Instructor")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_PK_school")
    @JsonBackReference("school-instructors")
    private School school;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "t_instructor_t_course",
            joinColumns = @JoinColumn(name = "instructors_pk_Instructor"),
            inverseJoinColumns = @JoinColumn(name = "courses_pk_course")
    )
    @JsonIgnore
    private List<Course> courses;
}