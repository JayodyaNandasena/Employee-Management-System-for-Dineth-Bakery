import { Component, OnInit } from '@angular/core';
import { SidebarNonmanagerComponent } from '../sidebar-nonmanager/sidebar-nonmanager.component';
import { FormsModule } from '@angular/forms';
import { SessionStorageService } from '../../services/session-storage.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request-ot',
  standalone: true,
  imports: [FormsModule, SidebarNonmanagerComponent],
  templateUrl: './request-ot.component.html',
  styleUrl: './request-ot.component.css'
})
export class RequestOtComponent implements OnInit{
  public request = {
      "employeeId": this.sessionService.getEmployeeId(),
      "date" : "",
      "requestDate": new Date().toISOString(),
      "startTime": "",
      "endTime": "",
      "text": "",
      "status": "PENDING"
  }

  constructor(
    private sessionService:SessionStorageService,
    private router: Router,
    private toastr: ToastrService){}

  ngOnInit(): void {
    if (this.sessionService.getEmployeeId() === "") {
      this.router.navigateByUrl('');
    }
  }

  persistRequest(){
    
    fetch("http://localhost:8081/overtime",{
      method:'POST',
      body: JSON.stringify(this.request),
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      if(data.status === true){
        this.toastr.success('Request Sent Successfully', 'Success',{
          timeOut: 3000,
        });

      }else{
        this.toastr.error(data.message, 'Error',{
          timeOut: 3000,
        });
      }
    })
  }

  discardRequest(){
    this.request = {
      "employeeId": this.sessionService.getEmployeeId(),
      "date" : "",
      "requestDate": new Date().toISOString(),
      "startTime": "",
      "endTime": "",
      "text": "",
      "status": "PENDING"
    }
  }
}
