import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../model/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  baseUrl: string =
  // 'http://localhost:8082/abc-university/admin/question';
  'http://localhost:8083/abc-university/question';

  constructor(private httpClient:HttpClient) { }

  getAllQuestions():
  Observable<Question[]>
  {
    console.log("Question Service - Get question called");
    return this.httpClient.get<Question[]>(this.baseUrl +'/allQuestions');
  }

  getQuiz(category:string, marks:number):
  Observable<Question[]>
  {

 
    console.log("Question Service - Get question called");
    return this.httpClient.get<Question[]>(this.baseUrl +'/getQuiz?/category='+category+"&marks="+marks);
  }

  getQuestionByCategory(category:string):
  Observable<Question[]>
  {
    console.log("Question Service - Get Question Called");
    return this.httpClient.get<Question[]>(this.baseUrl+'/question/getByCategory/'+category);
  }

  getQuestionByMarks(marks:number):
  Observable<Question[]>
  {
    console.log("Question Service - Get Question Called");
    return this.httpClient.get<Question[]>(this.baseUrl+'/question/getByMarks/'+marks);
  }

  addQuestion(question:Question):Observable<any>
  {
    return this.httpClient.post(this.baseUrl + '/add', question);
  }

  updateQuestion(question:Question):Observable<any>
  {
    return this.httpClient.put(this.baseUrl + '/update', question);
  }


  deleteQuestio(questionId:number):
Observable<any>
  {
return this.httpClient.delete(this.baseUrl+ '/question/'+ questionId);
  }


}//end of service

