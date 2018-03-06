package com.daewichan.myfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private String foodImage;
    private String foodTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.iv_details)
    ImageView ivDetail;

    @BindView(R.id.tv_details_name)
    TextView tvDetailName;


    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,DetailsActivity.class);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodImage = getIntent().getStringExtra("food_img");
        foodTitle = getIntent().getStringExtra("food_name");

        showData();
    }

    private void showData(){
        Glide.with(ivDetail.getContext())
                .load(foodImage)
                .placeholder(R.mipmap.ic_launcher)
                .into(ivDetail);

        tvDetailName.setText(foodTitle);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
