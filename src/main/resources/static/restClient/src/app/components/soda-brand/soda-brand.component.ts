import { Component, OnInit } from '@angular/core';
import { Brand } from '../../brand';
import { BrandService } from '../../shared-service/brand.service';

@Component({
  selector: 'app-soda-brand',
  templateUrl: './soda-brand.component.html',
  styleUrls: ['./soda-brand.component.css']
})
export class SodaBrandComponent implements OnInit {
  public brands: Brand[];

  constructor(private _brandService: BrandService) { }

  ngOnInit() {
    this._brandService.getBrands().subscribe((brands) => {
      console.log(brands);
      this.brands = brands;
    }, (error) => {
      console.log(error);
      }
    );
  }
}
