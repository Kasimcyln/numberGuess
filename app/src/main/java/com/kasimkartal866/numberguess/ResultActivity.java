package com.kasimkartal866.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private ImageView ivResult;
    private TextView tvResult;
    private Button btnTry;
    private Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ivResult = findViewById(R.id.ivResult);
        tvResult = findViewById(R.id.tvResult);
        btnTry = findViewById(R.id.btnTry);
        result = getIntent().getBooleanExtra("result",false);
        if(result){
            tvResult.setText("You Win");
            ivResult.setImageResource(R.drawable.gulen);
        }else{
            tvResult.setText("You Lost");
            ivResult.setImageResource(R.drawable.uzgun);
        }

        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,PredictionActivity.class));
                finish();

            }
        });

    }
}