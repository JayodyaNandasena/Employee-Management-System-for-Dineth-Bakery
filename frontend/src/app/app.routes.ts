import { Routes } from '@angular/router';
import { DashboardManagerComponent } from './component/dashboard-manager/dashboard-manager.component';
import { DashboardNonmanagerComponent } from './component/dashboard-nonmanager/dashboard-nonmanager.component';
import { LoginComponent } from './component/login/login.component';

export const routes: Routes = [
    {
        path:"dashboardManager",
        component: DashboardManagerComponent
    },
    {
        path:"dashboardNonManager",
        component: DashboardNonmanagerComponent
    },
    {
        path:"",
        component: LoginComponent
    }
];