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

  public getListeDeCourseById(listeDeCourseId : number): Observable<ListeDeCourse[]> {
    return this.http.get<ListeDeCourse[]>(`${this.apiServerUrl}/ListeDeCourse/${listeDeCourseId}`);
  }

  public addListeDeCourse(ListeDeCourse: ListeDeCourse): Observable<ListeDeCourse> {
    return this.http.post<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/add`, ListeDeCourse);
  }

  public addItemListeDeCourse(listeDeCourse : ListeDeCourse, itemCourse : ItemCourse): Observable<ListeDeCourse> {
    return this.http.post<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/add-item`, [listeDeCourse, itemCourse]);
  }

  public updateListeDeCourse(listeDeCourse: ListeDeCourse): Observable<ListeDeCourse> {
    return this.http.put<ListeDeCourse>(`${this.apiServerUrl}/ListeDeCourse/update-liste-item`, listeDeCourse);
  }

  public removeItemFromListeDeCourse(listeDeCourse : ListeDeCourse, itemCourse : ItemCourse): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/ListeDeCourse/remove-item`);
  }

  public deleteListeDeCourse(ListeDeCourseId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/ListeDeCourse/delete/${ListeDeCourseId}`);
  }
}