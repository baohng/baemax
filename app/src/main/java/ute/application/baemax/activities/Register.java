package ute.application.baemax.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ute.application.baemax.R;

public class Register extends AppCompatActivity {

    private EditText name, phonenumber, email, pass;
    private Button btnlogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth=FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextName);
        phonenumber = findViewById(R.id.editTextPhonenumber);
        email = findViewById(R.id.editTextEmailRegister);
        pass = findViewById(R.id.editTextPasswordRegister);
        btnlogin = findViewById(R.id.cirRegisterButton);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }


    public void onLoginClickRegister(View View){
        startActivity(new Intent(this,Register.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }

    private void register(){
        String edtEmail, edtPass;
        edtEmail = email.getText().toString();
        edtPass = pass.getText().toString();

        if (TextUtils.isEmpty(edtEmail)){
            Toast.makeText(this, "Vui lòng nhập email !!", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(edtPass)){
            Toast.makeText(this, "Vui lòng nhập password !!", Toast.LENGTH_SHORT).show();
        }
        mAuth.createUserWithEmailAndPassword(edtEmail,edtPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}