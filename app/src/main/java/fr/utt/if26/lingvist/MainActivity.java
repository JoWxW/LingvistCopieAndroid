package fr.utt.if26.lingvist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_better;

    //Fragment Object
    private GrammaireFragment grammaireFragment;
    private ApprendreFragment apprendreFragment;
    private CompteFragment compteFragment;
    private DefisFragment defisFragment;
    private FragmentManager fManager;


    SQLiteDatabase db;
    AssetsDatabaseManager mg;
    ArrayList<Word> words;
    Word wordDemande;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fManager = getFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_better.setChecked(true);
        // 初始化，只需要调用一次
        AssetsDatabaseManager.initManager(getApplication());
        // 获取管理对象，因为数据库需要通过管理对象才能够获取
        mg = AssetsDatabaseManager.getManager();
        // 通过管理对象获取数据库
        db = mg.getDatabase("Lingvist.db");

        words = new ArrayList<Word>();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //FragmentTransaction fTransaction = fManager.beginTransaction();
       // hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.rb_channel:
                setWordDemande();
                apprendreActivity();
                /*Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text = wordDemande.getWord();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                /*if(apprendreFragment == null){
                    apprendreFragment = new ApprendreFragment("apprendre");
                    fTransaction.add(R.id.ly_content,apprendreFragment);
                }else{
                    fTransaction.show(apprendreFragment);
                }*/
                break;
            case R.id.rb_better:
                /*if(compteFragment == null){
                    compteFragment = new CompteFragment("compte");
                    fTransaction.add(R.id.ly_content,compteFragment);
                }else{
                    fTransaction.show(compteFragment);
                }*/
                break;
            case R.id.rb_setting:
                grammaireActivity();
                /*if(grammaireFragment == null){
                    grammaireFragment = new GrammaireFragment("G");
                    GrammaireActivity grammaireActivity = new GrammaireActivity();
                    fTransaction.add(R.id.ly_content,grammaireFragment);
                }else{
                    fTransaction.show(grammaireFragment);
                }*/
                break;
        }
        //fTransaction.commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(apprendreFragment != null)fragmentTransaction.hide(apprendreFragment);
        if(defisFragment != null)fragmentTransaction.hide(defisFragment);
        if(compteFragment != null)fragmentTransaction.hide(compteFragment);
        if(grammaireFragment != null)fragmentTransaction.hide(grammaireFragment);
    }

    private void setWordDemande() {
        Cursor cursor = db.rawQuery("select * from mot", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String letter = cursor.getString(1);
            String hint = cursor.getString(2);
            Word word = new Word(id, letter, hint);
            words.add(word);
        }
        int size = words.size();
        int position = (int) Math.round((Math.random() * (size - 1)));
        wordDemande = words.get(position);
        //wordDemande = new Word(wordSelected.getId(), wordSelected.getWord(), wordSelected.getHint());
    }

    private void grammaireActivity(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, GrammaireActivity.class);
        MainActivity.this.startActivity(intent);
    }

    private void apprendreActivity(){
        String key = wordDemande.getWord();
        String hint = wordDemande.getHint();
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ApprendreActivity.class);
        intent.putExtra("key", key);
        intent.putExtra("hint", hint);
        MainActivity.this.startActivity(intent);
    }
}
