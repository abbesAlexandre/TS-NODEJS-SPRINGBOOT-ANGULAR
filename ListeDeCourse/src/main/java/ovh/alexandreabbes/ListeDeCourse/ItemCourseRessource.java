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
@RequestMapping("/ListeDeCourse")
public class ItemCourseRessource {
    private final itemCourseService itemCourseService;

    public ItemCourseRessource(itemCourseService itemCourseService) {
        this.itemCourseService = itemCourseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemCourse>> getAllEmployees() {
        List<ItemCourse> ItemsCourse = itemCourseService.findAllItemsCourse();
        return new ResponseEntity<>(ItemsCourse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ItemCourse> getEmployeeById(@PathVariable("id") Long id) {
        ItemCourse ItemCourse = itemCourseService.findItemCourseById(id);
        return new ResponseEntity<>(ItemCourse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ItemCourse> addEmployee(@RequestBody ItemCourse itemCourse) {
        ItemCourse newItemCourse = itemCourseService.addItemCourse(itemCourse);
        return new ResponseEntity<>(newItemCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemCourse> updateEmployee(@RequestBody ItemCourse itemCourse) {
        ItemCourse updateItemCourse = itemCourseService.updateItemCourse(itemCourse);
        return new ResponseEntity<>(updateItemCourse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ItemCourse> deleteEmployee(@PathVariable("id") Long id) {
        itemCourseService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
