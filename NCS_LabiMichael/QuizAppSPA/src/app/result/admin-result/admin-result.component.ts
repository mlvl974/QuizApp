import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ResultResponseDTO } from 'src/app/model/resultDTO';
import { ResultService } from 'src/app/service/result.service';

@Component({
  selector: 'app-admin-result',
  templateUrl: './admin-result.component.html',
  styleUrls: ['./admin-result.component.css']
})
export class AdminResultComponent implements OnInit {

  result: ResultResponseDTO[] = [];

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

  constructor(private resultService:ResultService,private router:Router) { }

  ngOnInit(): void {

    this.getResults();

   
  }

  private getResults()
  {
  this.resultService.getAllResults().subscribe((result: ResultResponseDTO[]) => {
    this.result = result;
  });
}

  addResult(): void{
    this.router.navigate
    (['add-result'])
  }

  deleteResult(result?:ResultResponseDTO): void
  {

  }

  updateResult(result?:ResultResponseDTO):void
  {
this.router.navigate(['/add-result',result])
  }
}