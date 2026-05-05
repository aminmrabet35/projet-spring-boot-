package edu.isgb.school.entities;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "t_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
<<<<<<< HEAD
    @Id
=======
    @Id 
>>>>>>> 34d5e488f18f7e6657e5c90be86721fb4d6fcde8
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ADDRESS")
    private Integer idAddress;
    @Column(name = "cl_city")
    private String city;
    @Column(name = "cl_postal_Code")
    private String postalCode;
    @Column(name = "cl_street")
    private String street;}



