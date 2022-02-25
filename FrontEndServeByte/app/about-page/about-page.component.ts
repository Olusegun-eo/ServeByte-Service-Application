import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent implements OnInit {

  public about: Array<string> = [
    "We are a restaurant committed to providing quality service and excellent food to our customers. As a premium eatery and bar, ServByte is a must-visit for anyone in the Major cities area. We love to see new faces at our restaurant, so feel free to stop by and just hang out.",
    "ServByte provides a premium dining experience equipped with modern lounge seating and a unique sense of artistry. We proudly support the community and local businesses. Click here to view our current promotions:",
  ]

  constructor() { }

  ngOnInit() {
  }

}
