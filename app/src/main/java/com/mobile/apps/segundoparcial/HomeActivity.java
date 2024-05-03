package com.mobile.apps.segundoparcial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapters.CharacterAdapter;
import Classes.Character;

public class HomeActivity extends AppCompatActivity {

    public static final String dataUser = "dataUser";
    private static final int privateMode = Context.MODE_PRIVATE;
    RecyclerView rcvCharacters;
    Button btnLogOut;
    List<Character> characters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvCharacters = findViewById(R.id.rcvCharacters);
        btnLogOut = findViewById(R.id.btnLogOut);

        for (int i = 0; i < 4; i++) {
            String name = "";
            String imageUrl = "";
            String earth = "";
            String species = "";
            String sex = "";
            String location = "";
            boolean alive = true;
            switch (i) {
                case 0:
                    name = "Rick";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/72.jpeg";
                    earth = "Tierra";
                    species = "Humano";
                    sex = "Masculino";
                    location = "USA";
                    break;
                case 1:
                    name = "Summer";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/120.jpeg";
                    earth = "Tierra";
                    species = "Humano";
                    sex = "Femenino";
                    location = "USA";
                    break;
                case 2:
                    name = "Keara";
                    earth = "Desconocido";
                    species = "Krootabulan";
                    sex = "Femenino";
                    location = "Krootabulon";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/190.jpeg";
                    break;
                case 3:
                    earth = "Tierra";
                    species = "Humano";
                    sex = "Masculino";
                    location = "USA";
                    name = "Jerry";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/241.jpeg";
                    alive = false;
                    break;
            }
            characters.add(new Character(name, alive, species, earth, sex, location, imageUrl));
        }

        rcvCharacters.setLayoutManager(new LinearLayoutManager(this));
        rcvCharacters.setAdapter(new CharacterAdapter(characters));

        btnLogOut.setOnClickListener(view -> {

            SharedPreferences settings = getApplicationContext().getSharedPreferences(dataUser, privateMode);
            settings.edit().clear().commit();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        });
    }
}