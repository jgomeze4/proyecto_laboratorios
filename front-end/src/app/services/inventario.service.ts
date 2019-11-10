import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Inventario} from 'src/app/models/inventario-model';
import {Observable} from 'rxjs';
import {CookieService} from 'ngx-cookie-service';
import * as moment from 'moment';
import { InventarioUpdate } from '../models/inventarioUpdate-model';
import { InventarioList } from '../models/inventarioList-model';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  constructor(private http:HttpClient, private cookieService:CookieService) { }
  formData: Inventario;
  uformData: InventarioUpdate;

  readonly APIUrl="http://138.197.0.136:8080/api/inventario";
  getInventarioList():Observable<InventarioList[]>{
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    return this.http.get<InventarioList[]>(this.APIUrl +"/listar",{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
  addInventario(inv:Inventario){
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    const momentDate = new Date(inv.fechaVencimiento); // Replace event.value with your date value
    inv.fechaVencimiento = moment(momentDate).format("YYYY-MM-DD");
    return this.http.post(this.APIUrl+"/ingresar",inv,{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
  updateInventario(inv:InventarioUpdate){
    var _data = atob(this.cookieService.get('session'));
    let id:string = _data.split(';')[0];
    let token:string = 'Bearer '+_data.split(';')[1];
    return this.http.post(this.APIUrl+"/salida",inv,{headers:{'Content-Type':'application/json','Authorization':token,'id':id}});
  }
}
