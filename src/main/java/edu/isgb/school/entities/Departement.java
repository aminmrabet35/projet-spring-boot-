package edu.isgb.school.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "t_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_department")
    private Integer idDept;
    @Column(name = "cl_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)

    @JsonBackReference("school-departments")

    private School school;
}
