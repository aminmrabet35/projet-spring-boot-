package edu.isgb.school.services;

import edu.isgb.school.entities.*;
import edu.isgb.school.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public School createSchool(School school) {

        if (school.getDepartments() != null) {
            for (Departement d : school.getDepartments()) {
                d.setSchool(school);
            }
        }

        if (school.getStudents() != null) {
            for (Student s : school.getStudents()) {
                s.setSchool(school);
            }
        }

        if (school.getInstructors() != null) {
            for (Instructor i : school.getInstructors()) {
                i.setSchool(school);
            }
        }
        return schoolRepository.save(school);
    }


    public School getSchoolById(Integer id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.orElseThrow(() ->
                new RuntimeException("School not found with id: " + id));
    }


    public Student createStudent(Student student, Integer schoolId) {

        School school = getSchoolById(schoolId);


        student.setSchool(school);


        Student saved = studentRepository.save(student);


        school.getStudents().add(saved);
        return saved;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Instructor createInstructor(Instructor instructor, Integer schoolId) {
        School school = getSchoolById(schoolId);
        instructor.setSchool(school);


        if (instructor.getCourses() != null) {
            List<Course> savedCourses = courseRepository.saveAll(instructor.getCourses());
            instructor.setCourses(savedCourses);
        }

        Instructor saved = instructorRepository.save(instructor);
        school.getInstructors().add(saved);
        return saved;
    }


    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepository.findByName(name);
    }


    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Instructor not found with id: " + id));
    }


    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course not found with id: " + id));
    }

    public List<Course> getCoursesByInstructor(Integer instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        return instructor.getCourses();
    }


    public Instructor addCourseToInstructor(Integer instructorId, Course course) {
        Instructor instructor = getInstructorById(instructorId);

        Course savedCourse = courseRepository.save(course);
        instructor.getCourses().add(savedCourse);

        return instructorRepository.save(instructor);
    }
}
