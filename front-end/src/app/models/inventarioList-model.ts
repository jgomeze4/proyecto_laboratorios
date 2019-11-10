import { Insumo } from './insumo-model';

export class InventarioList{
    producto:Insumo;
    bodega:string;
    lote:string;
    estado:string;
    cantidad:number;
    cantidadAnterior:number;
    fechaVencimiento:Date;
}