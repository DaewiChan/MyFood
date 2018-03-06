package com.daewichan.myfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.daewichan.myfood.adapter.FoodListAdapter;
import com.daewichan.myfood.data.FeatureResponse;
import com.daewichan.myfood.data.FeatureVO;
import com.daewichan.myfood.data.remote.ApiService;
import com.daewichan.myfood.data.remote.AppUtility;
import com.daewichan.myfood.data.request.FeatureRequest;
import com.daewichan.myfood.delegate.FoodItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListActivity extends AppCompatActivity implements FoodItemDelegate {
    @BindView(R.id.rv_food_list)
    RecyclerView rvFoodList;

    private FoodListAdapter foodListAdapter;

    private ApiService mApiService;

    private List<FeatureVO> featureVOList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        ButterKnife.bind(this);

        mApiService= AppUtility.getService();

        foodListAdapter=new FoodListAdapter(this);
        rvFoodList.setAdapter(foodListAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvFoodList.setLayoutManager(linearLayoutManager);

        getFeature();
    }

    private void getFeature(){
        mApiService.getFood(1,"b002c7e1a528b7cb460933fc2875e916").enqueue(new Callback<FeatureResponse>() {
            @Override
            public void onResponse(Call<FeatureResponse> call, Response<FeatureResponse> response) {
                if (response.isSuccessful()){
                    Log.d("feautre_response",response.body().getMessage());
                    featureVOList = response.body().getFeatured();
                    foodListAdapter.addAll(response.body().getFeatured());
                }
            }

            @Override
            public void onFailure(Call<FeatureResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public void onTapItem(int position) {
        Intent intent=DetailsActivity.newIntent(getApplicationContext());

        intent.putExtra("food_img",featureVOList.get(position).getBurppleFeaturedImage());
        intent.putExtra("food_name",featureVOList.get(position).getBurppleFeaturedTitle());

        startActivity(intent);
    }
}
