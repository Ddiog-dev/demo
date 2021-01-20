import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: '<div> <h1>{{pageTitle}}</h1><div>My first component</div></div>',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  pageTitle: string = 'front';
  constructor() {}
}
