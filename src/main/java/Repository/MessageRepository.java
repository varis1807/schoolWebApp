package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByStudentId(Long studentId);
    List<Message> findByTeacherId(Long teacherId);
}

