import { Inventario } from './inventario-model';

export class InventarioResponse{
    success:boolean;
    data:Inventario;
    message:string;
}