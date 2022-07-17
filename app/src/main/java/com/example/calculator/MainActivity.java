package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    public void update (String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void oneBTN (View view) {
        update("1");
    }

    public void twoBTN (View view) {
        update("2");
    }

    public void threeBTN (View view) {
        update("3");
    }

    public void fourBTN (View view) {
        update("4");
    }

    public void fiveBTN (View view) {
        update("5");
    }

    public void sixBTN (View view) {
        update("6");
    }

    public void sevenBTN (View view) {
        update("7");
    }

    public void eightBTN (View view) {
        update("8");
    }

    public void nineBTN (View view) {
        update("9");
    }

    public void zeroBTN (View view) {
        update("0");
    }

    public void clearBTN (View view) {
        display.setText("");

    }

    public void equalBTN (View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void multiplyBTN (View view) {
        update("x");
    }

    public void devideBTN (View view) {
        update("/");
    }

    public void addBTN (View view) {
        update("+");
    }

    public void substrackBTN (View view) {
        update("-");
    }

    public void backspaceBTN (View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0 ) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}