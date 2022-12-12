import { Component, OnInit } from '@angular/core';
import { ItemCourse } from './ItemCourse';
import { ItemCourseService } from './item-course.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public ItemsCourse: ItemCourse[];

  constructor(private ItemCourseService: ItemCourseService) { }

  ngOnInit(): void {
    this.getItemsCourse();
  }

  public getItemsCourse(): void {
    this.ItemCourseService.getItemsCourse().subscribe(
      (Response: ItemCourse[]) => {
        this.ItemsCourse = Response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
