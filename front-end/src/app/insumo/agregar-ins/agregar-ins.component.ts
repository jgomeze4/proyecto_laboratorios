import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { InsumoService } from 'src/app/services/insumo.service';
import { NgForm} from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { Familia } from 'src/app/models/familia-model';

@Component({
  selector: 'app-agregar-ins',
  templateUrl: './agregar-ins.component.html',
  styleUrls: ['./agregar-ins.component.css']
})
export class AgregarInsComponent implements OnInit {

  constructor(public dialogbox:MatDialogRef<AgregarInsComponent>, 
    public service:InsumoService, 
    private snackBar:MatSnackBar) { }
    public listItems:Array<Familia>=[];
    public errorMsg:string;
    
    ngOnInit() {
      this.resetForm();
      this.dropdownRefresh();
    }
  resetForm(form?:NgForm){
    if(form != null)
    form.resetForm();

    this.service.formData ={
      idProducto:null,
      nombre:'',
      marca:'',
      proveedor:'',
      codigo:'',
      presentacion:'',
      regInvima:'',
      clasificacionRiesgo:'',
      tempAlmacenamiento:'',
      idFamilia:''
    }
  }
  dropdownRefresh(){
    this.service.getFamiliaValues().subscribe(data=>{
      data.forEach(element => {
        this.listItems.push(element);
      });
    });
  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  onSubmit(form:NgForm){
    this.service.addInsumo(form.value).subscribe(res =>{
      this.resetForm();
      this.snackBar.open('Insumo Añadido Exitosamente','',{duration:4000, verticalPosition:'bottom'});
      this.dialogbox.close();
    },  error =>{
      this.errorMsg = error["error"]["message"];
      this.snackBar.open(this.errorMsg,'',{duration:4000, verticalPosition:'bottom'});
    })
  }
}
