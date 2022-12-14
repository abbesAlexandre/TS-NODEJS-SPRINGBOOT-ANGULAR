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

import ovh.alexandreabbes.ListeDeCourse.service.itemCourseService;
import ovh.alexandreabbes.ListeDeCourse.model.ItemCourse;

@RestController
@RequestMapping("ListeDeCourse/ItemCourse")
public class ItemCourseRessource {
    private final itemCourseService itemCourseService;

    public ItemCourseRessource(itemCourseService itemCourseService) {
        this.itemCourseService = itemCourseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemCourse>> getAllItemsCourse() {
        List<ItemCourse> ItemsCourse = itemCourseService.findAllItemsCourse();
        return new ResponseEntity<>(ItemsCourse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ItemCourse> getItemCourseById(@PathVariable("id") Long id) {
        ItemCourse ItemCourse = itemCourseService.findItemCourseById(id);
        return new ResponseEntity<>(ItemCourse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ItemCourse> addItemCourse(@RequestBody ItemCourse itemCourse) {
        ItemCourse newItemCourse = itemCourseService.addItemCourse(itemCourse);
        return new ResponseEntity<>(newItemCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemCourse> updateItemCourse(@RequestBody ItemCourse itemCourse) {
        ItemCourse updateItemCourse = itemCourseService.updateItemCourse(itemCourse);
        return new ResponseEntity<>(updateItemCourse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ItemCourse> deleteItemCourse(@PathVariable("id") Long id) {
        itemCourseService.deleteItemCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
