package com.example.caps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private int qNum = 1;
    private String qa;
    private Game game = new Game();
    private static String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ask();
    }

    private static String getQuestion (String s) {
        String[] qA = s.split("\\n");
        return qA[0];
    }

    private static String getAnswer (String s) {
        String[] qA = s.split("\\n");
        return qA[1];
    }

    private void ask() {
        qa = game.QA();
        ((TextView) findViewById(R.id.question)).setText(getQuestion(qa));
    }


    public void onDone(View view) {
        EditText userAnswer = (EditText) findViewById(R.id.answer);
        String userAnswerString = userAnswer.getText().toString();

        if (getAnswer(qa).equalsIgnoreCase(userAnswerString)) {
            score++;
        }

        output = "Q# " + qNum++ + ": " + getQuestion(qa) + "\n" + "Your Answer: " + userAnswerString.toUpperCase() + "\n" + "Correct Answer: " + getAnswer(qa)+ "\n\n" + output ;

        if (qNum == 10) {
            ((TextView) findViewById(R.id.qNum)).setText("Game Over!");
            Button buttn = (Button) findViewById(R.id.done);
            buttn.setEnabled(false);
            ((TextView) findViewById(R.id.log)).setText(output);
            ((EditText) findViewById(R.id.answer)).setText("");
            finish();
        } else {
            ask();
            ((TextView) findViewById(R.id.log)).setText(output);
            ((EditText) findViewById(R.id.answer)).setText("");
            ((TextView) findViewById(R.id.qNum)).setText("Q# " + qNum);
        }
        ((TextView) findViewById(R.id.score)).setText("SCORE = " + score);
    }}
