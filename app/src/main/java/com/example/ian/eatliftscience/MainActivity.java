package com.example.ian.eatliftscience;
import com.example.ian.eatliftscience.AccountDao;
import com.example.ian.eatliftscience.NutritionixRequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkIn = (Button) findViewById(R.id.check_in);
        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkIn();
            }
        });

        Button changeGoal = (Button) findViewById(R.id.change_goal);
        changeGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeGoal();
            }
        });

        Button history = (Button) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history();
            }
        });

    }

    int weight = NutritionixRequest.getWeight(getIntent("email"), getIntent("password"));
    AccountDao.setWeight(getIntent("email"), weight);
    int cal = NutritionixRequest.getCalories(getIntent("email"), getIntent("password"));

    static String account[] = AccountDao.getAccount(getIntent("email"), getIntent("password"));

    private void checkIn() {
        Intent intent1 = new Intent(this, CheckInActivity.class);
        startActivity(intent1);
        intent.putExtra("email","email");
        intent.putExtra("password","password");
        intent.putExtra("weight","weight");
        intent.putExtra("cal","cal");
    }
}
