import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SessionStorageService } from '../../services/session-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {
  public LoginRequest = {
    username: undefined,
    password: undefined
  }

  constructor(
    private sessionStorageService: SessionStorageService,
    private router: Router) {}
  
  login(){
    fetch("http://localhost:8081/login",{
      method:'POST',
      body: JSON.stringify(this.LoginRequest),
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
        console.log("false"+data)
      }
    })
  }
}
