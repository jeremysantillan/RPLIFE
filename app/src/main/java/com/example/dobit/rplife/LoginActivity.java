package com.example.dobit.rplife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user;
    EditText pass;
    Button register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.etUsername);
        pass = (EditText) findViewById(R.id.etPassword);
        register = (Button) findViewById(R.id.btnRegister);
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                break;
            case R.id.btnLogin:
                signIn();
                break;
        }
    }

    protected void signIn(){
        String username;
        String password;

        username = user.getText().toString();
        password = pass.getText().toString();



//        if(username.equals("dnaniel213@gmail.com") && password.equals("daniel")) {
            Intent intent = new Intent(LoginActivity.this, InitializationActivity.class);
            startActivity(intent);
//        }
//        else {
//            pass.setText("");
//            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
//        }
    }

}
