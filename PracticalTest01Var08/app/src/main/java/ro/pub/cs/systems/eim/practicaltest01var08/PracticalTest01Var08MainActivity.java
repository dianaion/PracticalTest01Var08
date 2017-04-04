package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private EditText number1 = null;
    private EditText number2 = null;
    private EditText number3 = null;
    private EditText number4 = null;
    private Button set_button = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            try {
                int number1value = Integer.parseInt(number1.getText().toString());
                int number2value = Integer.parseInt(number2.getText().toString());
                int number3value = Integer.parseInt(number3.getText().toString());
                int number4value = Integer.parseInt(number4.getText().toString());
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
                intent.putExtra("number1value", number1value);
                intent.putExtra("number2value", number2value);
                intent.putExtra("number3value", number3value);
                intent.putExtra("number4value", number4value);
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }
            catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);


        number1 = (EditText)findViewById(R.id.number1);
        number1.setText(String.valueOf(0));
        number2 = (EditText)findViewById(R.id.number2);
        number2.setText(String.valueOf(0));
        number3 = (EditText)findViewById(R.id.number3);
        number3.setText(String.valueOf(0));
        number4 = (EditText)findViewById(R.id.number4);
        number4.setText(String.valueOf(0));


        set_button = (Button)findViewById(R.id.set_button);
        set_button.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("number1button", number1.getText().toString());
        savedInstanceState.putString("number2button", number2.getText().toString());
        savedInstanceState.putString("number3button", number3.getText().toString());
        savedInstanceState.putString("number4button", number4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("number1button")) {
            number1.setText(savedInstanceState.getString("number1button"));
        } else {
            number1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number2button")) {
            number2.setText(savedInstanceState.getString("number2button"));
        } else {
            number2.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number3button")) {
            number3.setText(savedInstanceState.getString("number3button"));
        } else {
            number3.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number4button")) {
            number4.setText(savedInstanceState.getString("number4button"));
        } else {
            number4.setText(String.valueOf(0));
        }
    }


}
