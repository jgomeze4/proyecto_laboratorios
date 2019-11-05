import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort } from '@angular/material';
import { Insumo}  from "src/app/models/insumo-model";
import { InsumoService } from 'src/app/services/insumo.service';

import {MatDialog,MatDialogConfig} from  '@angular/material';
import {AgregarInsComponent} from 'src/app/insumo/agregar-ins/agregar-ins.component';

@Component({
  selector: 'app-listar-ins',
  templateUrl: './listar-ins.component.html',
  styleUrls: ['./listar-ins.component.css']
})
export class ListarInsComponent implements OnInit {

  constructor(private service: InsumoService, private dialog:MatDialog) {
    this.service.listen().subscribe((m:any)=>{
      this.refreshInsList();
    })
   }
  listData:MatTableDataSource<any>;
  displayedColumns: string[] = ['Options','idProducto','nombre','marca','proveedor','codigo','presentacion','regInvima','clasificacionRiesgo','tempAlmacenamiento','activo', 'familia.nombre']
  @ViewChild(MatSort,null) sort:MatSort;
  ngOnInit() {
    this.refreshInsList();
  }
  refreshInsList(){
    //var dummyData =[{ID_PRODUCTO:1,ID_FAMILIA:1,Nombre:"prueba",Marca:"prueba",Proveedor:"prueba",Codigo:"prueba",Presentacion:"Prueba",RegINVIMA:"prueba",ClasificacionRiesgo:"prueba",TipoAlmacenamiento:"prueba",ID_USUARIO:1,Activo:1},{ID_PRODUCTO:2,ID_FAMILIA:1,Nombre:"abc",Marca:"abc",Proveedor:"abc",Codigo:"abc",Presentacion:"abc",RegINVIMA:"abc",ClasificacionRiesgo:"abc",TipoAlmacenamiento:"abc",ID_USUARIO:1,Activo:1}]
    //this.listData = new MatTableDataSource(dummyData);
    this.service.getInsumoList().subscribe(data =>{
      this.listData = new MatTableDataSource(data);
      this.listData.sort = this.sort;
    });  
  }
  onEdit(insumo:Insumo){
    console.log(insumo);
  }
  onDelete(id:number){
    console.log(id);
  }
  onAdd(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose =true;
    dialogConfig.autoFocus = true;
    dialogConfig.width ="70%";
    this.dialog.open(AgregarInsComponent, dialogConfig);
  }
  applyFilter(filterValue:string){
    this.listData.filter = filterValue.trim().toLowerCase();
  }
}
