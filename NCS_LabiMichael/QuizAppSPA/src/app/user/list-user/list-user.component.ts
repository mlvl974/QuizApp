import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  users: User[] = [];
 userId!:number;
  constructor(private activatedRouter:ActivatedRoute,private userService:UserService,
    private router:Router) { }

  ngOnInit(): void {
this.getUsers();
this.userId = this.activatedRouter.snapshot.params['userId'];
console.log("update user :-" + this.userId);
  }


  private getUsers()
  {
    this.userService.getAllUser().subscribe((users: User[]) => {
      this.users = users;
    });
  }


addUser(): void {
  this.router.navigate(['add-user']);
}




updateUser(user?: User): void 
{
 
}

deleteUser(user?: User): void 
{

}

}
