package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button btn_login;
    private TextView tv_signUp;
    private EditText et_username ;
    private EditText et_password ;

    private boolean isValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //inflate
        et_username=findViewById(R.id.activity_et_username);
        et_password=findViewById(R.id.activity_et_password);
        btn_login=findViewById(R.id.activity_btn_LogIn);
        tv_signUp=findViewById(R.id.activity_tv_Signup);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getBaseContext(),"please Fill the Required Fields!",Toast.LENGTH_SHORT).show();
                }else{
                    isValid=validate(username,password);
                    if (isValid){
                        Intent homeIntent =new Intent(login.this,login.class);
                        homeIntent.putExtra("name",username);
                        startActivity(homeIntent);
                    }else{
                        Toast.makeText(getBaseContext(),"Invalid Data, Try Again!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent =new Intent(login.this,login.class);
                startActivity(signUpIntent);
            }

        });
    }

    public boolean validate(String username,String password){
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }else return false;
    }

}