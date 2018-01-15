package fr.utt.if26.lingvist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ApprendreActivity extends AppCompatActivity {

    String key, hint,input;
    Intent intent;
    TextView hintText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apprendre);
        intent = getIntent();
        key = intent.getStringExtra("key");
        hint = intent.getStringExtra("hint");
        hintText = findViewById(R.id.wordHint);
        hintText.setText(hint);

    }


}
