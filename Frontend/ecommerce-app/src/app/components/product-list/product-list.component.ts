import { Product } from 'src/app/common/product';
import { ProductService } from './../../service/product.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 1;
  searchMode: boolean = false;

  constructor(private prodictService: ProductService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProduct();
    })

    // this.listProduct();

  }

  listProduct() {
    this.searchMode = (this.route.snapshot.paramMap.has('keyword'))

    if(this.searchMode){
      this.handleSearchProducts();
    }else{
      this.handleListProducts()
    }

  }




  handleListProducts() {
     const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
    }
    else {
      this.currentCategoryId = 1;
    }

    // this.currentCategoryId = 1;


    this.prodictService
      .getProductList(this.currentCategoryId)
      .subscribe(
        data => {
          this.products = data
          console.log(data);
        }
        
      )
  }



  
  handleSearchProducts() {
    const theKeyword = (this.route.snapshot.paramMap.get('keyword'))!

    this.prodictService.searchProducts(theKeyword).subscribe(
      data => {
        this.products  = data;
      }
    )
  }

  

}
