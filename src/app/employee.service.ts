import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  [x: string]: any;
  private baseURL="http://localhost:8080/api/auth/v1/employees"

  constructor(private httpClient:HttpClient,private authService: AuthService) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL);
  }
  
  createEmployee(employee:Employee): Observable<Object>{
    return this.httpClient.post((this.baseURL),employee);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }
  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }
  deleteEmployee(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  register(userData: any): Observable<any> {
    return this['http'].post(`${this.baseURL}/register`, userData);
  }

  login(credentials: any): Observable<any> {
    return this['http'].post(`${this.baseURL}/login`, credentials);
  }
  authenticate(username: string, password: string): Observable<any> {
    return this.authService.login({ username, password });
  }

  
}
