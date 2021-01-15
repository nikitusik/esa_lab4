package ssau.esa.repo;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
