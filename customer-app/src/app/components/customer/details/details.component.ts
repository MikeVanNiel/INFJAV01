import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { User } from 'src/app/models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  public cust: Customer;

  constructor(
    private authService: AuthenticationService, 
    private custService: CustomerService) { }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(currentuser => {
      this.cust = this.custService.findById(currentuser.customerId);
    });
  }

}
