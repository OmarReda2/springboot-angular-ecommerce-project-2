import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl = "http://localhost:8082/api/products";

  getProductList(theCategoryId:number):Observable<Product[]>{

    let products = this.httpClient
                       .get<GetResponse>(`${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`)
                       .pipe(map(res => res._embedded.products)) 

    return products;
  }
}


interface GetResponse {
  _embedded: {
    products: Product[];
  }
}
