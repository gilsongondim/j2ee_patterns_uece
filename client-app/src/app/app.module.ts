import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnswersCreateComponent } from './answers-create/answers-create.component';
import { AnswersDetailsComponent } from './answers-details/answers-details.component';
import { AnswersUpdateComponent } from './answers-update/answers-update.component';
import { AnswersListComponent } from './answers-list/answers-list.component';
import { QuestionsCreateComponent } from './questions-create/questions-create.component';
import { QuestionsDetailsComponent } from './questions-details/questions-details.component';
import { QuestionsUpdateComponent } from './questions-update/questions-update.component';
import { QuestionsListComponent } from './questions-list/questions-list.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    AnswersCreateComponent,
    AnswersDetailsComponent,
    AnswersUpdateComponent,
    AnswersListComponent,
    QuestionsCreateComponent,
    QuestionsDetailsComponent,
    QuestionsUpdateComponent,
    QuestionsListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
