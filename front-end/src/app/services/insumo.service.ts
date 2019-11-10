import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {InsumoResponse} from 'src/app/models/insumoResponse-model';
import { CookieService} from 'ngx-cookie-service';
import {InsumoAdd} from 'src/app/models/insumoAdd-model';
import {Observable,Subject} from 'rxjs';
import { FamiliaResponse } from '../models/familiaResponse-model';

@Injectable({
  providedIn: 'root'
})
export class InsumoService {

  constructor(private http:HttpClient,private cookieService:CookieService) { }
  formData: InsumoAdd;

  readonly APIUrl="http://138.197.0.136:8081/api/insumo";
  readonly APIFUrl ="http://138.197.0.136:8081/api/familia";
  getInsumoList():Observable<any>{
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    return this.http.get<InsumoResponse[]>(this.APIUrl +"/listar",{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
  getFamiliaValues():Observable<any>{
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    return this.http.get<FamiliaResponse[]>(this.APIFUrl+"/listar",{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
  addInsumo(ins:InsumoAdd){
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    return this.http.post(this.APIUrl+"/crear",ins,{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
  private _listeners = new Subject<any>();
  listen():Observable<any>{
    return this._listeners.asObservable();
  }
  filter(filterBy:string){
    this._listeners.next(filterBy);
  }
}
