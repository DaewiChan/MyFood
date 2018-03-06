package com.daewichan.myfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.daewichan.myfood.adapter.FoodListAdapter;
import com.daewichan.myfood.data.FeatureResponse;
import com.daewichan.myfood.data.remote.ApiService;
import com.daewichan.myfood.data.remote.AppUtility;
import com.daewichan.myfood.data.request.FeatureRequest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListActivity extends AppCompatActivity {
    @BindView(R.id.rv_food_list)
    RecyclerView rvFoodList;

    private FoodListAdapter foodListAdapter;

    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        ButterKnife.bind(this);

        mApiService= AppUtility.getService();

        foodListAdapter=new FoodListAdapter();
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
                    foodListAdapter.addAll(response.body().getFeatured());
                }
            }

            @Override
            public void onFailure(Call<FeatureResponse> call, Throwable t) {

            }
        });
    }


}
