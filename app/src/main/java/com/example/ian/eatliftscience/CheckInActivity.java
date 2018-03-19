package com.example.ian.eatliftscience;
import com.example.ian.eatliftscience.AccountDao;
import com.example.ian.eatliftscience.NutritionixRequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.ian.eatliftscience.R.id.action_bar_spinner;
import static com.example.ian.eatliftscience.R.id.spinner;

public class CheckInActivity extends AppCompatActivity {
    public static final String BF = "com.example.ian.eatliftscience.BF";
    AccountDao.setBF(getIntent("email"), bf);
    public String goal;
    public double weight = AccountDao.getAccount(getIntent("email"), getIntent("password"))[2];
    public double prev_weight = AccountDao.getAccount(getIntent("email"), getIntent("password"))[4];
    public double prev_bf = AccountDao.getAccount(getIntent("email"), getIntent("password"))[5];
    public double cal = NutritionixRequest.getCalories(getIntent("email"), getIntent("password"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        final Spinner dropdown = (Spinner)findViewById(spinner);
        String[] items = new String[]{"Lose Fat", "Maintain", "Reverse Diet", "Gain Muscle"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        Button checkIn = findViewById(R.id.check_in_submit);
        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goal = dropdown.getSelectedItem().toString();
                checkInSubmit();
            }
        });
    }

    private void checkInSubmit() {
        Intent intentc = new Intent(this, CheckInSubmitActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);

        double bf = Double.parseDouble(editText.getText().toString());
        double bf_change = bf - prev_bf;
        double wc = weight - prev_weight;
        double lg = (100-bf)*weight/100;
        String message = "";
        String OB = " Your lifts for the week totaled 8264.5 J of work";
        if (goal == "Lose Fat" ){
            if (bf_change == 0){
                message = "Your bodyfat stayed the same. We would suggest consuming" + (cal-500) + "calories daily to lose a pound of fat next week.";
            }
            if (bf_change > 0){
                message = "Your bodyfat increased. We would suggest consuming" + (cal-(1+bf_change)*500) + "calories daily to lose a pound of fat next week.";
            }
            if (bf_change < 0){
                message = "Your bodyfat decreased. We would suggest consuming" + (cal-(1+bf_change)*500) + "calories to lose a pound of fat next week.";
            }
        }
        if (goal == "Gain Muscle" ){
            if (lg == 0){
                message = "Your lean mass stayed the same. We would suggest consuming" + (cal+500) + "calories daily to gain a pound in the next week.";
            }
            if (lg > 0){
                message = "Your lean mass increased. We would suggest consuming" + (cal+(1-wc)*500) + "calories daily to gain a pound in the next week.";
            }
            if (lg < 0){
                message = "Your lean mass decreased. We would suggest consuming" + (cal+(1+wc)*500) + "calories daily to gain a pound in the next week.";
            }
        }
        if (goal == "Reverse Diet"){
            if (wc == 0){
                message = "Your weight stayed the same. We would suggest consuming" + (cal+100) + "calories daily to increase your metabolism in the next week.";
            }
            if (wc > 0){
                message = "Your weight increased. We would suggest consuming" + (cal-(wc*500)) + "calories daily to maintain your metabolism in the next week.";
            }
            if (wc < 0){
                message = "Your weight decreased. We would suggest consuming" + (cal-(wc*500)) + "calories daily to increase your metabolism in the next week.";
            }
        }
        if (goal == "Maintain"){
            if (wc == 0){
                message = "Your weight stayed the same. We would suggest consuming" + cal + "calories daily to maintain your weight in the next week.";
            }
            if (wc > 0){
                message = "Your weight increased. We would suggest consuming" + (cal-(wc*500)) + "calories daily to maintain your weight in the next week.";
            }
            if (wc < 0){
                message = "Your weight decreased. We would suggest consuming" + (cal-(wc*500)) + "calories daily to increase your metabolism in the next week.";
            }
        }
        message = message + OB;
        intentc.putExtra(BF, message);
        startActivity(intentc);
    }



}
