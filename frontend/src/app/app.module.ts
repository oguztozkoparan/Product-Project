import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ProductService } from './service/product.service';
import { DialogModule } from 'primeng/dialog';
import { FormsModule } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { InputTextModule } from 'primeng/inputtext';
import { ToastModule } from 'primeng/toast';

@NgModule({
  declarations: [AppComponent, ProductComponent],
  imports: [
    BrowserModule,
    TableModule,
    AppRoutingModule,
    ButtonModule,
    InputTextModule,
    BrowserAnimationsModule,
    ConfirmDialogModule,
    HttpClientModule,
    DialogModule,
    FormsModule,
    MessageModule,
    MessagesModule,
    ToastModule,
  ],
  providers: [ConfirmationService, ProductService, HttpClient, MessageService],
  bootstrap: [ProductComponent],
})
export class AppModule {}
