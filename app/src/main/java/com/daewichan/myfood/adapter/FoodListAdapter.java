package com.daewichan.myfood.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daewichan.myfood.R;
import com.daewichan.myfood.data.FeatureVO;
import com.daewichan.myfood.data.request.FeatureRequest;
import com.daewichan.myfood.delegate.FoodItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by daewichan on 3/6/18.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ItemFoodViewHolder> {
    private List<FeatureVO> featureVOList=new ArrayList<>();

    private FoodItemDelegate foodItemDelegate;

    public FoodListAdapter(FoodItemDelegate foodItemDelegate){
        this.foodItemDelegate=foodItemDelegate;

    }

    @Override
    public ItemFoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_list,parent,false);

        ItemFoodViewHolder itemFoodViewHolder=new ItemFoodViewHolder(view);
        return itemFoodViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemFoodViewHolder holder, int position) {
        holder.setFood(featureVOList.get(position));
        holder.setEvent(position);
    }

    @Override
    public int getItemCount() {
        if(featureVOList.size()>0){
            return featureVOList.size();
        }
        else{
            return 0;
        }
    }

    public class ItemFoodViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cv_food_list)
        CardView cardView;

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.iv_food)
        ImageView ivFood;

//        @OnClick(R.id.cv_food_list)
//        public void onTapDetails(View view){
//            foodItemDelegate.onTapItem();
//        }

        public ItemFoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        public void setFood(FeatureVO featureVO){
            tvName.setText(featureVO.getBurppleFeaturedTitle());

            Glide.with(ivFood.getContext())
                    .load(featureVO.getBurppleFeaturedImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivFood);

//            if (featureVO.getBurppleFeaturedImage() != null) {
//                ivFood.setVisibility(View.VISIBLE);
//                Glide.with(ivFood.getContext())
//                        .load(featureVO.getBurppleFeaturedImage())
//                        .into(ivFood);
//            } else {
//                ivFood.setVisibility(View.GONE);
//            }

        }

        public void setEvent(final int position){
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    foodItemDelegate.onTapItem(position);
                }
            });
        }

    }

    public void addAll( List<FeatureVO> list){
        this.featureVOList=list;
        notifyDataSetChanged();

    }




}
