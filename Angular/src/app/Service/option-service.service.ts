import { Injectable } from '@angular/core';
import {HttpHeaders,HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs'



const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class OptionServiceService {

  constructor(private httpclient:HttpClient) { }

  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  optioncreation(pContent){
  
    console.log(pContent);
    var value= this.httpclient.post(this.link+"/create",pContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  optionfilter(filterValue) :Observable<any>{
    let filteroption =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filteroption);
    return filteroption
  }
  ////////////////
  optiondelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  optionUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }
  


}
