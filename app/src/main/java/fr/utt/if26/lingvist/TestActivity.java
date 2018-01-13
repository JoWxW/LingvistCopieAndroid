package fr.utt.if26.lingvist;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
    /*List<Grammaire> grammaires;
    SQLiteDatabase db;
    MyAdapter myAdapter;
    AssetsDatabaseManager mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grammaire);

        ListView lv = (ListView) findViewById(R.id.grammaireList);
        grammaires = new ArrayList<Grammaire>();

        // 初始化，只需要调用一次
        AssetsDatabaseManager.initManager(getApplication());
        // 获取管理对象，因为数据库需要通过管理对象才能够获取
        mg = AssetsDatabaseManager.getManager();
        // 通过管理对象获取数据库
        db = mg.getDatabase("Lingvist.db");
        // 对数据库进行操作


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
                        .findViewById(R.id.grammaireList_button);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //向TextView中插入数据
            viewHolder.txt_name.setText(g.getTitre());

            return convertView;
        }
    }

    class ViewHolder {
        private TextView txt_name;
    }

    public void Query() {
        Cursor cursor = db.rawQuery("select * from grammaire", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String titre = cursor.getString(1);
            String contenu = cursor.getString(2);
            Grammaire grammaire = new Grammaire(id, titre, contenu);
            grammaires.add(grammaire);
        }
    }*/
}
