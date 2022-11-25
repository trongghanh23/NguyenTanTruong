import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: Product;

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl()
  });
  productId: number;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.productId = +paramMap.get('id');
      this.getProduct(this.productId);
    });
  }

  ngOnInit(): void {

   }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productForm.patchValue(product);
    });

  }

  updateProduct(): void {
    const productObj = this.productForm.value;
    productObj.id = this.product.id;
    this.productService.updateProduct(productObj).subscribe(value => {

    }, error => {

    }, () => {
      this.router.navigateByUrl('product/list')
    })
  }

}
