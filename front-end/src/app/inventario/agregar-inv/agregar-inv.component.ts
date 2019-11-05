import { Component, OnInit } from '@angular/core';
import { InventarioService } from 'src/app/services/inventario.service';
import { NgForm} from '@angular/forms'; 

@Component({
  selector: 'app-agregar-inv',
  templateUrl: './agregar-inv.component.html',
  styleUrls: ['./agregar-inv.component.css']
})
export class AgregarInvComponent implements OnInit {

  constructor(public service:InventarioService) { }

  ngOnInit() {
    this.resetForm();
  }
  resetForm(form?:NgForm){
    if(form != null)
    form.resetForm();
    this.service.formData ={
      idProducto:null,
      idBodega:null,
      idUsuario:null,
      lote:'',
      activo:'',
      cantidad:0,
      fechaVencimiento:null,
    }
  }

  onSubmit(form:NgForm){
    this.service.addInventario(form.value).subscribe(res =>{
      this.resetForm();
      alert(res);
    })
  }
}
