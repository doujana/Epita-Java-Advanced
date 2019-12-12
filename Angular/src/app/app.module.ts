import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionsComponent } from './questions/questions.component';
import {HttpClientModule} from '@angular/common/http'
import { MaterialModule } from './material/material.module';
import { OptionsComponent } from './options/options.component';
import { AnswersComponent } from './answers/answers.component';
import { StudentsComponent } from './students/students.component';
import { QuizComponent } from './quiz/quiz.component';
import { ProfessorsComponent } from './professors/professors.component';



@NgModule({
  declarations: [
    AppComponent,
    QuestionsComponent,
    OptionsComponent,
    AnswersComponent,
    StudentsComponent,
    QuizComponent,
    ProfessorsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
