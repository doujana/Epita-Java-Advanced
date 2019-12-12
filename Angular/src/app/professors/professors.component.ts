import { Component, OnInit } from '@angular/core';
import { ProfessorserviceService } from '../Service/professorservice.service';

@Component({
  selector: 'app-professors',
  templateUrl: './professors.component.html',
  styleUrls: ['./professors.component.css']
})
export class ProfessorsComponent implements OnInit {

  constructor(private professor:ProfessorserviceService) { }
inserted
id
  ngOnInit() {

    this.professor.profcreation(this.professor).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.professor.profUpdate(this.professor,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.professor.profdelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.professor.proffilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

    
  }

}
