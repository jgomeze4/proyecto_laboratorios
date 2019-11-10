import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule,MatIconModule,MatButtonModule,MatSortModule,MatDialogModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {MatDatepickerModule} from '@angular/material';
import {MatNativeDateModule} from '@angular/material';

import { InsumoComponent } from './insumo/insumo.component';
import { InventarioComponent } from './inventario/inventario.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { DetalleInsComponent } from './insumo/detalle-ins/detalle-ins.component';
import { EditarInsComponent } from './insumo/editar-ins/editar-ins.component';
import { ListarInvComponent } from './inventario/listar-inv/listar-inv.component';
import { DetalleUsComponent } from './usuario/detalle-us/detalle-us.component';
import { AgregarInsComponent } from './insumo/agregar-ins/agregar-ins.component';
import { SacarInsComponent } from './insumo/sacar-ins/sacar-ins.component';
import { ListarInsComponent } from './insumo/listar-ins/listar-ins.component';
import { AgregarInvComponent } from './inventario/agregar-inv/agregar-inv.component';
import { LoginComponent } from './login/login.component';

import { InsumoService } from  'src/app/services/insumo.service';
import { InventarioService } from  'src/app/services/inventario.service';
import { LoginService } from  'src/app/services/login.service';

import { CookieService } from 'ngx-cookie-service';
import { SalidaInvComponent } from './inventario/salida-inv/salida-inv.component';

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
    AgregarInvComponent,
    LoginComponent,
    SalidaInvComponent,
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
    MatSnackBarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [InsumoService,InventarioService,LoginService,CookieService],
  bootstrap: [AppComponent],
  entryComponents: [AgregarInsComponent]
})
export class AppModule { }
