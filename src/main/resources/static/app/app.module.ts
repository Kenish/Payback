import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import {userService} from "./userService";
import {HttpModule} from "@angular/http";



@NgModule({
  imports: [ BrowserModule,HttpModule ],
  declarations: [ AppComponent ],
  providers:[userService],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
