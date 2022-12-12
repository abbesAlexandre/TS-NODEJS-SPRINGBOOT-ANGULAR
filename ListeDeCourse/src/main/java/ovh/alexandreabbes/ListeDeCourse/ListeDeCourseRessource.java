package ovh.alexandreabbes.ListeDeCourse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ovh.alexandreabbes.ListeDeCourse.service.ListeDeCourseService;
import ovh.alexandreabbes.ListeDeCourse.model.ItemCourse;
import ovh.alexandreabbes.ListeDeCourse.model.ListeDeCourse;

@RestController
@RequestMapping("/ListeDeCourse")
public class ListeDeCourseRessource {
    private final ListeDeCourseService listeDeCourseService;

    public ListeDeCourseRessource(ListeDeCourseService listeDeCourseService) {
        this.listeDeCourseService = listeDeCourseService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ListeDeCourse> getListeDeCourseById(@PathVariable("id") Long id) {
        ListeDeCourse listeDeCourse = listeDeCourseService.findListeDeCourseById(id);
        return new ResponseEntity<>(listeDeCourse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ListeDeCourse> addListeDeCourse(@RequestBody ListeDeCourse listeDeCourse) {
        ListeDeCourse newListeDeCourse = listeDeCourseService.addListeDeCourse(listeDeCourse);
        return new ResponseEntity<>(newListeDeCourse, HttpStatus.CREATED);
    }

    @PostMapping("/add-item")
    public ResponseEntity<ListeDeCourse> addItemListeDeCourse(@RequestBody ListeDeCourse listeDeCourse, ItemCourse itemCourse) {
        ListeDeCourse newItemListeDeCourse = listeDeCourseService.addItemListeDeCourse(listeDeCourse, itemCourse);
        return new ResponseEntity<>(newItemListeDeCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update-liste-item")
    public ResponseEntity<ListeDeCourse> updateListeDeCourse(@RequestBody ListeDeCourse listeDeCourse) {
        ListeDeCourse updateListeDeCourse = listeDeCourseService.updateListeItemCourse(listeDeCourse);
        return new ResponseEntity<>(updateListeDeCourse, HttpStatus.OK);
    }

    @DeleteMapping("/remove-item")
    public ResponseEntity<ListeDeCourse> removeItemFromListeDeCourse(@RequestBody ListeDeCourse listeDeCourse, ItemCourse itemCourse) {
        listeDeCourseService.removeItemFromListeDeCourse(listeDeCourse, itemCourse);;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ListeDeCourse> deleteListeDeCourse(@PathVariable("id") Long id) {
        listeDeCourseService.deleteListeItemCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
