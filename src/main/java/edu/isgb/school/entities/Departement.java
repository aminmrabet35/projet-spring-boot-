package edu.isgb.school.entities;
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
<<<<<<< HEAD

    @JsonBackReference("school-departments")

=======
>>>>>>> 34d5e488f18f7e6657e5c90be86721fb4d6fcde8
    private School school;
}
