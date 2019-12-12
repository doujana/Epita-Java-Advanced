import { Component, OnInit } from '@angular/core';
import { OptionServiceService } from '../Service/option-service.service';

@Component({
  selector: 'app-options',
  templateUrl: './options.component.html',
  styleUrls: ['./options.component.css']
})
export class OptionsComponent implements OnInit {

  constructor(private option:OptionServiceService) { }

  inserted
  id
  ngOnInit() {


  

    this.option.optioncreation(this.option).subscribe(data =>{ this.inserted=data, console.log(data) } ),
    
    this.option.optionUpdate(this.option,this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.option.optiondelete(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })
    this.option.optionfilter(this.id ).subscribe(data =>{ this.inserted=data, console.log(data) })

  }

}
