import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { PublicService } from '../service/public.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  user: User = new User;
  token:string= '';
  
constructor(private publicService : PublicService, private router:Router)
{}
  ngOnInit(): void {
  
  }

  addAccess(adding: string) {
    localStorage.setItem('access', adding);
  }



  login() {
    this.publicService.publicLogin(this.user)
      .subscribe(async data => {
        this.token = data.token

        sessionStorage.setItem('token', "ncs-" + data.token)
      
        if (await this.toValidate(data.token)) {
          
          console.log('token', "ncs-" + data.token)
          this.router.navigate(['list-user'])
        }
      })
  }


  toValidate(token: String) {
    return new Promise(resolve => {
      setTimeout(() => {
        this.publicService.publicValidate("ncs-" + token).subscribe(
          data => {
            resolve(Boolean(data));
            
          }
        )
      })
    })


  }


register()
{
  this.router.navigate(['register']);
}





}
