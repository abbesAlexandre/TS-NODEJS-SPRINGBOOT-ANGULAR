package ovh.alexandreabbes.ListeDeCourse.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ListeDeCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private List<ItemCourse> MyItemsCourse;
    @Column(nullable = false, updatable = false)
    private String listeDeCourseCode;

    public ListeDeCourse() {
    }

    public ListeDeCourse(String name, List<ItemCourse> MyItemsCourse, String listeDeCourseCode) {
        this.name = name;
        this.MyItemsCourse = MyItemsCourse;
        this.listeDeCourseCode = listeDeCourseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemCourse> getMyItemsCourses() {
        return MyItemsCourse;
    }

    public void addItemCourse(ListeDeCourse listDeCourse, ItemCourse myItemCourse) {
        listDeCourse.MyItemsCourse.add(myItemCourse);
    }

    public void removeItemFromListeDeCourse(ItemCourse itemCourse) {
        MyItemsCourse.remove(itemCourse);
    }

    public String getItemCourseCode() {
        return listeDeCourseCode;
    }

    public void setItemCourseCode(String listeDeCourseCode) {
        this.listeDeCourseCode = listeDeCourseCode;
    }

    @Override
    public String toString() {
        return "ItemCourse{" +
                "id=" + id +
                ", MyItemsCourse='" + MyItemsCourse + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}