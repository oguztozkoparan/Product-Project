import { Component, OnInit } from '@angular/core';
import { ConfirmationService, Message, MessageService } from 'primeng/api';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss'],
})
export class ProductComponent implements OnInit {
  products: Product[];
  product: Product;
  productDialogVisible: boolean;
  submitted: boolean;

  constructor(
    private confirmationService: ConfirmationService,
    private productService: ProductService,
    private messageService: MessageService
  ) {
    this.products = [];
    this.product = {};
    this.productDialogVisible = false;
    this.submitted = false;
  }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService
      .getProducts()
      .subscribe((data) => (this.products = data));
  }

  openProductForm(): void {
    this.product = {};
    this.productDialogVisible = true;
    this.submitted = false;
  }

  hideProductForm(): void {
    this.productDialogVisible = false;
    this.submitted = false;
  }

  saveProduct(product: Product): void {
    this.submitted = true;
    this.product = product;
    if (this.product.id && this.product.id > 0) {
      this.productService.updateProduct(this.product).subscribe(() => {
        this.getProducts();
        this.hideProductForm();
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Product Updated',
          life: 2000,
        });
      });
    } else {
      this.productService.createProduct(this.product).subscribe(() => {
        this.getProducts();
        this.hideProductForm();
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Product Created',
          life: 2000,
        });
      });
    }
  }

  openUpdateProduct(product: Product): void {
    this.product = { ...product };
    // this.productService
    //  .getProductById(product.id)
    //  .subscribe((data) => (this.product = data));
    this.productDialogVisible = true;
  }

  deleteProduct(id: number): void {
    this.confirmationService.confirm({
      message: 'Are you sure that you want to delete this product?',
      header: 'Delete Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.productService.deleteProduct(id).subscribe(() => {
          this.getProducts();
          this.messageService.add({
            severity: 'success',
            summary: 'Successful',
            detail: 'Product Deleted',
            life: 2000,
          });
        });
      },
    });
  }
}
