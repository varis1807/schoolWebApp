package Controller;

import Model.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message")
    public ResponseEntity<?> getMessages(@RequestParam Long teacherId) {
        List<Message> messages = messageRepository.findByTeacherId(teacherId);
        return ResponseEntity.ok(messages);
    }
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return ResponseEntity.ok(teachers);
    }
}



