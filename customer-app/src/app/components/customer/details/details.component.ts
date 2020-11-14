import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CustomerService } from 'src/app/services/customer.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  public customerForm: FormGroup;
  public cust: Customer;

  constructor(
    private authService: AuthenticationService, 
    private custService: CustomerService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(currentuser => {
      this.cust = this.custService.findById(currentuser.customerId);

      this.customerForm = this.formBuilder.group({
        initials: this.cust.initials,
        lastName: this.cust.lastName,
        street: this.cust.street,
        housenumber: this.cust.housenumber,
        residence: this.cust.residence,
        zipCode: this.cust.zipCode,
        ssn: this.cust.ssn,
        birthdate: new FormControl(this.cust.birthdate.toISOString().substring(0, 10)),
        phone: this.cust.phone,
        email: this.cust.email
      });
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.customerForm.controls; }

  onSubmit(): void {
    const customer: Customer = {
      id: this.cust.id,
      initials: this.f.initials.value,
      lastName: this.f.lastName.value,
      street: this.f.street.value,
      housenumber: this.f.housenumber.value,
      residence: this.f.residence.value,
      zipCode: this.f.zipCode.value,
      ssn: this.f.ssn.value,
      birthdate: new Date(this.f.birthdate.value),
      phone: this.f.phone.value,
      email: this.f.email.value,
    };
    console.log('save customer: ' + JSON.stringify(customer));
    this.custService.save(customer);
  }

}
