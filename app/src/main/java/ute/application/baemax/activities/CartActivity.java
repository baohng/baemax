package ute.application.baemax.activities;

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

public class MainActivity extends AppCompatActivity {
    private EditText email, pass;
    private Button btnlogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
        btnlogin = findViewById(R.id.login_button_login1);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }



    public void onLoginClick(View View){
        startActivity(new Intent(this,Register.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
    public void onLoginClickADMIN(View View){
        startActivity(new Intent(this, LoginAdmin.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }



    private void login(){
        String edtEmail, edtPass;
        edtEmail = email.getText().toString();
        edtPass = pass.getText().toString();

        if (TextUtils.isEmpty(edtEmail)){
            Toast.makeText(this, "Vui lòng nhập email !!", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(edtPass)){
            Toast.makeText(this, "Vui lòng nhập password !!", Toast.LENGTH_SHORT).show();
        }
        mAuth.signInWithEmailAndPassword(edtEmail,edtPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Register.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}