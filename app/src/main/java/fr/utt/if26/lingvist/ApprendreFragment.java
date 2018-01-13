package fr.utt.if26.lingvist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wxw on 2018/1/12.
 */

public class ApprendreFragment extends Fragment{
    private String content;
    public ApprendreFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_grammaire,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.textView);
        txt_content.setText(content);
        return view;
    }

}
