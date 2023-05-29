import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  template: `
    <h1>Rock-Paper-Scissors</h1>
    <div class="game-container">
      <button (click)="playMove('rock')">Rock</button>
      <button (click)="playMove('paper')">Paper</button>
      <button (click)="playMove('scissors')">Scissors</button>
    </div>
    <div class="result-container">
      <p *ngIf="result">{{ result }}</p>
    </div>
  `,
  styles: [`
    .game-container {
      margin-top: 20px;
    }

    button {
      padding: 10px 20px;
      margin-right: 10px;
    }

    .result-container {
      margin-top: 20px;
    }
  `]
})
export class AppComponent {
  result!: string;

  constructor(private http: HttpClient) {}

  playMove(move: string) {
    this.http.post('http://192.168.1.67/play', move, { responseType: 'text' }).subscribe(response => {
      this.result = response;
    });
  }
}
