import {Component, OnInit} from '@angular/core';
import {ICustomer} from "./customer";
import { HttpClient } from '@angular/common/http';
import {environment} from "../../environments/environment";

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
  url: string = environment.backendUrl

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.getAllCustomer()
  }

  getAllCustomer(): void{
    this.http.get<any>(this.url+'server/all').subscribe(data => {
      this.customers = data;
    })
  }

  findCustomerByName(name: string): void {
    this.http.get<any>(this.url+"server/findByName?name="+name).subscribe(data => {
      this.searchCustomerResult = data;
    })
  }

  addCustomer(customer: ICustomer){
    let addUrl = this.url+"server/add?name="+customer.name+"&email="+customer.email;

    this.http.get<any>(addUrl).subscribe(data => {
      console.log("Added :")
      console.log(data)
      this.newCustomer = {name : "", email : ""};
      this.getAllCustomer()
    })

  }



}
