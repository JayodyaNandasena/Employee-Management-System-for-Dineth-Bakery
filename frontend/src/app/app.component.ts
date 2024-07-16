import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidebarAdminComponent } from './component/sidebar-admin/sidebar-admin.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardManagerComponent } from './component/dashboard-manager/dashboard-manager.component';
import { DashboardNonmanagerComponent } from './component/dashboard-nonmanager/dashboard-nonmanager.component';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [NgIf, RouterOutlet,SidebarAdminComponent,LoginComponent,
    DashboardManagerComponent,DashboardNonmanagerComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
