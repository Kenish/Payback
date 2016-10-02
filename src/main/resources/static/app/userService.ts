
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {IUser} from "./user";
import 'rxjs/Rx';
import {Observable} from "rxjs";
import {address} from "./address";
@Injectable()
export class userService{
    private _userLink='api/users';

    constructor(private http:Http){}

    getUsers():Observable<IUser[]>{
        return this.http.get(this._userLink)
            .map((response:Response)=> <IUser[]>response.json())
            .do(data=>console.log('a'+JSON.stringify(data)))
    }
    getAddreses(id:Number):Observable<address[]>{
        return this.http.get("api/users/"+id+"/addresses")
            .map((addresses:Response)=><address[]>addresses.json())
            .do(data=>console.log('a'+JSON.stringify(data)))
    }
}