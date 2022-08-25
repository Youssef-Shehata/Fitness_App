package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Utils.Food;
import com.example.myapplication.Utils.FoodViewModel;
import com.example.myapplication.databinding.ActivityBmiPageBinding;
import com.example.myapplication.databinding.ActivityFoodPageBinding;

public class Food_page extends AppCompatActivity {
    @NonNull
    ActivityFoodPageBinding binding;
//  ImageButton search_btn=(ImageButton) findViewById(R.id.searchButton);
//  EditText search_tx=(EditText) findViewById(R.id.search_tx);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_page);
        binding = ActivityFoodPageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.foodLayout.setVisibility(View.INVISIBLE);
       binding.searchTx.setOnEditorActionListener(editorListner);





    }
    private TextView.OnEditorActionListener editorListner=new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            switch (i)
            {
                case EditorInfo.IME_ACTION_SEARCH:
                    FoodViewModel fModel = new FoodViewModel();
                    fModel = ViewModelProviders.of(Food_page.this ).get(fModel.getClass());
                    //food you wanna search for
                    String searchQuery = binding.searchTx.getText().toString();
                    System.out.println("query:"+searchQuery);
                    fModel.getFood(searchQuery);
                    fModel.food.observe(Food_page.this, new Observer<Food>() {
                        @Override
                        public void onChanged(Food food) {
                            //set Food view element here
                            //test toast
//                        if (food==null)
//                        {
//                            System.out.println("NULL");
//                        }
//                        else
//                        {
//                            System.out.println("not NULL");
//                        }
                            if (food.getItems().length==0){
                                Toast.makeText(Food_page.this,binding.searchTx.getText()+"  doesn't exist !",Toast.LENGTH_SHORT);

                            }
                            else
                            {
                                binding.foodNameTxInfo.setText(food.getItems()[0].getName());
                                binding.protienTxInfo.setText(food.getItems()[0].getProtein_g());
                                binding.calioresTxInfo.setText(food.getItems()[0].getCalories());
                                binding.carbTxInfo.setText(food.getItems()[0].getCarbohydrates_total_g());
                                binding.fatTxInfo.setText(food.getItems()[0].getFat_total_g().toString());
                                binding.servSizeTxInfo.setText(food.getItems()[0].getServing_size_g().toString());
                                binding.foodLayout.setVisibility(View.VISIBLE);
                            }
                        }
                    });
              break;
            }
            return false;
        }
    };


}