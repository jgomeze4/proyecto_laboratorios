import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Insumo} from 'src/app/models/insumo-model';
import {InsumoAdd} from 'src/app/models/insumoAdd-model';
import {Observable,Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InsumoService {

  constructor(private http:HttpClient) { }
  formData: InsumoAdd;

  readonly APIUrl="http://138.197.0.136:8081/api/insumo";
  getInsumoList():Observable<Insumo[]>{
    return this.http.get<Insumo[]>(this.APIUrl +"/listar");
  }
  addInsumo(ins:InsumoAdd){
    ins.activo = "A";
    return this.http.post(this.APIUrl+"/crear",ins);
  }
  private _listeners = new Subject<any>();
  listen():Observable<any>{
    return this._listeners.asObservable();
  }
  filter(filterBy:string){
    this._listeners.next(filterBy);
  }
}
