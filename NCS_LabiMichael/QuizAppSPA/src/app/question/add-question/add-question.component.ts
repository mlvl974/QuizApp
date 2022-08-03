import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionService } from 'src/app/service/question.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  QuestionFormLabel: string = "Add Question";

  addForm: FormGroup = this.formBuilder.group({})
    constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      private questionService: QuestionService 
    ) {}
  
    ngOnInit(): void {
      this.addForm = this.formBuilder.group({
        questionId:['',[Validators.required]],
        category:['',[Validators.required]],
        marks:['',[Validators.required]],
        option1:['',[Validators.required]],
        option2:['',[Validators.required]],
        option3:['',[Validators.required]],
        option4:['',[Validators.required]],
        answer:['',[Validators.required]],
      });
    }
  
  onSubmit()
  {
    this.questionService.addQuestion(this.addForm?.value).subscribe
    ((data)=>
    {console.log("Data sent to web api and database"+ data);
    this.router.navigate(['question-list']);
    });
    
  }
  
  
  
  }
