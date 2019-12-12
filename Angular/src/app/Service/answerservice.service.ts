import { Injectable } from '@angular/core';
import {HttpHeaders,HttpClient}  from '@angular/common/http'
import {Observable} from 'rxjs'


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class AnswerserviceService {

  constructor(private httpclient:HttpClient) { }

  
  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  answercreation(ansContent){
  
    console.log(ansContent);
    var value= this.httpclient.post(this.link+"/create",ansContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  answerfilter(filterValue) :Observable<any>{
    let filteranswer =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filteranswer);
    return filteranswer
  }
  ////////////////
  answerdelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  answerUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }
}
