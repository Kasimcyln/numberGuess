package com.kasimkartal866.numberguess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PredictionActivity extends AppCompatActivity {
    private TextView tvTrial,tvHelp;
    private EditText etNumber;
    private Button btnPrediction;

    private int number;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        tvHelp = findViewById(R.id.tvHelp);
        tvTrial = findViewById(R.id.tvTrial);
        etNumber = findViewById(R.id.etNumber);
        btnPrediction = findViewById(R.id.btnPrediction);
        Random r = new Random();

        number = r.nextInt(11);
        Log.e("Rasgele sayı ",String.valueOf(number));


        btnPrediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userGuess = etNumber.getText().toString();
                if (userGuess.trim().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PredictionActivity.this)
                            .setTitle("error")
                            .setMessage("Please enter a number")
                            .setPositiveButton("OK", (dialog, which) -> {
                                dialog.dismiss();
                            });
                    builder.create().show();
                } else {
                    int tahmin = -1;
                    try {
                        tahmin = Integer.parseInt(userGuess);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    performAction(tahmin);
                }
            }
        });
    }

    private void performAction(int tahmin) {
        if (tahmin == -1) return;
        counter = counter - 1;
        if(number == tahmin){
            Intent intent = new Intent(PredictionActivity.this,ResultActivity.class);
            intent.putExtra("result",true);
            startActivity(intent);
            finish();
        } else if(tahmin > counter){
            tvHelp.setText("azalt ⬇");
            tvTrial.setText("remaining right : "+counter);
        } else if(tahmin < counter){
            tvHelp.setText("arttır ⬆");
            tvTrial.setText("remaining right : "+counter);

        }if(counter == 0){
            Intent intent = new Intent(PredictionActivity.this,ResultActivity.class);
            intent.putExtra("result",false);
            startActivity(intent);
            finish();
        }
        etNumber.setText("");
    }
}