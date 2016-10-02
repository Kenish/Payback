import {address} from "./address";
export interface IUser{
    id:number;
    firstName:string;
    surname:string;
    email:string;
    addresses:address[];
}
