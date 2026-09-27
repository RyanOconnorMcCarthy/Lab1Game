package com.example.lab1game;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


   Button enterbtn;
   EditText input;
   TextView title;
   TextView guesses;

   int count = 0;

    Random random = new Random();
    int randomNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        enterbtn = findViewById(R.id.button);
        input = findViewById(R.id.editTextText2);
        title = findViewById(R.id.textView);
        guesses = findViewById(R.id.textView2);

        randomNumber = random.nextInt(29) + 1;







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Guess(View view) {

        int number = Integer.parseInt(input.getText().toString());

        if (number == randomNumber){
            Toast.makeText(this, "You guessed correct", Toast.LENGTH_SHORT).show();

        }

        else if (number > randomNumber) {
            Toast.makeText(this, "Your number is too high1", Toast.LENGTH_SHORT).show();
            count = count + 1;
            guesses.setText("Total Guesses: "+ count);
        }
        else if (number < randomNumber) {
            Toast.makeText(this, "Your number is too low!", Toast.LENGTH_SHORT).show();
            count = count + 1;
            guesses.setText("Total Guesses: "+ count);
        }



    }

    public void reset(View view) {
    }
}