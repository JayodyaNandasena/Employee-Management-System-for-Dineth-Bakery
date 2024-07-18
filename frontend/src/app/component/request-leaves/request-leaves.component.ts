import { Component, OnInit } from '@angular/core';
import { SidebarNonmanagerComponent } from '../sidebar-nonmanager/sidebar-nonmanager.component';
import { SidebarAdminComponent } from '../sidebar-admin/sidebar-admin.component';
import { SessionStorageService } from '../../services/session-storage.service';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { Branch, EmployeeRead } from '../../models/models';

@Component({
  selector: 'app-request-leaves',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarNonmanagerComponent,SidebarAdminComponent],
  templateUrl: './request-leaves.component.html',
  styleUrl: './request-leaves.component.css'
})
export class RequestLeavesComponent implements OnInit{
  public isManager: boolean = false;

  constructor(
    private sessionService:SessionStorageService,
    private toastr: ToastrService){}

  ngOnInit(): void {
    this.isManager = this.sessionService.getIsManager();
  }
}
