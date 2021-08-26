package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnRegister , btnLogin;
    EditText etUserName , etPassword;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        etUserName = findViewById(R.id.loginUsername);
        etPassword = findViewById(R.id.loginPassword);
        btnRegister = findViewById(R.id.btnToRegister);
        databaseHelper = new DatabaseHelper(Login.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName , password;
                UserName = etUserName.getText().toString();
                password = etPassword.getText().toString();
                boolean found = databaseHelper.CheckUserInformation(UserName , password);
                if (found == true)
                {
                    Toast.makeText(Login.this , "Correct" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this , Dashboard.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Login.this , "Invalid User Name or Password " , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}