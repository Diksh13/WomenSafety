package com.example.womensafety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserModel> userModelArrayList;
    public CustomAdapter(Context context, ArrayList<UserModel> userModelArrayList) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }

    @Override
    public int getCount() {
        return userModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_guardian_list, null, true);
            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvm1 = (TextView) convertView.findViewById(R.id.mob1);
            holder.tvm2 = (TextView) convertView.findViewById(R.id.mob2);
            holder.tvemail = (TextView) convertView.findViewById(R.id.email);


            convertView.setTag(holder);
        }else {
// the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvname.setText("Name: "+userModelArrayList.get(position).getName());
        holder.tvm1.setText("Mobile Number 1: "+userModelArrayList.get(position).getGmob1());
        holder.tvm2.setText("Mobile Number 2: "+userModelArrayList.get(position).getGmob2());
        holder.tvemail.setText("Email: "+userModelArrayList.get(position).getGemail());

        return convertView;
    }
    private class ViewHolder {
        protected TextView tvname, tvm1,tvm2,tvemail;
    }

}