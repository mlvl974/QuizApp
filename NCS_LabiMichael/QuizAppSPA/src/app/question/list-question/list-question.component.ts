import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from 'src/app/model/question';
import { QuestionService } from 'src/app/service/question.service';


@Component({
  selector: 'app-list-question',
  templateUrl: './list-question.component.html',
  styleUrls: ['./list-question.component.css']
})
export class ListQuestionComponent implements OnInit {

questions: Question[] = [];


  categories = [
    {id:1,name:'General Knowledge'},
    {id:2,name:'Math'},
    {id:3,name:'Science'}
  ];
  levels=[
    {id:1,name:'1- Basic '},
    {id:2,name:'2- Intermediate'},
    {id:3,name:'3- Advance'}
  ];





  constructor(private questionService:QuestionService,private router:Router) { }

  ngOnInit(): void {

    this.getQuestions();

    
  }

  private getQuestions(){
    this.questionService.getAllQuestions().subscribe((questions: Question[]) => {
      this.questions = questions;
    });
  }




  addQuestion(): void{
    this.router.navigate
    (['/add-question'])
  }

  deleteQuestion(question?:Question): void
  {

  }

  updateQuestion(question?:Question):void
  {
this.router.navigate(['/add-question',question])
  }

}
