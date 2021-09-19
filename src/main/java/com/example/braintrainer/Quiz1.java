package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import android.os.Bundle;

public class Quiz1 extends AppCompatActivity {
    Random rand = new Random();
    private TextView time;
    private Button a;
    private Button b;
    private Button c;
    private Button d;
    int count_score = 0;
    private TextView score;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        Button play_again = findViewById(R.id.again);
        play_again.setVisibility(View.INVISIBLE);
        TextView View_question = findViewById(R.id.question);
        TextView View_result = findViewById(R.id.result);
        View_result.setVisibility(View.INVISIBLE);
        time = findViewById(R.id.time_count);
        score = findViewById(R.id.score_count);
        a = findViewById(R.id.button_1);
        b = findViewById(R.id.button_2);
        c = findViewById(R.id.button_3);
        d = findViewById(R.id.button_4);

        int x ,y;
        x = rand.nextInt((100-1)+1) + 1;
        y = rand.nextInt((100-1)+1) + 1;
        int correct = x + y;
        int select = rand.nextInt(3);
        int opt_1 = rand.nextInt((100-1)+1) + 1;
        int opt_2 = rand.nextInt((100-1)+1) + 1;
        int opt_3 = rand.nextInt((100-1)+1) + 1;
        int opt_4 = rand.nextInt((100-1)+1) + 1;
        if(select == 0)
            opt_1 = correct;
        else if (select == 1)
            opt_2 = correct;
        else if (select == 2)
            opt_3 = correct;
        else
            opt_4 = correct;


        CountDownTimer timer = new CountDownTimer(25000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long t_milli) {
                time.setText("" + t_milli / 1000);
            }

            public void onFinish() {
                time.setText("0");
                play_again.setVisibility(View.VISIBLE);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);

            }
        }.start();

        View_question.setText(x + " + " + y);
        a.setText("" + opt_1);
        b.setText("" + opt_2);
        c.setText("" + opt_3);
        d.setText("" + opt_4);

        int final_opt_1 = opt_1;
        int final_opt_2 = opt_2;
        int final_opt_3 = opt_3;
        int final_opt_4 = opt_4;

        a.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(final_opt_1 == correct) {
                    View_result.setText("Correct");
                    count_score++;
                }
                else {
                    View_result.setText("Wrong!");

                }
                score.setText(""+count_score+"/1");
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                View_result.setVisibility(View.VISIBLE);
                play_again.setVisibility(View.VISIBLE);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(final_opt_2 == correct) {
                    View_result.setText("Correct!");
                    count_score++;
                }
                else {
                    View_result.setText("Wrong!");
                }
                score.setText(""+count_score + "/1");
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                View_result.setVisibility(View.VISIBLE);
                play_again.setVisibility(View.VISIBLE);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(final_opt_3 == correct) {
                    View_result.setText("Correct!");
                    count_score++;
                }
                else {
                    View_result.setText("Wrong!");

                }
                score.setText(""+count_score + "/1");
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                View_result.setVisibility(View.VISIBLE);
                play_again.setVisibility(View.VISIBLE);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")

            @Override
            public void onClick(View v) {
                timer.cancel();
                if(final_opt_4 == correct) {
                    View_result.setText("Correct!");
                    count_score++;
                }
                else {
                    View_result.setText("Wrong!");

                }
                score.setText(""+count_score + "/1");
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                View_result.setVisibility(View.VISIBLE);
                play_again.setVisibility(View.VISIBLE);
            }
        });


        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz1.this, MainActivity.class));
            }
        });
    }
}