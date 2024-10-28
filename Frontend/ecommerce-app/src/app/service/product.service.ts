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
  
  
  
  getProduct(theProductId: number):Observable<Product> {

    return this.httpClient.get<GetResponseProduct>(`${this.baseUrl}/${theProductId}`).pipe(
           map(p => p._embedded))
  }






  getProductList(theCategoryId:number):Observable<Product[]>{

    return this.getProducts(`${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`);
  }






  listProductCategories():Observable<ProductCategory[]> {
    
    return this.httpClient.get<GetResponseCategory>(this.categoryUrl).pipe(
      map(res => res._embedded.categories)
    )
  }





  searchProducts(theKeyword:string):Observable<Product[]> {
    
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}` 
    
    return this.getProducts(searchUrl)
  }
  
  
  
  private getProducts(url:string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(url).pipe(
      map(res => res._embedded.products)
    );
  }
  



}


interface GetResponseProducts {
  _embedded: {
    products: Product[];
  }
}


interface GetResponseProduct {
  _embedded: Product;
}

interface GetResponseCategory {
  _embedded: {
    categories: ProductCategory[];
  }
}