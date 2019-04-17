import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuestionsCreateComponent} from "./questions-create/questions-create.component";
import {QuestionsDetailsComponent} from "./questions-details/questions-details.component";
import {QuestionsUpdateComponent} from "./questions-update/questions-update.component";
import {QuestionsListComponent} from "./questions-list/questions-list.component";

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'create-question'},
  {path:'create-question', component: QuestionsCreateComponent},
  {path:'questions-details/:id', component: QuestionsDetailsComponent},
  {path:'update-question',component: QuestionsUpdateComponent},
  {path:'question-list', component: QuestionsListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
