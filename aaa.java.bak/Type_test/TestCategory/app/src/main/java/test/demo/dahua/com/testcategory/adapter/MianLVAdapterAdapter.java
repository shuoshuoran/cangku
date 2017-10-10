package test.demo.dahua.com.testcategory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import test.demo.dahua.com.testcategory.R;

/**
 * Created by dragon on 2017/9/12.
 */

public class MianLVAdapterAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> datas;


    public MianLVAdapterAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextHolder textHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.text, null);
            textHolder = new TextHolder(convertView);
            convertView.setTag(textHolder);

        }else{
            textHolder = (TextHolder) convertView.getTag();
        }
        textHolder.tv_name.setText(datas.get(position));
        return convertView;
    }

    class TextHolder{
        TextView tv_name;

        public TextHolder(View itemView) {
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);

        }
    }
}
