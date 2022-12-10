package ovh.alexandreabbes.ListeDeCourse.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ovh.alexandreabbes.ListeDeCourse.model.ItemCourse;

public interface ItemCourseRepo extends JpaRepository<ItemCourse, Long> {
    void deleteItemCourseById(Long id);

    Optional<ItemCourse> findItemCourseById(Long id);
}