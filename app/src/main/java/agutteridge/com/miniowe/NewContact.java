package agutteridge.com.miniowe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NewContact extends AppCompatActivity {
    // Global variable to enable access from within inner class
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        CounterLayout counterLayout= (CounterLayout) findViewById(R.id.counter_layout);
        LayoutInflater layoutInflater = getLayoutInflater();
        View counterView = layoutInflater.inflate(R.layout.counter_layout, null, false);

        ImageButton minus = (ImageButton) counterView.findViewById(R.id.minus);
        counter = (TextView) counterView.findViewById(R.id.counter);
        ImageButton plus = (ImageButton) counterView.findViewById(R.id.plus);

        counter.setText("0");

        /** Called when the minus button is pressed */
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int counterValue = R.id.counter;
                String newValue = Integer.toString(counterValue--);
                counter.setText(newValue);
            }
        });

        /** Called when the plus button is pressed */
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int counterValue = R.id.counter;
                String newValue = Integer.toString(counterValue++);
                counter.setText(newValue);
            }
        });

        counterLayout.addView(counterView);
    }
}