package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByStudentId(Long studentId);
}
