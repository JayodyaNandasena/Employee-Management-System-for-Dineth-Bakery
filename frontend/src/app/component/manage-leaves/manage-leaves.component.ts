import { Component, OnInit } from '@angular/core';
import { SidebarAdminComponent } from '../sidebar-admin/sidebar-admin.component';
import { SessionStorageService } from '../../services/session-storage.service';
import { ToastrService } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-manage-leaves',
  standalone: true,
  imports: [FormsModule, CommonModule, SidebarAdminComponent],
  templateUrl: './manage-leaves.component.html',
  styleUrl: './manage-leaves.component.css'
})
export class ManageLeavesComponent implements OnInit{
  public pendingList = null;
  public approvedList = null;
  public rejectedList = null;

  constructor(
    private sessionService: SessionStorageService,
    private toastr: ToastrService){}

  ngOnInit(): void {
    this.loadPendingRequests();
    this.loadApprovedRequests();
    this.loadRejectedRequests();
  }

  loadPendingRequests(){
    fetch("http://localhost:8081/timeOff/byStatus?status=PENDING&requestorId="+this.sessionService.getEmployeeId())
      .then(res => res.json())
      .then(data => {
        this.pendingList = data;
      });
  }

  loadApprovedRequests(){
    fetch("http://localhost:8081/timeOff/byStatus?status=APPROVED&requestorId="+this.sessionService.getEmployeeId())
      .then(res => res.json())
      .then(data => {
        this.approvedList = data;
      });
  }

  loadRejectedRequests(){
    fetch("http://localhost:8081/timeOff/byStatus?status=REJECTED&requestorId="+this.sessionService.getEmployeeId())
      .then(res => res.json())
      .then(data => {
        this.rejectedList = data;
      });
  }

  aproveRequest(requestId : string){
    const request = {
      "managerId": this.sessionService.getEmployeeId(),
      "requestId": requestId,
      "status": "APPROVED",
      "approvedDateTime": "2024-07-19T07:50:29.778Z"
    };

    fetch("http://localhost:8081/timeOff", {
      method: 'PUT',
      body: JSON.stringify(request),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        if (data) {
          if(data.status === true){
            this.toastr.success(data.message, 'Success', {
              timeOut: 3000,
            });
            this.loadApprovedRequests();
            this.loadRejectedRequests();
            this.loadPendingRequests();
          }
        } else {
          this.toastr.error(data.message, 'Failed', {
            timeOut: 3000,
          });
        }
      })
      .catch(error => {
        this.toastr.warning('System error', 'Error');
      });


  }

  rejectRequest(requestId : string){
    console.log(requestId);
    

    const request = {
      "managerId": this.sessionService.getEmployeeId(),
      "requestId": requestId,
      "status": "REJECTED",
      "approvedDateTime": "2024-07-19T07:50:29.778Z"
    };

    fetch("http://localhost:8081/timeOff", {
      method: 'PUT',
      body: JSON.stringify(request),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        if (data) {
          if(data.status === true){
            this.toastr.success(data.message, 'Success', {
              timeOut: 3000,
            });
            this.loadApprovedRequests();
            this.loadRejectedRequests();
            this.loadPendingRequests();
          }
        } else {
          this.toastr.error(data.message, 'Failed', {
            timeOut: 3000,
          });
        }
      })
      .catch(error => {
        this.toastr.warning('System error', 'Error');
      });


  }

}
