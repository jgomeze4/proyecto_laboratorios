import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from 'src/app/models/login-model';
import { LoginToken } from 'src/app/models/loginToken-model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  constructor(private http:HttpClient) { }
  formData: Login;
  loginToken:LoginToken;

  readonly APIUrl="http://138.197.0.136:8082/api/security";
  doLogin(login:Login){
    login.contrasena = btoa(login.contrasena);
    return this.http.post(this.APIUrl+"/autenticar",login);
  }
  doLoginToken(logintoken:LoginToken){
    return this.http.post(this.APIUrl+"/validar",logintoken, 
    { responseType: 'text'});
  }
}
