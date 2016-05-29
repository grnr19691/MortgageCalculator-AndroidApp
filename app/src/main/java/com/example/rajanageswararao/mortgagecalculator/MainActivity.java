package com.example.rajanageswararao.mortgagecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            TextView textView1 = (TextView) findViewById(R.id.textView1);
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView1.setText("Annual Interest Rate: "+((float)progress)/5+" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClick(View view)
    {

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        EditText LoanAmount = (EditText) findViewById(R.id.amountBorrowed);
        switch (view.getId()) {
            case R.id.button:

                if (LoanAmount.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }
                Double P = Double.parseDouble(LoanAmount.getText().toString());
                double J = ((double) seekBar.getProgress())*2 / 12000;

                RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
                RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
                RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

                double N;
                if (radioButton1.isChecked())
                    N = 15 * 12;
                else if (radioButton2.isChecked())
                    N = 20 * 12;
                else if (radioButton3.isChecked())
                    N = 30 * 12;
                else {
                    Toast.makeText(this, "Please select the number of months", Toast.LENGTH_LONG).show();
                    return;
                }
                boolean T;

                CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

                if (checkBox.isChecked())
                    T = true;
                else
                    T = false;
                TextView textView2 = (TextView) findViewById(R.id.textView2);
                textView2.setText("Monthly Interest : "+String.format("%.2f", calculateUtil.interestCalculator(P, J, N, T)));
                //textView2.setText(J+"");
                break;
        }
    }
}


