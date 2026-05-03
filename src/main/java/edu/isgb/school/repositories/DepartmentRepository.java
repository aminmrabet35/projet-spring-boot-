package edu.isgb.school.repositories;

import edu.isgb.school.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departement, Integer> {
}