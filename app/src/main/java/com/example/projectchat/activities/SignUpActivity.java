package com.example.projectchat.activities;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectchat.R;
import com.example.projectchat.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Initialize the binding object
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setListeners();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setListeners() {
        binding.textSignIn.setOnClickListener(v -> onBackPressed());
        binding.buttonSignUp.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                signUp();
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void signUp() {

    }

    private Boolean isValidSignUpDetails(){
         if(encodedImage == null) {
             showToast("Select profile image");
             return false;
         } else if (binding.inputName.getText().toString().trim().isEmpty()) {
             showToast("Enter name");
             return  false;
         } else if (binding.inputEmail.getText().toString().trim().isEmpty()) {
             showToast("Enter email");
             return false;
         } else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
             showToast("Enter valid Image");
             return  false;

         } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
             showToast("Enter password");
             return false;
         } else if(binding.confirmPassword.getText().toString().trim().isEmpty()) {
             showToast("confirm password");
             return  false;
         } else if (!binding.inputPassword.getText().toString().equals(binding.confirmPassword.getText().toString())) {
             showToast("Password & email must be the same");
             return false;
         } else {
             return  true;
         }
    }

    private void loading (Boolean isLoading){
        if(isLoading) {
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignUp.setVisibility(View.VISIBLE);
        }
    }
}