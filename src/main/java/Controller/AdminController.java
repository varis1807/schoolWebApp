package Controller;

import Model.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student newStudent = studentRepository.save(student);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping("/teacher")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (!optionalTeacher.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        teacher.setId(id);
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }
}

