package com.mobile.apps.segundoparcial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String dataUser = "dataUser";
    private static final int privateMode = Context.MODE_PRIVATE;
    String savedUser;
    EditText edtUsername, edtPassword;
    Button btnLogIn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(dataUser, privateMode);

        editor = sharedPreferences.edit();

        savedUser = getApplicationContext().getSharedPreferences(dataUser, privateMode).getString("userName", "");

        if (!savedUser.isEmpty()) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(view -> login());
    }

    public void login() {
        if (edtPassword.getText().equals("") || edtUsername.getText().equals("")) {
            Toast.makeText(this, "Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        editor.putString("userName", edtUsername.getText().toString());
        editor.commit();

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}