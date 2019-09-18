import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';


import { Category } from '../category';
import { CategoryService } from '../category.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
 //Component properties
 allCategory: Category[];
 statusCode: number;
 requestProcessing = false;
 categoryIdToUpdate = null;
 processValidation = false;
 //Create form
 categoryForm = new FormGroup({
     categoryname: new FormControl('', Validators.required)
     });
 //Create constructor to get service instance
  constructor(private router: Router, private categoryService: CategoryService) { }

  ngOnInit(): void {
   
    if(localStorage.getItem('sess') == null){
      this.router.navigate(['']);
    }
    this.getAllCategory();
  }   
  //Fetch all articles
  getAllCategory() {
    this.categoryService.getAllCategory()
  .subscribe(
            data => this.allCategory = data,
            errorCode =>  this.statusCode = errorCode);   
}
 //Handle create and update article
 onCategoryFormSubmit() {
  this.processValidation = true;   
  if (this.categoryForm.invalid) {
       return; //Validation failed, exit from method.
  }   
 //Form is valid, now perform create or update
 this.preProcessConfigurations();
 let c = this.categoryForm.get('categoryname').value.trim();
 if (this.categoryIdToUpdate === null) {  
  //Handle create article
  let category= new Category(null, c);	  
  this.categoryService.createCategory(category)
    .subscribe(successCode => {
            this.statusCode = successCode;
        this.getAllCategory();	
      this.backToCreateCategory();
      },
        errorCode => this.statusCode = errorCode);
}else {  
  //Handle update article
let category= new Category(this.categoryIdToUpdate,c);	  
this.categoryService.updateCategory(category)
 .subscribe(successCode => {
         this.statusCode = successCode;
     this.getAllCategory();	
   this.backToCreateCategory();
   },
     errorCode => this.statusCode = errorCode);	  
}
}
//Load category by id to edit
loadCategoryToEdit(categoryId: string) {
  this.preProcessConfigurations();
  this.categoryService.getCategoryById(categoryId)
    .subscribe(category => {
            this.categoryIdToUpdate = category.categoryId;   
            this.categoryForm.setValue({ categoryname: category.categoryname});
      this.processValidation = true;
      this.requestProcessing = false;   
        },
        errorCode =>  this.statusCode = errorCode);   
}      
//Delete article
deleteCategory(categoryId: string) {
  this.preProcessConfigurations();
  this.categoryService.deleteCategoryById(categoryId)
    .subscribe(successCode => {
            this.statusCode = successCode;
        this.getAllCategory();	
        this.backToCreateCategory();
      },
        errorCode => this.statusCode = errorCode);    
}
//Perform preliminary processing configurations
preProcessConfigurations() {
  this.statusCode = null;
this.requestProcessing = true;   
}
//Go back from update to create
backToCreateCategory() {
  this.categoryIdToUpdate = null;
  this.categoryForm.reset();	  
this.processValidation = false;
}

adminLogout(){
  localStorage.clear();
  this.router.navigate(['']);
}

}
