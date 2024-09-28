package com.example.exercice2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText Name, Address, Surface, Pieces;
    CheckBox Piscine;
    Button btnCalculate;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialiser les vues
        Name = findViewById(R.id.editTextName);
        Address = findViewById(R.id.editTextAddress);
        Surface = findViewById(R.id.editTextSurface);
        Pieces = findViewById(R.id.editTextPieces);
        Piscine = findViewById(R.id.checkBoxPiscine);
        btnCalculate = findViewById(R.id.buttonCalculate);
        Result = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs des champs
                String surface = Surface.getText().toString();
                String pieces = Pieces.getText().toString();

//                // Vérifier que les champs ne sont pas vides
//                if (surface.isEmpty() || pieces.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                // Convertir les valeurs numériques
                int Intsurface = Integer.parseInt(surface);
                int Intpieces = Integer.parseInt(pieces);

                // Calculer les impôts
                int impotBase = Intsurface * 2;
                int impotSupplementaire = Intpieces * 50;

                if (Piscine.isChecked()) {
                    impotSupplementaire += 100;
                }

                int impotTotal = impotBase + impotSupplementaire;

                // Afficher le résultat
                String result = "Impot de base: " + impotBase + "\n" +
                        "Impot supplémentaire: " + impotSupplementaire + "\n" +
                        "Impot Total: " + impotTotal;

                Result.setText(result);
            }

        });

    }
}