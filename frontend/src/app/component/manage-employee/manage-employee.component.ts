import { Component, OnInit } from '@angular/core';
import { SidebarNonmanagerComponent } from '../sidebar-nonmanager/sidebar-nonmanager.component';
import { SidebarAdminComponent } from '../sidebar-admin/sidebar-admin.component';
import { SessionStorageService } from '../../services/session-storage.service';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { Branch, EmployeeCreate, EmployeeRead } from '../../models/models';

@Component({
  selector: 'app-manage-employee',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarNonmanagerComponent, SidebarAdminComponent],
  templateUrl: './manage-employee.component.html',
  styleUrl: './manage-employee.component.css'
})
export class ManageEmployeeComponent implements OnInit {
  public isManager: boolean = false;
  public jobTitlesList = null;
  public branchList = null;

  public employee: EmployeeRead = {
    employeeId: "",
    firstName: "",
    lastName: "",
    nic: "",
    dob: new Date(),
    profilePicture: "",
    hiredDate: new Date(),
    address: "",
    email: "",
    gender: "",
    branchName: "",
    jobRoleTitle: "",
    account: {
      username: "",
      password: "",
      isManager: true
    }
  };

  public newBranch: Branch = {
    name: "",
    latitude: 0.0,
    longitude: 0.0,
    address: ""
  }

  constructor(
    private sessionService: SessionStorageService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.isManager = this.sessionService.getIsManager();
    this.loadBranchNames();
    this.loadJobTitles();
  }

  searchEmployee() {
    fetch("http://localhost:8081/employee/by-id?id=" + this.employee.employeeId, {
      method: 'GET',
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        if (data) {
          this.employee.employeeId = data.employeeId;
          this.employee.firstName = data.firstName;
          this.employee.lastName = data.lastName;
          this.employee.nic = data.nic;
          this.employee.dob = data.dob;
          this.employee.hiredDate = data.hiredDate;
          this.employee.address = data.address;
          this.employee.email = data.email;
          this.employee.gender = data.gender;
          this.employee.branchName = data.branchName;
          this.employee.jobRoleTitle = data.jobRoleTitle;
          this.employee.account.username = data.account.username;
        } else {
          this.toastr.error(data.message, 'Data Loading Failed', {
            timeOut: 3000,
          });
        }
      })
  }

  updateEmployee() {
    console.log(this.employee);

    fetch("http://localhost:8081/employee", {
      method: 'PUT',
      body: JSON.stringify(this.employee),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        if (data) {
          this.toastr.info('Profile Updated Successfully', 'Success', {
            timeOut: 3000,
          });

        } else {
          this.toastr.error(data.message, 'Data Loading Failed', {
            timeOut: 3000,
          });
        }
      })
  }

  addEmployee() {
    fetch("http://localhost:8081/employee", {
      method: 'POST',
      body: JSON.stringify(this.employee),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        if (data) {
          this.toastr.success('Employee Added Successfully', 'Success', {
            timeOut: 3000,
          });

        } else {
          this.toastr.error(data.message, 'Data Loading Failed', {
            timeOut: 3000,
          });
        }
      })
      .catch(error => {
        this.toastr.error('System error', 'Error');
      });
  }

  clear() {
    this.employee = {
      employeeId: "",
      firstName: "",
      lastName: "",
      nic: "",
      dob: new Date(),
      profilePicture: "",
      hiredDate: new Date(),
      address: "",
      email: "",
      gender: "",
      branchName: "",
      jobRoleTitle: "",
      account: {
        username: "",
        password: "",
        isManager: false
      }
    }
  }

  addNewBranch() {
    fetch("http://localhost:8081/branch", {
      method: 'POST',
      body: JSON.stringify(this.newBranch),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        this.toastr.success('Success', 'Branch Added Successfully!', {
          timeOut: 3000,
        });
      })
      .catch(error => {
        this.toastr.error('System error', 'Error');
      });
  }

  openBranchModal() {
    var branchModal = document.getElementById('staticBackdrop');

    if (branchModal != null) {
      branchModal.style.display = 'block';
    }
  }

  loadBranchNames() {
    fetch("http://localhost:8081/branch/all-names")
      .then(res => res.json())
      .then(data => {
        this.branchList = data;
      });
  }

  loadJobTitles() {
    fetch("http://localhost:8081/jobrole/titles")
      .then(res => res.json())
      .then(data => {
        this.jobTitlesList = data;
      });
  }
}
