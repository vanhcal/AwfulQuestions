package org.hunt2.hunt.awfulquestions;

/**
 * Created by Van on 8/10/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class CustomArrayAdapterBlank extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<>();
    private Context context, mContext;

    public CustomArrayAdapterBlank(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_layout_blank, null);
        }

        final Button nameButton = (Button) view.findViewById(R.id.nameButton);
        nameButton.setText(list.get(position));
        nameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mContext instanceof ActivityC) {
                    ((ActivityC)mContext).showResultDialog(v.getContext(), position, nameButton);
                }
            }
        });

        return view;
    }
}
