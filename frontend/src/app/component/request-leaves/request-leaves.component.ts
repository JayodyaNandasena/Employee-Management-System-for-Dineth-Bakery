import { Component, OnInit } from '@angular/core';
import { SidebarNonmanagerComponent } from '../sidebar-nonmanager/sidebar-nonmanager.component';
import { SidebarAdminComponent } from '../sidebar-admin/sidebar-admin.component';
import { SessionStorageService } from '../../services/session-storage.service';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { Branch, EmployeeRead, LeaveRequest } from '../../models/models';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request-leaves',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarNonmanagerComponent,SidebarAdminComponent],
  templateUrl: './request-leaves.component.html',
  styleUrl: './request-leaves.component.css'
})
export class RequestLeavesComponent implements OnInit{
  public isManager: boolean = false;

  public startDate = "";
  public startTime = "";
  public endDate = "";
  public endTime = "";

  public request:LeaveRequest = {
    employeeId : "",
    text : "",
    requestDateTime : new Date().toISOString(),
    startDateTime : "",
    endDateTime : ""
  }

  constructor(
    private sessionService:SessionStorageService,
    private router: Router,
    private toastr: ToastrService){}

  ngOnInit(): void {
    if (this.sessionService.getEmployeeId() === "") {
      this.router.navigateByUrl('');
    }

    this.isManager = this.sessionService.getIsManager();

    if(this.sessionService.getEmployeeId() != null){
      this.request.employeeId = this.sessionService.getEmployeeId();
    }
    
  }

  submitRequest(){
    this.request.startDateTime = this.getStartDateTime();
    this.request.endDateTime = this.getEndDateTime();

    fetch("http://localhost:8081/timeOff",{
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
      employeeId : "",
      text : "",
      requestDateTime : new Date().toISOString(),
      startDateTime : "",
      endDateTime : ""
    }
  }

  getEndDateTime(): string {
    if (this.endDate && this.endTime) {
      const dateTime = new Date(`${this.endDate}T${this.endTime}`);
      return dateTime.toISOString(); // Returns ISO 8601 format
    }
    return "";
  }

  getStartDateTime(): string {
    if (this.startDate && this.startTime) {
      const dateTime = new Date(`${this.startDate}T${this.startTime}`);
      return dateTime.toISOString(); // Returns ISO 8601 format
    }
    return "";
  }
}
