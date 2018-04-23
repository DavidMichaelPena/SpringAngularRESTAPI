import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Brand } from '../brand';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class BrandService {
  private baseUrl = 'http://localhost:8000/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  constructor(private _http: Http) { }

  getBrands() {
    return this._http.get(this.baseUrl + '/brands/', this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  getBrand(id: Number) {
    return this._http.get(this.baseUrl + '/brands/' + id, this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  deleteBrand(id: Number) {
    return this._http.delete(this.baseUrl + '/brands/' + id, this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  createBrand(brand: Brand) {
    return this._http.post(this.baseUrl + '/brand', JSON.stringify(brand), this.options)
    .map((response: Response) => response.json());
  }

  updateBrand(brand: Brand) {
    return this._http.put(this.baseUrl + '/brand', JSON.stringify(brand), this.options)
    .map((response: Response) => response.json());
  }

  errorHandler(error: Response) {

    return Observable.throw(error || 'SERVER ERROR');

  }

}
