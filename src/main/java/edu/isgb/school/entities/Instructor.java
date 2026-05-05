package edu.isgb.school.entities;

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
    private School school;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
  
    @JsonIgnore
    private List<Course> courses;
}
