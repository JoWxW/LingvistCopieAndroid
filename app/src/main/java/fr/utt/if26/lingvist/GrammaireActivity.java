package fr.utt.if26.lingvist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxw on 2018/1/12.
 */

public class GrammaireActivity extends AppCompatActivity {
    ArrayList<Grammaire> grammaires;
    SQLiteDatabase db;
    MyAdapter myAdapter;
    //AssetsDatabaseManager mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grammaire);
        ListView lv = (ListView) findViewById(R.id.grammaireList);
        grammaires = new ArrayList<Grammaire>();


        /*Intent intent = getIntent();
        GrammairesSer grammairesSer = (GrammairesSer) intent.getSerializableExtra("gs");
        grammaires.addAll(grammairesSer.getGrammaires());*/

        /*SQLiteDataBaseSerializable dbSerRec = (SQLiteDataBaseSerializable) intent.getSerializableExtra("dbSer");
        db = dbSerRec.getDb();*/

        // 查询数据
        Query();
        // 创建MyAdapter实例
        myAdapter = new MyAdapter(this);
        // 向listview中添加Adapter
        lv.setAdapter(myAdapter);
    }

    class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return grammaires.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //  lire les titires de conseils depuis le tableau "grammaire"
            Grammaire g = grammaires.get(position);
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.grammaire_listitem, null);
                viewHolder.txt_name = (TextView) convertView
                        .findViewById(R.id.grammaire_textView);
                convertView.setTag(viewHolder);
                viewHolder.txt_contenu = (TextView) convertView
                        .findViewById(R.id.grammaire_textView2);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //向TextView中插入数据
            viewHolder.txt_name.setText(g.getTitre());
            viewHolder.txt_contenu.setText(g.getContenu());

            return convertView;
        }
    }

    class ViewHolder {
        private TextView txt_name;
        private TextView txt_contenu;
    }

    public void Query() {
        Grammaire g = new Grammaire();

        grammaires.addAll(g.getGrammaires());
        /*Cursor cursor = db.rawQuery("select * from grammaire", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String titre = cursor.getString(1);
            String contenu = cursor.getString(2);
            Grammaire grammaire = new Grammaire(id, titre, contenu);
            grammaires.add(grammaire);
        }*/

    }
}
