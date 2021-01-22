import {Component, OnInit} from '@angular/core';
import {ICustomer} from "./customer";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customer-component',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  newCustomer : ICustomer = {name : "", email : ""};
  customers: ICustomer[]; // customers in database
  searchCustomerResult: ICustomer = {name : "", email : ""}; // Customer for findByName
  searchName: string = "" ;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/server/all').subscribe(data => {
      this.customers = data;
    })
  }

  findCustomerByName(name: string): void {
    this.http.get<any>("http://localhost:8080/server/findByName?name="+name).subscribe(data => {
      this.searchCustomerResult = data;
    })
  }

  addCustomer(customer: ICustomer){
    let url = "http://localhost:8080/server/add?name="+customer.name+"&email="+customer.email;

    this.http.get<any>(url).subscribe(data => {
      console.log("Added :")
     console.log(data)
    })
  }



}
