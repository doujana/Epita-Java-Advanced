import { Component, OnInit } from '@angular/core';
import { QuestionserviceService } from '../services/questionservice.service';


export interface PeriodicElement {
  questionname: string;
  questionId: number;
  questionAnswer: string;
  questionOption: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {questionId: 1, questionname: 'what is static?', questionAnswer: '', questionOption: 'H'},
  {questionId: 2, questionname: 'what is hibernate?', questionAnswer: '', questionOption: 'He'},
  {questionId: 3, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'Li'},
  {questionId: 4, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'Be'},
  {questionId: 5, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'B'},
  {questionId: 6, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'C'},
  {questionId: 7, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'N'},
  {questionId: 8, questionname: 'what is j2e?', questionAnswer:'', questionOption: 'O'},
  {questionId: 9, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'F'},
  {questionId: 10, questionname: 'what is j2e?', questionAnswer: '', questionOption: 'Ne'},
];

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {


  constructor(private question:QuestionserviceService) {
    
   }
   displayedColumns: string[] = ['questionId', 'questionname', 'questionAnswer', 'questionOption','option'];
 
   dataSource 
   inserted
   id

  ngOnInit() {
    this.dataSource=ELEMENT_DATA

    this.question.questioncreation(this.question).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.question.questionUpdate(this.question,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.question.questiondelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.question.questionfilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

  
  }

}
