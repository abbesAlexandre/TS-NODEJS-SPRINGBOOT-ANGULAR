package ovh.alexandreabbes.ListeDeCourse.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ItemCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String typeItem;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String itemCourseCode;

    public ItemCourse() {
    }

    public ItemCourse(String name, String typeItem, String imageUrl, String itemCourseCode) {
        this.name = name;
        this.typeItem = typeItem;
        this.imageUrl = imageUrl;
        this.itemCourseCode = itemCourseCode;
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

    public String getTypeItem() {
        return typeItem;
    }

    public void getTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getItemCourseCode() {
        return itemCourseCode;
    }

    public void setItemCourseCode(String itemCourseCode) {
        this.itemCourseCode = itemCourseCode;
    }

    @Override
    public String toString() {
        return "ItemCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeItem='" + typeItem + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}