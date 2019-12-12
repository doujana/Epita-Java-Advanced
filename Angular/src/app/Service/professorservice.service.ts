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
export class ProfessorserviceService {

  constructor(private httpclient:HttpClient) { }
  private link :string ="http://localhost:8080/quiz-rest-api/rest/questions"
  profcreation(profContent){
  
    console.log(profContent);
    var value= this.httpclient.post(this.link+"/create",profContent,httpOptions)
 
    return value
     
  }
  ///////////////////////////////////
  proffilter(filterValue) :Observable<any>{
    let filterprof =this.httpclient.get(this.link+"/search?qContent="+filterValue)
    console.log(filterprof);
    return filterprof
  }
  ////////////////
  profdelete(id : number){
    console.log("delete Service")
    return this.httpclient.post(this.link+"/delete",id,httpOptions)
  }
 ///////////////////////////////////
  profUpdate(id,update){
   return this.httpclient.put(this.link+"/update/"+id,update,httpOptions)
  }
}
