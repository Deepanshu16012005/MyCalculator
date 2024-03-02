package com.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

public class MainActivity extends AppCompatActivity {
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = findViewById(R.id.output_problem);
    }

    public void ButtonClicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String previous_no = Result.getText().toString();
        String string ;

        if (buttonText.equalsIgnoreCase("ac")) {
            string = "";
            Result.setText(string);
            return;

        } else if (buttonText.equalsIgnoreCase("del")) {
            if (!previous_no.isEmpty()) {
                string = previous_no.substring(0, previous_no.length() - 1);
                Result.setText(string);
                return;
            } else {
                string = "";
                Result.setText(string);
                return;
            }
        } else if (buttonText.equalsIgnoreCase("x")) {
            Result.setText(previous_no+'*');


        } else if (buttonText.equalsIgnoreCase("÷")) {
            Result.setText(previous_no+'/');

        } else if (buttonText.equalsIgnoreCase("=")) {

                // expression calculation
                try {
                    Expression expression = new Expression(previous_no);
                    EvaluationValue result = expression.evaluate();
                    Result.setText(result.getStringValue());
                } catch (EvaluationException ignored) {

                } catch (ParseException ignored) {

                }


        } else {
            string = previous_no + buttonText;
            Result.setText(string);
        }



    }
}