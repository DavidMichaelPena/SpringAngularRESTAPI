import { Injectable } from '@angular/core';
// import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Soda } from '../soda';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable()
export class SodaService {
  private baseUrl = 'http://localhost:8000/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  // private options = new RequestOptions({headers: this.headers});
  private requestOptions = {
    params: new HttpParams()
  };
  private sodas: Soda[];
  private soda: Soda;

  constructor(private _http: HttpClient) { }

  getSodas(): Observable<Soda[]> {
    return this._http.get<Soda[]>(this.baseUrl + '/sodas');
    // .map((response: Response) => response.json())
    // .catch(this.errorHandler);
  }

  getSoda(id: Number): Observable<Soda> {
    return this._http.get<Soda>(this.baseUrl + '/sodas/' + id);
    // .map((response: Response) => response.json())
    // .catch(this.errorHandler);
  }

  addSoda(newSoda: Soda): Observable<Soda> {
    return this._http.post<Soda>(this.baseUrl + '/sodas', newSoda, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  updateSoda(updatedSoda: Soda): Observable<void> {
    return this._http.put<void>(this.baseUrl + `/sodas/${updatedSoda.id}`, updatedSoda, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  deleteSoda(id: Number): Observable<void> {
    return this._http.delete<void>(this.baseUrl + `/sodas/${id}`);
    // .map((response: Response) => response.json())
    // .catch(this.errorHandler);
  }

  errorHandler(error: Response) {
    return Observable.throw(error || 'SERVER ERROR');
  }

  setter(soda: Soda) {
    return this.soda = soda;
  }

  getter() {
    return this.soda;
  }

}
