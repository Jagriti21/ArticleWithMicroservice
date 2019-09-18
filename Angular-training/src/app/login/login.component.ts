import { Component, OnInit } from '@angular/core';
import { login } from '../login.model';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { user } from '../user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  adminl: login=new login();

  info: user = new user();
  
  constructor(private router: Router, private loginService: LoginService) {

  }
//Create form
loginForm = new FormGroup({
  username: new FormControl('', Validators.required),
  password: new FormControl('', Validators.required), 
});
  ngOnInit() {
  }

  
  adminLogin(): void {
    
   this.loginService.loginCheck(this.adminl)
        .subscribe( (data) => {
         this.info=data;
         
         console.log(this.info.status);
         localStorage.setItem('sess',JSON.stringify(this.info));
          if(this.info.status!=0)
          {
            this.router.navigate(['s1']);
          }
          else{
            alert("invalid credential");
            this.router.navigate(['']);
          }

        });
      };
}
