package com.example.userlogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Login_btn;
    EditText email, pass;
    TextView forgot;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Login_btn = findViewById(R.id.button2);
        email = findViewById(R.id.EmailId);
        pass = findViewById(R.id.Password);
        forgot = findViewById(R.id.ForgotPasswordText);

        Login_btn.setOnClickListener(this);
        forgot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2){
            if(!(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) && email.getText().toString().equals(pass.getText().toString()))
                Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Log In Unsuccessful", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.ForgotPasswordText)
            Toast.makeText(this, "Email == password, Try kr bro", Toast.LENGTH_SHORT).show();
    }
}