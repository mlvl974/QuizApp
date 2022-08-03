import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListUserComponent } from './user/list-user/list-user.component';
import { LoginComponent } from './login/login.component';
import { ListQuestionComponent } from './question/list-question/list-question.component';
import { RegisterComponent } from './register/register.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { AddQuestionComponent } from './question/add-question/add-question.component';
import { AdminResultComponent } from './result/admin-result/admin-result.component';
import { HomeComponent } from './home/home.component';
import { QuizComponent } from './quiz/quiz.component';
import { AddResultComponent } from './result/add-result/add-result.component';


const routes: Routes = [
  { path: 'quiz', component: QuizComponent },
  {path:'list-user',component:ListUserComponent},
  {path:'add-user',component:AddUserComponent},
  {path: 'list-question', component:ListQuestionComponent},
  {path: 'add-question', component:AddQuestionComponent},
  { path: 'login' ,component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'admin-result', component: AdminResultComponent},
  { path: 'add-result', component: AddResultComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
