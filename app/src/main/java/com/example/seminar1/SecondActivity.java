
package com.example.seminar1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "DAM_LIFECYCLE";


    private final ActivityResultLauncher<Intent> thirdLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK
                                && result.getData() != null) {

                            Intent data = result.getData();

                            String mesaj = data.getStringExtra("mesajRetur");
                            int suma = data.getIntExtra("suma", 0);

                            Toast.makeText(
                                    this,
                                    mesaj + ": " + suma,
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "SecondActivity - onCreate");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        Button btnDeschide = findViewById(R.id.btnDeschide);

        btnDeschide.setOnClickListener(view -> {

            Bundle date = new Bundle();
            date.putString("mesaj", "Salut din activitatea 2");
            date.putInt("valoare1", 7);
            date.putInt("valoare2", 5);

            Intent intent = new Intent(
                    SecondActivity.this,
                    ThirdActivity.class
            );

            intent.putExtras(date);


            thirdLauncher.launch(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "SecondActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "SecondActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SecondActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SecondActivity - onStop");
    }
}
