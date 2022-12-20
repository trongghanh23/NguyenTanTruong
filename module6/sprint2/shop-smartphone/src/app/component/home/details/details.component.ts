import {Component, OnInit} from '@angular/core';
import {SmartphoneDTo} from '../../../dto/smartphone-dto';
import {SmartphoneService} from '../../../service/smartphone.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  id: number;
  smartphone: SmartphoneDTo;

  constructor(private smartphoneService: SmartphoneService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router) {
  }

  ngOnInit(): void {
    this.title.setTitle('chi tiết điện thoại');
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.smartphoneService.findById(id).subscribe(value => {
      this.smartphone = value;
      console.log(value);
    });
  }

}
