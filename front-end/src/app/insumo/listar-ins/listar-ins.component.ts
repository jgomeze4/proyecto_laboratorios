import { Component, OnInit, ViewChild,AfterViewInit } from '@angular/core';
import { MatTableDataSource, MatSort } from '@angular/material';
import { Insumo}  from "src/app/models/insumo-model";
import { InsumoService } from 'src/app/services/insumo.service';

import {MatDialog,MatDialogConfig,MatSnackBar} from  '@angular/material';
import {AgregarInsComponent} from 'src/app/insumo/agregar-ins/agregar-ins.component';

@Component({
  selector: 'app-listar-ins',
  templateUrl: './listar-ins.component.html',
  styleUrls: ['./listar-ins.component.css']
})
export class ListarInsComponent implements OnInit, AfterViewInit {

  constructor(private service: InsumoService, private dialog:MatDialog, public snackBar:MatSnackBar) {
    this.service.listen().subscribe((m:any)=>{
      this.refreshInsList();
    })
   }
  listData:MatTableDataSource<any>;
  displayedColumns: string[] = ['nombre','marca','proveedor','codigo','presentacion','regInvima','clasificacionRiesgo', 'familia.nombre']
  errorMsg:string ="";
  @ViewChild(MatSort,null) sort:MatSort;
  ngOnInit() {
    
  }
  ngAfterViewInit(){
    this.refreshInsList();
  }
  refreshInsList(){
    this.service.getInsumoList().subscribe(data =>{
      this.listData = new MatTableDataSource(data);
      this.listData.sort = this.sort;
    },error =>{
      this.errorMsg = error["error"]["message"];
      this.snackBar.open(this.errorMsg,'',{duration:4000, verticalPosition:'bottom'});
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
