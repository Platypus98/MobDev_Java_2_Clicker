package com.example.mobile_task_1_2_clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button increaseBtn;
    Button decreaseBtn;
    Button resetBtn;
    ImageButton imgBtn;


    private String correct_word;
    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainText);
        increaseBtn = (Button) findViewById(R.id.button);
        decreaseBtn = (Button) findViewById(R.id.button2);
        resetBtn = (Button) findViewById(R.id.button3);
        imgBtn = (ImageButton) findViewById(R.id.imageButton);


        View.OnClickListener clickListenerIncrease = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score ++;
                correct_word = getCorrectWord(score);
                String s = "Кнопка нажата " + score + " " + correct_word;
                mainText.setText(s);
            }
        };

        View.OnClickListener clickListenerDecrease = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score --;
                correct_word = getCorrectWord(score);
                String s = "Кнопка нажата " + score + " " + correct_word;
                mainText.setText(s);
            }
        };

        View.OnClickListener clickListenerReset = new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                score = 0;
                String s = "Кнопка нажата 0 раз";
                mainText.setText(s);
            }
        };



        increaseBtn.setOnClickListener(clickListenerIncrease);
        decreaseBtn.setOnClickListener(clickListenerDecrease);
        resetBtn.setOnClickListener(clickListenerReset);
        imgBtn.setOnClickListener(clickListenerIncrease);

    }

    private String getCorrectWord(long score) {
        long val = Math.abs(score);
        String res = "";

        long lastValue = val % 10;
        long twoLastValue = val % 100;

        if (lastValue == 0 || lastValue == 1 || lastValue == 5 || lastValue == 6 || lastValue == 7 || lastValue == 8 || lastValue == 9){
            res = "раз";
        }

        if (lastValue == 2 || lastValue == 3 || lastValue == 4){
            res = "раза";
        }

        if (twoLastValue >= 12 && twoLastValue <= 14){
            res = "раз";
        }

        return res;
    }
}

