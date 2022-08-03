import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ResultService } from 'src/app/service/result.service';

@Component({
  selector: 'app-add-result',
  templateUrl: './add-result.component.html',
  styleUrls: ['./add-result.component.css']
})
export class AddResultComponent implements OnInit {
ResultFormLabel: string = "Result";


addForm: FormGroup = this.formBuilder.group({})
  constructor(private formBuilder: FormBuilder,
    private router: Router, private resultService: ResultService) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      testId:['',Validators.required],
      userId:['',Validators.required],
      date:['',Validators.required],
      category:['',Validators.required],
      level:['',Validators.required],
      totalScore:['',Validators.required],
      marks:['',Validators.required]
    });
  }

  onSubmit()
{
  this.resultService.submitQuiz(this.addForm?.value).subscribe
  ((data)=>
  {console.log("Data sent to web api and database"+ data);
  alert("Quiz Submitted");
  this.router.navigate(['/admin-result']);
  });
  
}
}
