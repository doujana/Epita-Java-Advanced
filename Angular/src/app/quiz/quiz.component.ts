import { Component, OnInit } from '@angular/core';
import { QuizserviceService } from '../Service/quizservice.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  constructor(private quiz:QuizserviceService) { }
inserted
id
  ngOnInit() {


    this.quiz.quizcreation(this.quiz).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.quiz.quizUpdate(this.quiz,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.quiz.quizdelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.quiz.quizfilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

  
  }

}
