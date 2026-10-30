package com.example.seminar1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );

        Bundle date = getIntent().getExtras();

        if (date == null) {
            Toast.makeText(this, "Nu au fost primite date", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        String mesaj = date.getString("mesaj", "");
        int valoare1 = date.getInt("valoare1", 0);
        int valoare2 = date.getInt("valoare2", 0);
        suma = valoare1 + valoare2;

        Toast.makeText(
                this,
                mesaj + "; valori: " + valoare1 + " și " + valoare2,
                Toast.LENGTH_LONG
        ).show();

        Button btnTrimite = findViewById(R.id.btnTrimiteInapoi);
        btnTrimite.setOnClickListener(view -> {
            Intent rezultat = new Intent();
            rezultat.putExtra("mesajRetur", "Suma calculată");
            rezultat.putExtra("suma", suma);

            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}