package Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}


