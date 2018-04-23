import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Soda } from '../soda';


@Injectable()
export class SodaService {
  private baseUrl = 'http://localhost:8000/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
  private soda: Soda;

  constructor(private _http: Http) { }

  getSodas() {
    return this._http.get(this.baseUrl + '/sodas', this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  getSoda(id: Number) {
    return this._http.get(this.baseUrl + '/sodas/' + id, this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  deleteSoda(id: Number) {
    return this._http.delete(this.baseUrl + '/sodas/' + id, this.options)
    .map((response: Response) => response.json())
    .catch(this.errorHandler);
  }

  createSoda(soda: Soda) {
    return this._http.post(this.baseUrl + '/sodas', JSON.stringify(soda), this.options)
    .map((response: Response) => response.json());
  }

  updateSoda(soda: Soda) {
    return this._http.put(this.baseUrl + '/sodas', JSON.stringify(soda), this.options)
    .map((response: Response) => response.json());
  }

  errorHandler(error: Response) {
    return Observable.throw(error || 'SERVER ERROR');
  }

  setter(soda: Soda) {
    this.soda = soda;
  }

  getter() {
    return this.soda;
  }

}
