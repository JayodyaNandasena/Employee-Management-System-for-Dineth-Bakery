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
  imports: [CommonModule, FormsModule, SidebarNonmanagerComponent,SidebarAdminComponent],
  templateUrl: './manage-employee.component.html',
  styleUrl: './manage-employee.component.css'
})
export class ManageEmployeeComponent implements OnInit{
  public isManager: boolean = false;

  public employee:EmployeeRead = {
    employeeId : "",
    firstName : "",
    lastName : "",
    nic : "",
    dob : new Date(),
    profilePicture : "",
    hiredDate : new Date(),
    address : "",
    email : "",
    gender : "",
    branchName : "",
    jobRoleTitle : "",
    account: {
      username: "",
      password: "",
      isManager: this.sessionService.getIsManager()
    }
  };

  public newBranch:Branch = {
    name:"",
    latitude:0.0,
    longitude:0.0,
    address:""
  }

  constructor(
    private sessionService:SessionStorageService,
    private toastr: ToastrService){}

  ngOnInit(): void {
    this.isManager = this.sessionService.getIsManager();
    this.loadBranchNames();
    this.loadJobTitles();
  }

  loadProfile(){
    fetch("http://localhost:8081/employee/by-id?id="+this.sessionService.getEmployeeId(),{
      method:'GET',
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      if(data){
        this.employee.employeeId=data.employeeId;
        this.employee.firstName=data.firstName;
        this.employee.lastName=data.lastName;
        this.employee.nic=data.nic;
        this.employee.dob=data.dob;
        this.employee.hiredDate=data.hiredDate;
        this.employee.address=data.address;
        this.employee.email=data.email;
        this.employee.gender=data.gender;
        this.employee.branchName=data.branchName;
        this.employee.jobRoleTitle=data.jobRoleTitle;
        this.employee.account.username=data.account.username;
      }else{
        this.toastr.error(data.message, 'Data Loading Failed',{
          timeOut: 3000,
        });
      }
    })
  }

  updateProfile(){
    console.log(this.employee);

    fetch("http://localhost:8081/employee",{
      method:'PUT',
      body: JSON.stringify(this.employee),
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      if(data){
        this.loadProfile();
        this.toastr.info('Profile Updated Successfully', 'Success',{
          timeOut: 3000,
        });

      }else{
        this.toastr.error(data.message, 'Data Loading Failed',{
          timeOut: 3000,
        });
      }
    })
  }

  addEmployee(){
    const newEmployee = {
      employeeId : "example",
      firstName : this.employee.firstName,
      lastName : this.employee.lastName,
      nic : this.employee.nic,
      dob : this.formatDate(this.employee.dob),
      profilePicture : "",
      hiredDate : this.formatDate(this.employee.hiredDate),
      address : this.employee.address,
      email : this.employee.email,
      gender : this.employee.gender,
      branchName : this.employee.branchName,
      jobRoleTitle : this.employee.jobRoleTitle,
      account: {
        username: this.employee.account.username,
        password: this.employee.account.password,
        isManager: this.employee.account.isManager
      }
    };

    fetch("http://localhost:8081/employee",{
      method:'POST',
      body: JSON.stringify(newEmployee),
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      if(data){
        this.toastr.success('Employee Added Successfully', 'Success',{
          timeOut: 3000,
        });

      }else{
        this.toastr.error(data.message, 'Data Loading Failed',{
          timeOut: 3000,
        });
      }
    })
    .catch(error => {
      this.toastr.error('System error','Error');
    });
  }


  addNewBranch(){
    fetch("http://localhost:8081/branch",{
      method:'POST',
      body: JSON.stringify(this.newBranch),
      headers : {"Content-type": "application/json"}
    })
    .then(res => res.json())
    .then(data=> {
      this.toastr.success('Success', 'Branch Added Successfully!',{
        timeOut: 3000,
      });
    })
    .catch(error => {
      this.toastr.error('System error','Error');
    });
  }

  openBranchModal(){
    var branchModal = document.getElementById('staticBackdrop');

    if (branchModal != null) {
      branchModal.style.display='block';
    }

  }

  public branchList = null;

  loadBranchNames(){
    fetch("http://localhost:8081/branch/all-names")
    .then(res => res.json())
    .then(data => {
      this.branchList = data;
      console.log(this.branchList);      
    });
  }

  public jobTitlesList = null;

  loadJobTitles(){
    fetch("http://localhost:8081/jobrole/titles")
    .then(res => res.json())
    .then(data => {
      this.jobTitlesList = data;    
    });
  }

  formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
}
