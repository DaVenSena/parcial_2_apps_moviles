package com.mobile.apps.segundoparcial;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import Classes.Character;

public class DetailsActivity extends AppCompatActivity {

    Character character;
    ImageView imgChar;
    TextView txtName, txtSpecies, txtSex, txtEarth, txtLoc, txtAlive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        character = (Character) getIntent().getSerializableExtra("character");

        txtName = findViewById(R.id.txtNombreDet);
        txtEarth = findViewById(R.id.txtEarthDet);
        txtLoc = findViewById(R.id.txtLocDet);
        txtSex = findViewById(R.id.txtSexDet);
        txtAlive = findViewById(R.id.txtAliveDet);
        txtSpecies = findViewById(R.id.txtSpeciesDet);

        imgChar = findViewById(R.id.imgCharDetail);

        Picasso.get().load(Uri.parse(character.getImageUrl())).into(imgChar);

        txtSpecies.setText(character.getSpecies());
        txtLoc.setText(character.getLocation());
        if (!character.isAlive()) txtAlive.setText("Muerto");
        txtSex.setText(character.getSex());
        txtEarth.setText(character.getEarth());
        txtName.setText(character.getName());
    }
}