import {Component, Input, OnInit} from '@angular/core';
import {RestApiService} from "../shared/rest-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-answers-create',
  templateUrl: './answers-create.component.html',
  styleUrls: ['./answers-create.component.css']
})
export class AnswersCreateComponent implements OnInit {

  @Input() answerDetails = {question_id:0, text:''}

  constructor(
    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() {
  }

  addAnswer(dataAnswer){
    this.restApi.createAnswer(this.answerDetails).subscribe((data:{})) => {
      this.router.navigate(['/answers-list'])
    }
  }

}
