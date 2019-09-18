import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/Rx';
import { Category } from './category';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
 
export class CategoryService {
  //URLs for CRUD operations
  allCategoryUrl = "http://localhost:9087/user/all-category";
  categoryUrl = "http://localhost:9087/user/category";
  //Create constructor to get Http instance
  
    constructor(private http:Http) { }
    //Fetch all articles
    getAllCategory(): Observable<Category[]> {
      return this.http.get(this.allCategoryUrl)
         .map(this.extractData)
          .catch(this.handleError);
  
  }
  //Create article
  createCategory(category: Category):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
      let options = new RequestOptions({ headers: cpHeaders });
      return this.http.post(this.categoryUrl, category, options)
             .map(success => success.status)
             .catch(this.handleError);
  }
  //Fetch article by id
  getCategoryById(categoryId: string): Observable<Category> {
  let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
  let cpParams = new URLSearchParams();
  cpParams.set('id', categoryId);			
  let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
  return this.http.get(this.categoryUrl, options)
       .map(this.extractData)
       .catch(this.handleError);
  }	
  //Update article
  updateCategory(category: Category):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
      let options = new RequestOptions({ headers: cpHeaders });
      return this.http.put(this.categoryUrl, category, options)
             .map(success => success.status)
             .catch(this.handleError);
  }
  //Delete article	
  deleteCategoryById(categoryId: string): Observable<number> {
  let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
  let cpParams = new URLSearchParams();
  cpParams.set('id', categoryId);			
  let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
  return this.http.delete(this.categoryUrl, options)
       .map(success => success.status)
       .catch(this.handleError);
  }		
  private extractData(res: Response) {
    let body = res.json();
      return body;
  }
  private handleError (error: Response | any) {
  console.error(error.message || error);
  return Observable.throw(error.status);
  }
  }
  