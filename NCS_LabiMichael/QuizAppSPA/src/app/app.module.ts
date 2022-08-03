import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';




import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AddUserComponent } from './user/add-user/add-user.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { ListQuestionComponent } from './question/list-question/list-question.component';
import { AddQuestionComponent } from './question/add-question/add-question.component';
import { RegisterComponent } from './register/register.component';

import { AdminHeaderComponent } from './header/admin-header/admin-header.component';
import { StudentHeaderComponent } from './header/student-header/student-header.component';
import { AdminResultComponent } from './result/admin-result/admin-result.component';

import { HomeComponent } from './home/home.component';
import { QuizComponent } from './quiz/quiz.component';
import { AddResultComponent } from './result/add-result/add-result.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminHeaderComponent,
    StudentHeaderComponent,

    ListUserComponent,
    LoginComponent,
    AddUserComponent,
    ListQuestionComponent,
    AddQuestionComponent,
    RegisterComponent,

    AdminResultComponent,

    HomeComponent,
    QuizComponent,
    AddResultComponent,




  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
