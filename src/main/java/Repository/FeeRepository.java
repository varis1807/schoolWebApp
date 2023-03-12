package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findByStudentId(Long studentId);
}

