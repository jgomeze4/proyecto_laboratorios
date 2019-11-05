import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Inventario} from 'src/app/models/inventario-model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  constructor(private http:HttpClient) { }
  formData: Inventario;

  readonly APIUrl="http://138.197.0.136:8080/api/inventario";
  getInventarioList():Observable<Inventario[]>{
    return this.http.get<Inventario[]>(this.APIUrl +"/listar");
  }
  addInventario(inv:Inventario){
    return this.http.post(this.APIUrl+"/crear",inv);
  }
}
