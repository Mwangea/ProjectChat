package com.example.projectchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectchat.R;
import com.example.projectchat.databinding.ActivitySignInBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Initialize the binding object
        binding = ActivitySignInBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setListeners();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

    }

}