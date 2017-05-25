package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Variable to store the total score
    int score;

    // Method to check if the answers are right or wrong
    public void submit(View view) {
        //Checks if the correct radio button was picked in Question 1
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.q1firstAnswer);
        boolean rightAnswerQuestion1 = radioButton1.isChecked();
        if (rightAnswerQuestion1)
            score += 1;
        radioButton1.setTextColor(getColor(R.color.correctAnswer));

        //Checks if the correct radio button was picked in Question 2
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.q2thirdAnswer);
        boolean rightAnswerQuestion2 = radioButton2.isChecked();
        if (rightAnswerQuestion2)
            score += 1;
        //Changes color of the text of the correct radio button to green
        radioButton2.setTextColor(getColor(R.color.correctAnswer));

        //Checks if the correct answers are given in Question 3
        CheckBox checkBoxQuestion3a = (CheckBox) findViewById(R.id.q3firstAnswer);
        boolean answerQ3_a = checkBoxQuestion3a.isChecked();
        CheckBox checkBoxQuestion3b = (CheckBox) findViewById(R.id.q3secondAnswer);
        boolean answerQ3_b = checkBoxQuestion3b.isChecked();
        CheckBox checkBoxQuestion3c = (CheckBox) findViewById(R.id.q3thirdAnswer);
        boolean answerQ3_c = checkBoxQuestion3c.isChecked();
        CheckBox checkBoxQuestion3d = (CheckBox) findViewById(R.id.q3fourthAnswer);
        boolean answerQ3_d = checkBoxQuestion3d.isChecked();
        if (answerQ3_b && answerQ3_d && !answerQ3_a && !answerQ3_c)
            score += 1;
        //Mark the right answers
        checkBoxQuestion3b.setTextColor(getColor(R.color.correctAnswer));
        checkBoxQuestion3d.setTextColor(getColor(R.color.correctAnswer));

        //Checks if the correct answers are given in Question 4
        CheckBox checkBoxQuestion4a = (CheckBox) findViewById(R.id.q4firstAnswer);
        boolean answerQ4_a = checkBoxQuestion4a.isChecked();
        CheckBox checkBoxQuestion4b = (CheckBox) findViewById(R.id.q4secondAnswer);
        boolean answerQ4_b = checkBoxQuestion4b.isChecked();
        CheckBox checkBoxQuestion4c = (CheckBox) findViewById(R.id.q4thirdAnswer);
        boolean answerQ4_c = checkBoxQuestion4c.isChecked();
        CheckBox checkBoxQuestion4d = (CheckBox) findViewById(R.id.q4fourthAnswer);
        boolean answerQ4_d = checkBoxQuestion4d.isChecked();
        if (answerQ4_a && answerQ4_d && !answerQ4_b && !answerQ4_c)
            score += 1;
        //Mark the right answers
        checkBoxQuestion4a.setTextColor(getColor(R.color.correctAnswer));
        checkBoxQuestion4d.setTextColor(getColor(R.color.correctAnswer));

        //Checks if the correct answer is typed in Question 5
        EditText playerQ5 = (EditText) findViewById(R.id.q5Answer);
        if (playerQ5.getText().toString().equals(getString(R.string.q5Answer))) {
            score += 1;
            //Changes the color of the answer to green if correct
            playerQ5.setTextColor(getColor(R.color.correctAnswer));
        } else {
            //if user did not insert anything
            if (playerQ5.getText().toString().equals("")) {
                playerQ5.setText(getString(R.string.q5Answer));
                playerQ5.setTextColor(getColor(R.color.wrongAnswer));
            } else {
                //Shows the right answer if something was inserted from the user
                playerQ5.setText(getString(R.string.q5Answer) + getString(R.string.not) + playerQ5.getText());
            }
        }

        //Checks if the correct answer is typed in Question 6
        EditText playerQ6 = (EditText) findViewById(R.id.q6Answer);
        if (playerQ6.getText().toString().equals(getString(R.string.q6Answer))) {
            score += 1;
            //Changes the color of the answer to green if correct
            playerQ6.setTextColor(getColor(R.color.correctAnswer));
        } else {
            //if user did not insert anything
            if (playerQ6.getText().toString().equals("")) {
                playerQ6.setText(getString(R.string.q6Answer));
                playerQ6.setTextColor(getColor(R.color.wrongAnswer));
            } else {
                //Shows the right answer if something was inserted from the user
                playerQ6.setText(getString(R.string.q6Answer) + getString(R.string.not) + playerQ6.getText());
            }
        }

        //Prevents the Submit method from being pressed more than once
        Button myButton = (Button) findViewById(R.id.submitButton);
        myButton.setClickable(false);

        //Displays toast message with the score
        Toast.makeText(this, getString(R.string.scoreText) + " " + score + " " + getString(R.string.fromAnswers), Toast.LENGTH_LONG).show();
    }

}
