package com.example.wendi.utspraktikummobileprograming;

/**
 * Created by arif1 on 10/26/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;

    private final String NAMA = "Wendi Agustian";
    private final String NIM = "1137050219";

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";


    Button btnLogin;


    Ses session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                if(username.trim().length() > 0 && password.trim().length() > 0){
                    if(username.equals(USERNAME) && password.equals(PASSWORD)){
                        session.createLoginSession(NAMA, NIM);
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(), "Login Gagal..\n"
                                + "Usernama/Password anda salah", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login Gagal..\n" +
                            "Silahlkan masukan usernama dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

}
