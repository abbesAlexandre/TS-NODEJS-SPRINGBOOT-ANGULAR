import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { ItemCourse } from "./ItemCourse";
import { environment } from "./environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ItemCourseService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getItemsCourse(): Observable<ItemCourse[]> {
    return this.http.get<ItemCourse[]>(`${this.apiServerUrl}/ListeDeCourse/all`);
  }

  public addItemsCourse(itemCourse: ItemCourse): Observable<ItemCourse> {
    return this.http.post<ItemCourse>(`${this.apiServerUrl}/ListeDeCourse/add`, itemCourse);
  }

  public updateItemsCourse(itemCourse: ItemCourse): Observable<ItemCourse> {
    return this.http.put<ItemCourse>(`${this.apiServerUrl}/ListeDeCourse/update`, itemCourse);
  }

  public deleteItemsCourse(itemCourseId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/ListeDeCourse/delete/${itemCourseId}`);
  }
}