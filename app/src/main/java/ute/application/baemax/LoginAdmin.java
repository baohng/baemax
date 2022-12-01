package ute.application.baemax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {
    EditText editTextEmail_1, editTextPassword_1;
    Button cirLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login_admin);
        Anhxa();

//        đăng nhập với quyền admin:vv
        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passUname = getIntent().getStringExtra("username");
                String passPword = getIntent().getStringExtra("password");
                if(editTextEmail_1.getText().toString().equals("") || editTextPassword_1.getText().toString().equals("")) {
                    Toast.makeText(LoginAdmin.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((editTextEmail_1.getText().toString().equals("admin") && editTextPassword_1.getText().toString().equals("admin"))
                        || (editTextEmail_1.getText().toString().equals(passUname) && editTextPassword_1.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(LoginAdmin.this, home_admin.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginAdmin.this, "Tài khoản hoặc mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void Anhxa() {
        editTextEmail_1 = (EditText) findViewById(R.id.editTextEmail_1);
        editTextPassword_1 = (EditText) findViewById(R.id.editTextPassword_1);
        cirLoginButton = (Button) findViewById(R.id.cirLoginButton);
    }

    public void onLoginClickUser(View View){
        startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}