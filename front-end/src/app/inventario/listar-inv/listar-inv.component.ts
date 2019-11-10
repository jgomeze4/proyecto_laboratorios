import { Component, OnInit, ViewChild,AfterViewInit } from '@angular/core';
import { MatTableDataSource, MatSort,MatSnackBar } from '@angular/material';
import { Insumo}  from "src/app/models/insumo-model";
import { InventarioList} from 'src/app/models/inventarioList-model';
import { InventarioService } from 'src/app/services/inventario.service';

@Component({
  selector: 'app-listar-inv',
  templateUrl: './listar-inv.component.html',
  styleUrls: ['./listar-inv.component.css']
})
export class ListarInvComponent implements OnInit, AfterViewInit {
  
  constructor(private service: InventarioService, public snackBar:MatSnackBar) { }
  listData:MatTableDataSource<any>;
  displayedColumns: string[] = ['producto.nombre','producto.familia.nombre','bodega','lote','cantidad', 'cantidadAnterior','fechaVencimiento']
  errorMsg:string ="";
  @ViewChild(MatSort,null) sort:MatSort;
  
  ngOnInit() {
  }
  ngAfterViewInit(){
    this.refreshInsList();
  }
  refreshInsList(){
    this.service.getInventarioList().subscribe(data =>{
      this.listData = new MatTableDataSource(data);
      this.listData.sort = this.sort;
    },error =>{
      this.errorMsg = error["error"]["message"];
      this.snackBar.open(this.errorMsg,'',{duration:4000, verticalPosition:'bottom'});
    });  
  }
  applyFilter(filterValue:string){
    this.listData.filter = filterValue.trim().toLowerCase();
  }
}
