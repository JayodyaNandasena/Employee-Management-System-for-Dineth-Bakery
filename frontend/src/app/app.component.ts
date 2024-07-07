import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidebarAdminComponent } from './component/sidebar-admin/sidebar-admin.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,SidebarAdminComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
