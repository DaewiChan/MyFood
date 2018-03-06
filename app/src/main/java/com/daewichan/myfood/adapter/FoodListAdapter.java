package com.daewichan.myfood.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daewichan.myfood.R;
import com.daewichan.myfood.data.FeatureVO;
import com.daewichan.myfood.data.request.FeatureRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by daewichan on 3/6/18.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ItemFoodViewHolder> {
    private List<FeatureVO> featureVOList=new ArrayList<>();

    public FoodListAdapter(){

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
        @BindView(R.id.tv_name)
        TextView tvName;

        public ItemFoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setFood(FeatureVO featureVO){
            tvName.setText(featureVO.getBurppleFeaturedTitle());

        }
    }

    public void addAll( List<FeatureVO> list){
        this.featureVOList=list;
        notifyDataSetChanged();

    }


}
