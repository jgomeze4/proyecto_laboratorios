import { Familia } from './familia-model';

export class Insumo{
    idProducto:number;
    nombre:string;
    marca:string;
    proveedor:string;
    codigo:string;
    presentacion:string;
    regInvima:string;
    clasificacionRiesgo:string;
    tempAlmacenamiento:string;
    activo:string;
    familia:Familia;
}