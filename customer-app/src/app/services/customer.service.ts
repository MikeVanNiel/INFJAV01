import { Injectable } from '@angular/core';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customers: Customer[] = [
    { id: 1, initials: 'M.', lastName: 'van Niel', street: 'Riviermos', housenumber: 1, residence: 'Rotterdam', zipCode: '1234 AB', ssn: '123456789',  birthdate: new Date('1980-01-01'), phone: '06-40667172', email: '0152110@hr.nl' },
    { id: 2, initials: 'T.A.J.', lastName: 'van Someren', street: 'Lindelaan', housenumber: 2, residence: 'Bleiswijk', zipCode: '1233 AC', ssn: '123456788',  birthdate: new Date('1981-01-01'), phone: '06-40667171', email: '0999999@hr.nl' },
    { id: 3, initials: 'R.R.', lastName: 'Martin', street: 'Lusthof', housenumber: 3, residence: 'Spijkenisse', zipCode: '1232 AD', ssn: '123456787',  birthdate: new Date('1982-01-01'), phone: '06-40667170', email: '0999998@hr.nl' },
    { id: 4, initials: 'N.', lastName: 'Laan', street: 'De Elzen', housenumber: 4, residence: 'Delft', zipCode: '1231 AE', ssn: '123456786',  birthdate: new Date('1983-01-01'), phone: '06-40667169', email: '0999997@hr.nl' },
    { id: 5, initials: 'L.', lastName: 'Stijns', street: 'Dorpsstraat', housenumber: 5, residence: 'Schiedam', zipCode: '1230 AF', ssn: '123456785',  birthdate: new Date('1984-01-01'), phone: '06-40667168', email: '0999996@hr.nl' }
  ];

  constructor() { }

  getAll(): Customer[] {
    return this.customers;
  }

  findById(id: number): Customer {
    let targetCustomer = this.customers.filter(x => x.id === id)[0];

    if (!targetCustomer) {
      targetCustomer = new Customer();
    }

    return targetCustomer;
  }

  save(customer: Customer): void {
    if (customer) {
      for (let i = 0; i < this.customers.length; i++) {
        if (this.customers[i].id === customer.id) {
          this.customers[i] = customer;
          break;
        }
      }
    }
    
  }
}
