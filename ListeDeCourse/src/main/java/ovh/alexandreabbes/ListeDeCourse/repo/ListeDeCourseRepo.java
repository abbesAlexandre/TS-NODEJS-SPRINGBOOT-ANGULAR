package ovh.alexandreabbes.ListeDeCourse.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ovh.alexandreabbes.ListeDeCourse.model.ListeDeCourse;

public interface ListeDeCourseRepo extends JpaRepository<ListeDeCourse, Long>{
    void deleteListeDeCourseById(Long id);

    Optional<ListeDeCourse> findListeDeCourseById(Long id);
}