package Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Model.*;

import java.util.List;
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

