import { Component, OnInit } from '@angular/core';
import { Soda } from '../../soda';
import { SodaService } from '../../shared-service/soda.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-soda',
  templateUrl: './soda.component.html',
  styleUrls: ['./soda.component.css']
})
export class SodaComponent implements OnInit {
  soda: {id: Number, name: string, calories: Number, stock: Number};

  constructor(private route: ActivatedRoute, private _sodaService: SodaService) { }

  ngOnInit() {
    this.soda = {
      id: this.route.snapshot.params['id'],
      name: this.route.snapshot.params['name'],
      calories: this.route.snapshot.params['calories'],
      stock: this.route.snapshot.params['stock']

    };
    this._sodaService.getSoda(this.soda.id)
    .subscribe((soda) => {
        console.log(soda);
        this.soda = soda;
      }, (error) => {
        console.log(error);
      }
    );
  }

}
