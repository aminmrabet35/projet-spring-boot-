package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "t_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Student")
    private Integer idStudent;

    @Column(name = "cl_name_school")
    private String name;

    @Column(name = "cl_birthdate")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
<<<<<<< HEAD
    @JsonBackReference("school-students")
=======
>>>>>>> 34d5e488f18f7e6657e5c90be86721fb4d6fcde8
    private School school;
}
