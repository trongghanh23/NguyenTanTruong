import {Component, Inject, VERSION} from '@angular/core';
import {render} from 'creditcardpayments/creditcardpayments';
import Swal from 'sweetalert2';
import {DOCUMENT} from '@angular/common';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(@Inject(DOCUMENT) private document: Document) {

  }
name = 'Angular ' + VERSION.major;

  title = 'shop-smartphone';
  scrollToTop(): void {
    // scroll to the top of the body
    return this.document.body.scrollIntoView({
      behavior: 'smooth',
      block: 'start',
      inline: 'start'
    });
  }
}
