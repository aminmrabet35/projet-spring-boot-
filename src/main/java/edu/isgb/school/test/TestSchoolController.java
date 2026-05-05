package edu.isgb.school.test;

import edu.isgb.school.entities.*;
import edu.isgb.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestSchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/school/create")
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping("/school/{id}")
    public School getSchoolById(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }

    @PostMapping("/school/{schoolId}/student")
    public Student createStudent(@RequestBody Student student,
                                 @PathVariable Integer schoolId) {
        return schoolService.createStudent(student, schoolId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }

    @PostMapping("/school/{schoolId}/instructor")
    public Instructor createInstructor(@RequestBody Instructor instructor,
                                       @PathVariable Integer schoolId) {
        return schoolService.createInstructor(instructor, schoolId);
    }

    @GetMapping("/instructors")
    public List<Instructor> getInstructorsByName(@RequestParam String name) {
        return schoolService.getInstructorsByName(name);
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructorById(@PathVariable Integer id) {
        return schoolService.getInstructorById(id);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return schoolService.getCourseById(id);
    }

    @GetMapping("/instructor/{id}/courses")
    public List<Course> getCoursesByInstructor(@PathVariable Integer id) {
        return schoolService.getCoursesByInstructor(id);
    }

    @PostMapping("/instructor/{id}/course")
    public Instructor addCourseToInstructor(@PathVariable Integer id,
                                            @RequestBody Course course) {
        return schoolService.addCourseToInstructor(id, course);
    }
}