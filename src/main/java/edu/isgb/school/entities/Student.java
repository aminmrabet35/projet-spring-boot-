package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_PK_ADDRESS")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    @JsonBackReference("school-students")
    private School school;
}
