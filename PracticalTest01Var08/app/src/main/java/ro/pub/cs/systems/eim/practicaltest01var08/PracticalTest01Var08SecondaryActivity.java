package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {
    Button sum_button, prod_button;
    TextView number1view, number2view, number3view, number4view;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int number1value = Integer.parseInt(number1view.getText().toString());
            int number2value = Integer.parseInt(number2view.getText().toString());
            int number3value = Integer.parseInt(number3view.getText().toString());
            int number4value = Integer.parseInt(number4view.getText().toString());
            switch(view.getId()) {
                case R.id.sum_button:
                    int sum = number1value + number2value + number3value + number4value;
                    Toast.makeText(getApplicationContext(), "Sum " + String.valueOf(sum), Toast.LENGTH_LONG).show();
                    break;
                case R.id.prod_button:
                    int prod = number1value * number2value * number3value * number4value;
                    Toast.makeText(getApplicationContext(), "Prod " + String.valueOf(prod), Toast.LENGTH_LONG).show();
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);
        number1view = (TextView)findViewById(R.id.number1view);
        number2view = (TextView)findViewById(R.id.number2view);

        number3view = (TextView)findViewById(R.id.number3view);

        number4view = (TextView)findViewById(R.id.number4view);


        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("number1value")) {
            int number1value = intent.getIntExtra("number1value", -1);
            number1view.setText(String.valueOf(number1value));
            int number2value  = intent.getIntExtra("number2value", -1);
            number2view.setText(String.valueOf(number2value ));
            int number3value  = intent.getIntExtra("number3value", -1);
            number3view.setText(String.valueOf(number3value ));
            int number4value  = intent.getIntExtra("number4value", -1);
            number4view.setText(String.valueOf(number4value ));
        }

        sum_button = (Button)findViewById(R.id.sum_button);
        sum_button.setOnClickListener(buttonClickListener);
        prod_button = (Button)findViewById(R.id.prod_button);
        prod_button.setOnClickListener(buttonClickListener);
    }
}
