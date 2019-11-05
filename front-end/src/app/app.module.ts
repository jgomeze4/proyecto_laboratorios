import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule,MatIconModule,MatButtonModule,MatSortModule,MatDialogModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';

import { InsumoComponent } from './insumo/insumo.component';
import { InventarioComponent } from './inventario/inventario.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { DetalleInsComponent } from './insumo/detalle-ins/detalle-ins.component';
import { EditarInsComponent } from './insumo/editar-ins/editar-ins.component';
import { ListarInvComponent } from './inventario/listar-inv/listar-inv.component';
import { DetalleUsComponent } from './usuario/detalle-us/detalle-us.component';
import { AgregarInsComponent } from './insumo/agregar-ins/agregar-ins.component';
import { SacarInsComponent } from './insumo/sacar-ins/sacar-ins.component';

import { InsumoService } from  'src/app/services/insumo.service';
import { InventarioService } from  'src/app/services/inventario.service';
import { UsuarioService } from  'src/app/services/usuario.service';
import { ListarInsComponent } from './insumo/listar-ins/listar-ins.component';
import { AgregarInvComponent } from './inventario/agregar-inv/agregar-inv.component';

@NgModule({
  declarations: [
    AppComponent,
    InsumoComponent,
    InventarioComponent,
    UsuarioComponent,
    DetalleInsComponent,
    EditarInsComponent,
    ListarInvComponent,
    DetalleUsComponent,
    AgregarInsComponent,
    SacarInsComponent,
    ListarInsComponent,
    AgregarInvComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatSortModule,
    MatDialogModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [InsumoService,InventarioService,UsuarioService],
  bootstrap: [AppComponent],
  entryComponents: [AgregarInsComponent]
})
export class AppModule { }
