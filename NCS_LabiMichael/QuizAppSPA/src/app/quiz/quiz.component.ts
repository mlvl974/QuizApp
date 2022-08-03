import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { QuestionService } from '../service/question.service';
import { ResultService } from '../service/result.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  question : Question = new Question;
  questions: Question[] = [];
  
  category:string='Math';
  marks:number=1;
 
  constructor(private questionService:QuestionService,private router:Router, private resultService:ResultService) { }

  ngOnInit(): void {

    this.getQuiz(this.category,this.marks);
  }

  private getQuiz(category:string, marks:number){
    this.questionService.getQuiz(category, marks).subscribe((questions: Question[]) => {
      this.questions = questions;
    });
  }

  onSubmit(userId:number)
  {
    this.resultService.submitQuiz(userId).subscribe
    ((data)=>
    {console.log("Data sent to web api and database"+ data);
    alert("Quiz Submitted");
    this.router.navigate(['/admin-result']);
    });
    
  }
}
