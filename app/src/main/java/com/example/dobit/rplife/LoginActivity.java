package com.example.dobit.rplife;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user;
    EditText pass;
    TextView signUp;
//    Button register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.ttf");
        user = (EditText) findViewById(R.id.etUsername);
        user.setTypeface(myCustomFont);
        pass = (EditText) findViewById(R.id.etPassword);
        pass.setTypeface(myCustomFont);
        signUp = (TextView) findViewById(R.id.tvSignUp);
        signUp.setTypeface(myCustomFont, Typeface.BOLD);
        login = (Button) findViewById(R.id.btnLogin);
        login.setTypeface(myCustomFont);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
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
