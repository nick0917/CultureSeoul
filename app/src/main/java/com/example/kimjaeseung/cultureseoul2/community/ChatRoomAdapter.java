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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by kimjaeseung on 2017. 7. 23..
 */

public class ChatRoomAdapter extends RecyclerView.Adapter<ChatRoomAdapter.ViewHolder>{
    private Context mContext;
    private List<ChatRoomData> chatRoomDataList=new ArrayList<>();
    private ChatRoomAdapterOnClickHandler chatRoomAdapterOnClickHandler;
    private ChatRoomData chatRoomData;
    private int mPosition;

    public interface ChatRoomAdapterOnClickHandler{
        void onClick(ChatRoomData chatRoomData);
    }

    public ChatRoomAdapter(Context context,ChatRoomAdapterOnClickHandler handler){
        mContext=context;
        chatRoomAdapterOnClickHandler=handler;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.community_listitem_chatroom;
        LayoutInflater inflater = LayoutInflater.from(context);

        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(chatRoomDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatRoomDataList.size();
    }

    public void setItemList(List<ChatRoomData> itemList){
        chatRoomDataList.clear();
        chatRoomDataList.addAll(itemList);
    }
    public void addItem(ChatRoomData chatRoomData){
        chatRoomDataList.add(chatRoomData);
    }
    public void removeItem(int position){
        chatRoomDataList.remove(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mPerformanceImage;
        private TextView mRoomName;
        private TextView mRoomLocation;
        private TextView mRoomDay;
        private TextView mRoomTime;
        private TextView mRoomPeople;
        private TextView mLine;

        public ViewHolder(View itemView) {
            super(itemView);

            mPerformanceImage=(ImageView)itemView.findViewById(R.id.community_iv_chatroom);
            mRoomName=(TextView)itemView.findViewById(R.id.community_tv_roomname);
            mRoomLocation=(TextView)itemView.findViewById(R.id.community_tv_roomlocation);
            mRoomTime=(TextView)itemView.findViewById(R.id.community_tv_roomtime);
            mRoomDay=(TextView)itemView.findViewById(R.id.community_tv_roomday);
            mRoomPeople=(TextView)itemView.findViewById(R.id.community_tv_roompeople);
            mLine=(TextView)itemView.findViewById(R.id.community_tv_line);

            itemView.setOnClickListener(this);
        }
        public void bind(ChatRoomData chatRoomData){
            mPerformanceImage.setImageResource(chatRoomData.getPerformanceImage());
            mRoomName.setText(chatRoomData.getRoomName());
            mRoomPeople.setText("0/"+chatRoomData.getRoomPeople());
            mRoomDay.setText(chatRoomData.getRoomDay());
            mRoomTime.setText(chatRoomData.getRoomTime());
            mRoomLocation.setText(chatRoomData.getRoomLocation());
            mLine.setBackgroundResource(R.color.colorPrimary);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            chatRoomData = chatRoomDataList.get(position);
            chatRoomAdapterOnClickHandler.onClick(chatRoomData);
        }
    }


}
