import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http'
import {observable, Observable} from 'rxjs'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class StudentserviceService {

  constructor(private httpclient:HttpClient) { 

  }

  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  stdcreation(stdContent){
  
    console.log(stdContent);
    var value= this.httpclient.post(this.link+"/create",stdContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  stdfilter(filterValue) :Observable<any>{
    let filterquiz =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filterquiz);
    return filterquiz
  }
  ////////////////
  stddelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  stdUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }

}
