import { Component, OnInit } from '@angular/core';
import {HttpHeaders,HttpClient} from '@angular/common/http'
import {observable} from 'rxjs'
import { StudentserviceService } from '../Service/studentservice.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  constructor(private student:StudentserviceService) { }
id
inserted
  ngOnInit() {

    
    this.student.stdcreation(this.student).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.student.stdUpdate(this.student,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.student.stddelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.student.stdfilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

  }

}
