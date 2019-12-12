import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';



const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};





@Injectable({
  providedIn: 'root'
})
export class QuestionserviceService {

  constructor(private httpclient: HttpClient) { 


  }
  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  questioncreation(qContent){
  
    console.log(qContent);
    var value= this.httpclient.post(this.link+"/create",qContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  questionfilter(filterValue) :Observable<any>{
    let filterQuestion =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filterQuestion);
    return filterQuestion
  }
  ////////////////
  questiondelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  questionUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }
  



}
