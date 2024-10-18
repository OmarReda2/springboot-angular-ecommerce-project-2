import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl = "http://localhost:8082/api/products";

  private categoryUrl = "http://localhost:8082/api/findAllCategory";




  getProductList(theCategoryId:number):Observable<Product[]>{

    let products = this.httpClient
                       .get<GetResponseProduct>(`${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`)
                       .pipe(map(res => res._embedded.products)) 

    return products;
  }






  listProductCategories():Observable<ProductCategory[]> {
    
    return this.httpClient.get<GetResponseCategory>(this.categoryUrl).pipe(
      map(res => res._embedded.categories)
    )
  }




}


interface GetResponseProduct {
  _embedded: {
    products: Product[];
  }
  
}

interface GetResponseCategory {
  _embedded: {
    categories: ProductCategory[];
  }
}