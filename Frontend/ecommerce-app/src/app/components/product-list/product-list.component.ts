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
  previousCategoryId: number = 1;
  searchMode: boolean = false;

  // new prop for pagination
  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElement: number = 0;


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


    //
    // if we have a different category than the previous 
    // Note: Angular wil reuse a component if it is being viewed 
    //

    // if we have different category id than previous 
    // then set the PageNumber back to 1
    if(this.previousCategoryId != this.currentCategoryId){
      this.thePageNumber = 1;
    }


    this.previousCategoryId = this.currentCategoryId;
    console.log(`currentCategoryId=${this.currentCategoryId}`, `thePageNumber=${this.thePageNumber}`);



    // this.prodictService
    //   .getProductList(this.currentCategoryId)
    //   .subscribe(
    //     data => {
    //       this.products = data
    //       console.log(data);
    //     }
        
    //   )
    this.prodictService.getProductListPaginate(
      this.currentCategoryId,
      this.thePageSize,
      this.thePageNumber).subscribe(
        data => {
          this.products = data._embedded.products,
          this.thePageNumber = data.page.number,
          this.thePageSize = data.page.size,
          this.theTotalElement = data.page.totalElemnets
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
