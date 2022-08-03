import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PublicService } from '../service/public.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  RegisterFormLabel: string = "Register";
  roles = ['Admin', 'Student'];

  addForm: FormGroup = this.formBuilder.group({})
    constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      private publicService: PublicService 
    ) {}
  
    ngOnInit(): void {
      this.addForm = this.formBuilder.group({
        username:['',Validators.required],
        password:['',Validators.required],
        role:['Admin',Validators.required],
        email:['',Validators.required],
      });
    }
  
  onSubmit()
  {
    this.publicService.publicRegister(this.addForm?.value).subscribe
    ((data)=>
    {console.log("Data sent to web api and database"+ data);
    alert("Registration success.");
    this.router.navigate(['/login']);
    });
    
  }
  
}  