package com.example.kimjaeseung.cultureseoul2.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimjaeseung.cultureseoul2.R;
import com.example.kimjaeseung.cultureseoul2.domain.CultureEvent;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heo04 on 2017-07-12.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    private static final String TAG = HomeAdapter.class.getSimpleName();

    private List<CultureEvent> cultureEventList = new ArrayList<>();

    private Context mContext;
    private HomeAdapterOnClickHandler mHomeHandler;
    private CultureEvent mCultureEvent;
    private int mPosition;

    public interface HomeAdapterOnClickHandler
    {
        void onClick(CultureEvent cultureEvent);
    }

    public HomeAdapter(Context context, HomeAdapterOnClickHandler handler)
    {
        mContext = context;
        mHomeHandler = handler;
    }

    /* RecyclerView를 ViewHolder객체로 인스턴스화 */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.home_list_item;
        LayoutInflater inflater = LayoutInflater.from(context); // itemview를 inflate
        boolean shouldAttachToParentImmediately = false;

        /* 레이아웃을 뷰그룹과 뷰(자바 코드)의 집합으로 바꾸어줌 */
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /* RecyclerView가 데이터 소스에서 가져온 정보를 뷰에 넣을 때 사용 */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Log.d(TAG, "#" + position);
        holder.bind(cultureEventList.get(position));
    }

    /* 데이터 소스의 아이템 개수를 반환 */
    @Override
    public int getItemCount()
    {
        return cultureEventList.size();
    }

    public void setItemList(List<CultureEvent> list)
    {
        cultureEventList.clear();
        cultureEventList.addAll(list);
    }

    public void notifyAdapter()
    {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView listItemImageView;
        TextView listItemTitleView;
        TextView listItemDateView;


        public ViewHolder(final View itemView)
        {
            super(itemView);

            listItemImageView = (ImageView) itemView.findViewById(R.id.homeItemImage);

            itemView.setOnClickListener(this);  // 클릭 이벤트
        }

        public void bind(CultureEvent cultureEvent)
        {
            Picasso.with(itemView.getContext()) // 공연 이미지
                    .load(cultureEvent.getMainImg().toLowerCase())
                    .placeholder(R.drawable.bubble_50dp)
                    .error(R.drawable.smile_50dp)
                    .resize(120, 120)
                    .into(listItemImageView);
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            mCultureEvent = cultureEventList.get(position);
            mHomeHandler.onClick(mCultureEvent);
        }
    }
}
