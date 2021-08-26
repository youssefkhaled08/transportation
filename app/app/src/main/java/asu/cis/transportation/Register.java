package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText etEmail , etUserName , etPassword;
    Button btnRegister;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = findViewById(R.id.registerEmail);
        etUserName = findViewById(R.id.registerUsername);
        etPassword = findViewById(R.id.registerPassword);
        btnRegister = findViewById(R.id.btnRegister);
        databaseHelper = new DatabaseHelper(Register.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                int EMAIL_TAKEN = 1 , USER_NAME_TAKEN = 2 , SAFE = 0;
                int CheckTaken = databaseHelper.CheckUserEmailorUserNameAlreadyTaken(email , userName);
                boolean isValidEmail = isValidEmail(email);
                if (isValidEmail == false)
                {
                    Toast.makeText(Register.this , "inValid email address" , Toast.LENGTH_SHORT).show();
                }
                else if (userName.equals(""))
                {
                    Toast.makeText(Register.this , "Please Enter a user name" , Toast.LENGTH_SHORT).show();
                }
                else if(password.length() < 8)
                {
                    Toast.makeText(Register.this , "Your Password length have to be more than or Equal 8" , Toast.LENGTH_SHORT).show();
                }
                else if (CheckTaken == 1)
                {
                    Toast.makeText(Register.this , "This Email address is Already taken" , Toast.LENGTH_SHORT).show();
                }
                else if (CheckTaken == 2)
                {
                    Toast.makeText(Register.this , "This User name is already taken" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    UserModel newUserModel = new UserModel(userName , email ,-1 , password);
                    boolean AddedSuccsessfuly = databaseHelper.AddOneUserModel(newUserModel);
                    Toast.makeText(Register.this , "Added Succsessfully  : " +AddedSuccsessfuly , Toast.LENGTH_SHORT).show();
                    if (AddedSuccsessfuly == true)
                    {
                        Intent intent = new Intent(Register.this , Login.class);
                        startActivity(intent);
                    }

                }


            }
        });
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}