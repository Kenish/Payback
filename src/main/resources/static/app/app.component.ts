import {Component, OnInit} from '@angular/core';
import {IUser} from "./user";
import {userService} from "./userService";


@Component({
    selector: 'my-app',
    template: `
<div class='panel panel-primary'>
    <div class='panel-heading'>
        users
    </div>
    
    <div class='panel-body'>

        <div class='table-responsive'>
            <table class='table' >
                <thead>
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>address</th>
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
                    
                    <td >
                    
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
