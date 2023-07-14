import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { DataViewModule, DataViewLayoutOptions } from 'primeng/dataview';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    HttpClientModule,
    DataViewModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
