package com.sathiyapriyan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    private StudentRepository studentRepository;
 
    @GetMapping
    public List<Student> getAllStudents() {
    	List<Student> studentList=new ArrayList<>();
        studentRepository.findAll().forEach(i -> studentList.add(i));
        System.out.println(studentList);
        return studentList;
    }
    
    @GetMapping("/{id}")
    public Student getStudentDetails(@PathVariable int id) {
        return studentRepository.findOne(id).orElseThrow(StudentNotFoundException::new);
    }
    
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	studentRepository.findOne(id).orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(id);
    }
 
    @PutMapping
    public Student updateBook(@RequestBody Student book) {
    	studentRepository.findOne(book.getRollNo()).orElseThrow(StudentNotFoundException::new);
        return studentRepository.save(book);
    }
}
