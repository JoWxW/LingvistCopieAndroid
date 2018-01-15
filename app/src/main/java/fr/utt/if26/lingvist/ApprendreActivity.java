package fr.utt.if26.lingvist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ApprendreActivity extends AppCompatActivity {

    String key, hint,input;
    Intent intent;
    TextView hintText, infoText;
    EditText wordInput;
    Button wordEnter, wordNext;

    ArrayList<Word> wordArrayList;

    SQLiteDatabase db;
    AssetsDatabaseManager mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apprendre);

        wordArrayList = new ArrayList<Word>();

        AssetsDatabaseManager.initManager(getApplication());
        mg = AssetsDatabaseManager.getManager();
        // 通过管理对象获取数据库
        db = mg.getDatabase("Lingvist.db");

        setWordArrayList();

        intent = getIntent();
        key = intent.getStringExtra("key");
        hint = intent.getStringExtra("hint");
        hintText = (TextView) findViewById(R.id.wordHint);
        hintText.setText(hint);
        infoText = (TextView) findViewById(R.id.wordInfo);
        infoText.setText("");

        wordInput = (EditText) findViewById(R.id.wordInput);
        wordEnter = (Button)findViewById(R.id.wordEnter);
        wordEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = wordInput.getText().toString();
                if(input.equals(key)){
                    infoText.setText("Correct!");
                }else{
                    infoText.setText("Wrong...");
                }
            }
        });
        wordNext = (Button)findViewById(R.id.wordNext);
        wordNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWord();
            }
        });

    }

    private void setWordArrayList(){
        Cursor cursor = db.rawQuery("select * from mot", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String letter = cursor.getString(1);
            String hint = cursor.getString(2);
            Word w = new Word(id, letter, hint);
            wordArrayList.add(w);
        }
        //Log.i("mot", String.valueOf(wordArrayList.size()));
    }

    private void changeWord(){
        int size = wordArrayList.size();
        int position = (int) Math.round((Math.random() * (size - 1)));
        Word word = wordArrayList.get(position);
        hint = word.getHint();
        hintText.setText(hint);
        wordInput.setText("");
        key = word.getWord();
        infoText.setText("");
    }

}
