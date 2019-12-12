import { Component, OnInit } from '@angular/core';
import { AnswerserviceService } from '../Service/answerservice.service';

@Component({
  selector: 'app-answers',
  templateUrl: './answers.component.html',
  styleUrls: ['./answers.component.css']
})
export class AnswersComponent implements OnInit {

  constructor(private answer:AnswerserviceService) { }
  dataSource 
   inserted
   id

  ngOnInit() {
   

    this.answer.answercreation(this.answer).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.answer.answerUpdate(this.answer,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.answer.answerdelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.answer.answerfilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

  }

}
