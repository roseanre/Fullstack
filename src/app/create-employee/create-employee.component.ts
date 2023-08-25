import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();

  constructor(private employeeService :EmployeeService,private router:Router){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.goToEmployeeeList();
    },
    error=> console.log(error));
  }
  goToEmployeeeList(){
    this.router.navigate(["/employees"]);

  }


  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();

  }

}
