package ovh.alexandreabbes.ListeDeCourse.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ovh.alexandreabbes.ListeDeCourse.exception.UserNotFoundException;

import ovh.alexandreabbes.ListeDeCourse.model.ItemCourse;
import ovh.alexandreabbes.ListeDeCourse.model.ListeDeCourse;
import ovh.alexandreabbes.ListeDeCourse.repo.ListeDeCourseRepo;

@Service
public class ListeDeCourseService {
    private final ListeDeCourseRepo listeDeCourseRepo;

    @Autowired
    public ListeDeCourseService(ListeDeCourseRepo listeDeCourseRepo) {
        this.listeDeCourseRepo = listeDeCourseRepo;
    }

    public ListeDeCourse addListeDeCourse(ListeDeCourse listeDeCourse) {
        listeDeCourse.setItemCourseCode(UUID.randomUUID().toString());
        return listeDeCourseRepo.save(listeDeCourse);
    }

    public ListeDeCourse addItemListeDeCourse(ListeDeCourse listeDeCourse, ItemCourse itemCourse) {
        listeDeCourse.addItemCourse(listeDeCourse, itemCourse);
        return listeDeCourseRepo.save(listeDeCourse);
    }

    public ListeDeCourse updateListeItemCourse(ListeDeCourse listeDeCourse) {
        return listeDeCourseRepo.save(listeDeCourse);
    }

    public ListeDeCourse findListeDeCourseById(Long id) {
        return listeDeCourseRepo.findListeDeCourseById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id " + id + " was not found"));
    }

    public void removeItemFromListeDeCourse(ListeDeCourse listeDeCourse, ItemCourse itemCourse) {
        listeDeCourse.removeItemFromListeDeCourse(itemCourse);
    }

    public void deleteListeItemCourse(Long id) {
        listeDeCourseRepo.deleteListeDeCourseById(id);
    }
}