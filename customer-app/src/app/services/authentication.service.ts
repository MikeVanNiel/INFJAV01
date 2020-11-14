import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  private users = [
    { username: 'mike', password: 'mike', firstName: 'Mike', lastName: 'van Niel' },
    { username: 'dion', password: 'dion', firstName: 'Dion', lastName: 'Rats' },
    { username: 'geoffrey', password: 'geoffrey', firstName: 'Geoffrey', lastName: 'Arkenbout' }
  ];

  constructor() { 
    this.init(); 
  }

  init(): void {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string): Observable<User> {
    console.log('login: ' + username)
    let targetUser: User = 
      this.users.filter(user => user.username === username && user.password === password)[0];
    console.log('found user: ' + JSON.stringify(targetUser));
    if (targetUser) {
      console.log('user found');
      localStorage.setItem('currentUser', JSON.stringify(targetUser));
      this.currentUserSubject.next(targetUser);
      return of(targetUser);
    } else {
      console.log('no user to return?');
    }
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
