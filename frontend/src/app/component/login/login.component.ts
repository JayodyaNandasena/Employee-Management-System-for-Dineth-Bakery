import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SessionStorageService } from '../../services/session-storage.service';
import { Router } from '@angular/router';
import { LoginRequest } from '../../models/models';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent implements OnInit{

  public loginRequest:LoginRequest = {
    username: "",
    password: ""
  }

  constructor(
    private sessionStorageService: SessionStorageService,
    private router: Router,
    private toastr: ToastrService) {}

  ngOnInit(): void {
    this.sessionStorageService.clearSession();
  }
  
  login(){
    fetch("http://localhost:8081/login",{
      method:'POST',
      body: JSON.stringify(this.loginRequest),
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      if(data.status == true){
        this.sessionStorageService.setEmployeeId(data.employeeDetails.employee.employeeId);
        this.sessionStorageService.setEmployeeName(
          data.employeeDetails.employee.firstName + " " + data.employeeDetails.employee.lastName);
        this.sessionStorageService.setIsManager(data.employeeDetails.isManager);
        console.log(this.sessionStorageService.getEmployeeId());

        if (data.employeeDetails.isManager) {
          this.router.navigateByUrl('/dashboardManager');
        } else {
          this.router.navigate(['/dashboardNonManager']);
        }

      }else{
        this.toastr.error(data.message, 'Login Failed',{
          timeOut: 3000,
        });
      }
    })
  }
}
