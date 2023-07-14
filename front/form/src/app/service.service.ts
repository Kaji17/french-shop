import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LinkArtcile } from './LinkArticle';
import { Observable } from 'rxjs';
import { Product } from './Product';

@Injectable({
  providedIn: 'root',
})

export class ServiceService {
  host: string = "http://localhost:8081/french-shop/api/v1"
 
  constructor(private http: HttpClient) {}

  // Recuperer le nombre total de toute les transactions
  public getArticles(obj: LinkArtcile): Observable<Product> {
    return this.http.post<Product>(this.host+"/article", obj);
  }
}
