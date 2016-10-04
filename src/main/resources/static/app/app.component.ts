import {Component, OnInit} from '@angular/core';
import {IUser} from "./user";
import {userService} from "./userService";


@Component({
    selector: 'my-app',
    template: `
<div class='panel panel-primary'>
    <div class='panel-heading'>
       Users
    </div>
    
    <div class='panel-body'>

        <div class='table-responsive'>
            <table class='table' >
                <thead>
                <tr>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                    <th>email</th>
                    <th>addresy</th>
                </tr>
                </thead>
                <tbody>
                <tr *ngFor='let user of users '>
                    <td>
                      {{user.firstName}}
                    </td>
                    
                    <td>
                    {{user.surname}}
                    </td>
                    
                    <td>
                    {{ user.email }}
                    </td>
                    
                    <td *ngFor="let address of user.addresses" >
                    <li>kraj:{{address.country}}</li>
                    <li>miasto:{{address.city}}</li>
                    <li>kod pocztowy:{{address.postalCode}}</li>
                    <li>adres:<b>{{address.address}}</b></li>
                    <li *ngIf="address.active">aktywny</li>
                    </td>


                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
`
})
export class AppComponent implements OnInit{
    users:IUser[];
    constructor(private _userService:userService){

    }

    ngOnInit():void {
        this._userService.getUsers()
            .subscribe(
                users=>this.users=users);
    }


}
