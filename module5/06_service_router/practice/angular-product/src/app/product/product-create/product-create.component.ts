import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });
  categoryList: Category[] = [];
  constructor(private productService: ProductService,
              protected categoryService: CategoryService,
              private router: Router) { }
  ngOnInit(): void {
    this.categoryService.getAll().subscribe(value => {
      this.categoryList = value;
    });
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveCreateProduct(product).subscribe(() => {
      this.productForm.reset();
      alert('Tạo thành công');
      this.router.navigate(['/product/list']);
    }, e => {
      console.log(e);
    });
  }

}
