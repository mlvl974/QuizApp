import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
UserFormLabel: string = "Add User";

roles = ['Admin', 'Student'];


addForm: FormGroup = this.formBuilder.group({})
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService 
  ) {}

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      username:['',[Validators.required]],
      password:['',[Validators.required]],
      role:['',[Validators.required]],
      email:['',[Validators.required]],
    });
  }

onSubmit()
{
  this.userService.addUser(this.addForm?.value).subscribe
  ((data)=>
  {console.log("Data sent to web api and database"+ data);
  this.router.navigate(['user-list']);
  });
  
}



}
