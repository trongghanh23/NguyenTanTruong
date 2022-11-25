import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl()
  });
  productId: number;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.productId= +paramMap.get('id');
      this.getProduct(this.productId);
    });
  }

  ngOnInit(): void {


  }
  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productForm.patchValue(product) ;
    });
  }
  delete(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.router.navigate(['/product/list']);
    }, e => {
      console.log(e);
    });
  }


}
