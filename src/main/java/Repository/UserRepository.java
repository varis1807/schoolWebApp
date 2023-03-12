package Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;
public interface UserRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}

