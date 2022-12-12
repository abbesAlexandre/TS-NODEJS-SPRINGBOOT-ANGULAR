import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { ListeDeCourse } from "./ListeDeCourse";
import { environment } from "./environments/environment";
import { ItemCourse } from "./ItemCourse";

@Injectable({
  providedIn: 'root'
})
export class ListeDeCourseService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getListeDeCourseById(): Observable<ListeDeCourse[]> {
    return this.http.get<ListeDeCourse[]>(`${this.apiServerUrl}/ListeDeCourse/all`);
  }

  public addListeDeCourse(ListeDeCourse: ListeDeCourse): Observable<ListeDeCourse> {
    return this.http.post<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/add`, ListeDeCourse);
  }

  public addItemListeDeCourse(itemCourse : ItemCourse): Observable<ListeDeCourse> {
    return this.http.post<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/add-item`, itemCourse);
  }

  public updateItemsCourse(employee: ListeDeCourse): Observable<ListeDeCourse> {
    return this.http.put<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/update`, employee);
  }

  public deleteItemsCourse(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/ListeDeCourse/delete/${employeeId}`);
  }
}