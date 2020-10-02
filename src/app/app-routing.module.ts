import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './error/error.component'; 
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { ListTodosComponent } from './list-todos/list-todos.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { TodoComponent } from './todo/todo.component';

const routes: Routes = [{path:'', component:LoginComponent},
{path:'welcome/:name', component:WelcomeComponent,canActivate:[RouteGuardService]},
{path:'login', component:LoginComponent},
{path:'todo', component:ListTodosComponent, canActivate:[RouteGuardService]},
{path:'logout', component:LogoutComponent, canActivate:[RouteGuardService]},
{path:'todos/:id', component:TodoComponent},
{path:'**', component:ErrorComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
