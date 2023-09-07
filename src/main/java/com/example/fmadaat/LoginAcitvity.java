package com.example.fmadaat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button signInButton;
        EditText username, password;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);
        signInButton = (Button) findViewById(R.id.GoogleSignInBtn);
        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();
                if (TextUtils.isEmpty(user_name)) {
                    username.setError("Invalid User Name");
                } else if (TextUtils.isEmpty(pass_word)) {
                    password.setError("Enter password");
                } else {
                    if (user_name.equals("keet") & pass_word.equals("keetxyz")) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}