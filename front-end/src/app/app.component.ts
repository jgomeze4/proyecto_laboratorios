import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import {MatSnackBar} from '@angular/material';
import { CookieService} from 'ngx-cookie-service';
import { LoginService } from './services/login.service';
import { LoginComponent} from './login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,AfterViewInit {

  private cookieValue:string;
  constructor(private cookieService:CookieService, private loginService:LoginService, private snackBar:MatSnackBar){};
  title = 'LABX';
  errorMessage = "";
  authorized = false;
  InsScreen = false;
  InvScreen = false;
  SInvScreen = false;
  LInvScreen = false;
  loginToken = null;

  public ngOnInit():void{
    var cookieVal = this.cookieService.get('session');
    if(cookieVal != ''){
      this.autoLogin(cookieVal);
    }
  }
  public ngAfterViewInit (){

  }
  autoLogin(rawData:string){
    var _data = atob(rawData);
    var result ="";
    this.loginToken= { id:_data.split(';')[0], token:_data.split(';')[1] };
    this.loginService.doLoginToken(this.loginToken).subscribe(res => {
      result = res.toString();
      this.errorMessage ="";
      return this.authorized = true;
    },error =>{
      result = "";
      this.errorMessage ="Sesion Expirada";
      return this.authorized =false;
    });
  }
  authChangedHandler(auth:boolean) {
    this.authorized = auth;
    console.log(auth);
  }
}
