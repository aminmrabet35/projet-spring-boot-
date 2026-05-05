package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "t_student")
@Data
@Getter
@Setter
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
    private School school;
}
