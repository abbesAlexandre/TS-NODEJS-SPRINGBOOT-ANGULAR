package ovh.alexandreabbes.ListeDeCourse.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ovh.alexandreabbes.ListeDeCourse.exception.UserNotFoundException;
import ovh.alexandreabbes.ListeDeCourse.model.ItemCourse;
import ovh.alexandreabbes.ListeDeCourse.repo.ItemCourseRepo;

@Service
public class itemCourseService {
    private final ItemCourseRepo itemCourseRepo;

    @Autowired
    public itemCourseService(ItemCourseRepo itemCourseRepo) {
        this.itemCourseRepo = itemCourseRepo;
    }

    public ItemCourse addItemCourse(ItemCourse itemCourse) {
        itemCourse.setItemCourseCode(UUID.randomUUID().toString());
        return itemCourseRepo.save(itemCourse);
    }

    public List<ItemCourse> findAllItemsCourse() {
        return itemCourseRepo.findAll();
    }

    public ItemCourse updateItemCourse(ItemCourse itemCourse) {
        return itemCourseRepo.save(itemCourse);
    }

    public ItemCourse findItemCourseById(Long id) {
        return itemCourseRepo.findItemCourseById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id " + id + " was not found"));
    }

    public void deleteItemCourse(Long id) {
        itemCourseRepo.deleteItemCourseById(id);
    }
}