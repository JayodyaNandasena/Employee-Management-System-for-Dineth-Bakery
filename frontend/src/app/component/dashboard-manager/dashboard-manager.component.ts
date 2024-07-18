import { Component } from '@angular/core';
import { SidebarAdminComponent } from '../sidebar-admin/sidebar-admin.component';

@Component({
  selector: 'app-dashboard-manager',
  standalone: true,
  imports: [SidebarAdminComponent],
  templateUrl: './dashboard-manager.component.html',
  styleUrl: './dashboard-manager.component.css'
})
export class DashboardManagerComponent {

}
