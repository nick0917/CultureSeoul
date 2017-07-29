package com.example.kimjaeseung.cultureseoul2.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimjaeseung.cultureseoul2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by kimjaeseung on 2017. 7. 23..
 */

public class ChatRoomAdapter extends ArrayAdapter<ChatRoomData>{

    public ChatRoomAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.community_listitem_chatroom, null);

            viewHolder = new ViewHolder();
            viewHolder.mPerformanceImage=(ImageView)convertView.findViewById(R.id.community_iv_chatroom);
            viewHolder.mRoomName=(TextView)convertView.findViewById(R.id.community_tv_roomname);
            viewHolder.mRoomLocation=(TextView)convertView.findViewById(R.id.community_tv_roomlocation);
            viewHolder.mRoomTime=(TextView)convertView.findViewById(R.id.community_tv_roomtime);
            viewHolder.mRoomState=(TextView)convertView.findViewById(R.id.community_tv_roomstate);
            viewHolder.mRoomPeople=(TextView)convertView.findViewById(R.id.community_tv_roompeople);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChatRoomData chatRoomData = getItem(position);
        viewHolder.mPerformanceImage.setImageResource(chatRoomData.getPerformanceImage());
        viewHolder.mRoomName.setText(chatRoomData.getRoomName());
        viewHolder.mRoomLocation.setText(chatRoomData.getRoomLocation());
        viewHolder.mRoomTime.setText(chatRoomData.getRoomTime());
        viewHolder.mRoomState.setText(chatRoomData.getRoomState());
        viewHolder.mRoomPeople.setText(chatRoomData.getRoomPeople());

        return convertView;
    }

    private class ViewHolder {
        private ImageView mPerformanceImage;
        private TextView mRoomName;
        private TextView mRoomLocation;
        private TextView mRoomTime;
        private TextView mRoomState;
        private TextView mRoomPeople;
    }

}
