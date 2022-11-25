import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ProductService]
})
export class ProductListComponent implements OnInit {
  products: Product [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getAll().subscribe(value => {
        this.products = value;
      },
      error => {
        console.log(error);
      }, () => {
        console.log('Complete');
      }
    );

  }

}
