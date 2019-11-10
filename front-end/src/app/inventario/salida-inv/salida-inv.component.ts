import { Component, OnInit } from '@angular/core';
import { InventarioService } from 'src/app/services/inventario.service';
import { NgForm} from '@angular/forms'; 
import {Insumo} from "src/app/models/insumo-model";
import {InsumoService} from 'src/app/services/insumo.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-salida-inv',
  templateUrl: './salida-inv.component.html',
  styleUrls: ['./salida-inv.component.css']
})
export class SalidaInvComponent implements OnInit {

  constructor(public service:InventarioService,public serviceInsumo:InsumoService,private snackBar:MatSnackBar) { }
  public listItems:Array<Insumo>=[];
  errorMsg:string  = "";
  ngOnInit() {
    this.resetForm();
    this.dropdownRefresh();
  }

  resetForm(form?:NgForm){
    if(form != null)
    form.resetForm();
    this.service.uformData ={
      idProducto:null,
      idBodega:'1',
      lote:'',
      cantidad:1,
    }
  }
  dropdownRefresh(){
    this.serviceInsumo.getInsumoList().subscribe(data=>{
      data.forEach(element => {
        this.listItems.push(element);
      });
    });
  }
  onSubmit(form:NgForm){
    this.service.updateInventario(form.value).subscribe(res =>{
      this.resetForm();
      this.snackBar.open('Inventario Actualizado Exitosamente','',{duration:4000, verticalPosition:'bottom'});
    }, error =>{
      this.errorMsg = error["error"]["message"];
      this.snackBar.open(this.errorMsg,'',{duration:4000, verticalPosition:'bottom'});
    })
  }

}
