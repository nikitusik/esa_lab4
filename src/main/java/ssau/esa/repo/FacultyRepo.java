package ssau.esa.repo;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.model.Faculty;

public interface FacultyRepo extends CrudRepository<Faculty, Integer> {
}

