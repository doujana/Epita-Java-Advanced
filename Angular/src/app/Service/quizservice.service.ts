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
export class QuizserviceService {

  constructor(private httpclient:HttpClient) { 



  }
  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  quizcreation(quizContent){
  
    console.log(quizContent);
    var value= this.httpclient.post(this.link+"/create",quizContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  quizfilter(filterValue) :Observable<any>{
    let filterquiz =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filterquiz);
    return filterquiz
  }
  ////////////////
  quizdelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  quizUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }
}
