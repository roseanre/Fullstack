import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent {
  registrationForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService
  ) {
    this.registrationForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    const userData = this.registrationForm.value;
    this.authService.register(userData).subscribe(
      (response: any) => {
        console.log(response);
        // Handle success
      },
      (error: any) => {
        console.error(error);
        // Handle error
      }
    );
  }
}
