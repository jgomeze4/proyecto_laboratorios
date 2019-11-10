import { Usuario } from './usuario-model';

export class LoginResponse{
    success:boolean;
    data:Usuario;
    message:string;
}