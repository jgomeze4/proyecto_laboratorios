import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { InsumoService } from 'src/app/services/insumo.service';
import { NgForm} from '@angular/forms';
@Component({
  selector: 'app-agregar-ins',
  templateUrl: './agregar-ins.component.html',
  styleUrls: ['./agregar-ins.component.css']
})
export class AgregarInsComponent implements OnInit {

  constructor(public dialogbox:MatDialogRef<AgregarInsComponent>, public service:InsumoService) { }

  ngOnInit() {
    this.resetForm();
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
      idUsuario:null,
      clasificacionRiesgo:'',
      tempAlmacenamiento:'',
      activo:'A',
      idFamilia:1
    }
  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  onSubmit(form:NgForm){
    this.service.addInsumo(form.value).subscribe(res =>{
      this.resetForm();
      alert("Añadido Exitosamente");
      this.dialogbox.close();
    })
  }
}
