package Controller;


import Model.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/leave")
    public ResponseEntity<?> applyLeave(@RequestBody Leave leave) {
        Leave newLeave = leaveRepository.save(leave);
        return ResponseEntity.ok(newLeave);
    }

    @GetMapping("/leave")
    public ResponseEntity<?> getLeaves(@RequestParam Long studentId) {
        List<Leave> leaves = leaveRepository.findByStudentId(studentId);
        return ResponseEntity.ok(leaves);
    }
    @PostMapping("/fee")
    public ResponseEntity<?> payFee(@RequestBody Fee fee) {
        Fee newFee = feeRepository.save(fee);
        return ResponseEntity.ok(newFee);
    }
    @GetMapping("/fee")
    public ResponseEntity<?> getFees(@RequestParam Long studentId) {
        List<Fee> fees = feeRepository.findByStudentId(studentId);
        return ResponseEntity.ok(fees);
    }

    @PostMapping("/message")
    public ResponseEntity<?> dropMessage(@RequestBody Message message) {
        Message newMessage = messageRepository.save(message);
        return ResponseEntity.ok(newMessage);
    }

    @GetMapping("/message")
    public ResponseEntity<?> getMessages(@RequestParam Long studentId) {
        List<Message> messages = messageRepository.findByStudentId(studentId);
        return ResponseEntity.ok(messages);
    }


    //for update
    @Autowired
    private StudentRepository studentRepository;

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Student student = optionalStudent.get();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setPassword(updatedStudent.getPassword());
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }
}

