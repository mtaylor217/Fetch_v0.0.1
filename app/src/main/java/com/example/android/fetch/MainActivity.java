/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.fetch;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toolbar;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView listViewBrand;
    CustomAdapter adapterBrand;
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        //Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if( id == R.id.action_user) {
            Intent accountIntent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(accountIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_recycler);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        RelativeLayout recyclerItem = findViewById(R.id.recycler_item);

        /**recyclerItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
        Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
        startActivity(numbersIntent);
            }
        });**/

        final ArrayList<Word> wordsBrand = new ArrayList<>();
        wordsBrand.add(new Word("Aldi", R.drawable.color_red));
        wordsBrand.add(new Word("Asda", R.drawable.color_green));
        wordsBrand.add(new Word("Tesco", R.drawable.color_brown));
        wordsBrand.add(new Word("Morrisons", R.drawable.color_gray));
        wordsBrand.add(new Word("Lidl", R.drawable.color_black));
        wordsBrand.add(new Word("Costcutter",R.drawable.color_white));
        wordsBrand.add(new Word("Spar", R.drawable.color_dusty_yellow));
        wordsBrand.add(new Word("OneShop", R.drawable.color_mustard_yellow));

        adapterBrand = new CustomAdapter(this, wordsBrand, R.color.category_brand);

        LinearLayoutManager layoutManagerBrand = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listViewBrand = (RecyclerView) findViewById(R.id.list_brand);
        listViewBrand.setLayoutManager(layoutManagerBrand);

        listViewBrand.setAdapter(adapterBrand);

        final ArrayList<Word> wordsItemType = new ArrayList<Word>();
        wordsItemType.add(new Word("Shirt", R.drawable.color_red));
        wordsItemType.add(new Word("Shorts", R.drawable.color_green));
        wordsItemType.add(new Word("Skirt", R.drawable.color_brown));
        wordsItemType.add(new Word("Dress", R.drawable.color_gray));
        wordsItemType.add(new Word("Shoes", R.drawable.color_black));
        wordsItemType.add(new Word("Hats",R.drawable.color_white));
        wordsItemType.add(new Word("Belts", R.drawable.color_dusty_yellow));
        wordsItemType.add(new Word("Food", R.drawable.color_mustard_yellow));

        CustomAdapter adapterItemType = new CustomAdapter(this, wordsItemType, R.color.category_item_type);

        LinearLayoutManager layoutManagerItemType = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView listViewItemType = (RecyclerView) findViewById(R.id.list_item_type);
        listViewItemType.setLayoutManager(layoutManagerItemType);

        listViewItemType.setAdapter(adapterItemType);

        final ArrayList<Word> wordsColors = new ArrayList<Word>();
        wordsColors.add(new Word("Red", R.drawable.color_red));
        wordsColors.add(new Word("Green", R.drawable.color_green));
        wordsColors.add(new Word("Brown", R.drawable.color_brown));
        wordsColors.add(new Word("Grey", R.drawable.color_gray));
        wordsColors.add(new Word("Black", R.drawable.color_black));
        wordsColors.add(new Word("White",R.drawable.color_white));
        wordsColors.add(new Word("Dust", R.drawable.color_dusty_yellow));
        wordsColors.add(new Word("Yellow", R.drawable.color_mustard_yellow));

        CustomAdapter adapterColors = new CustomAdapter(this, wordsColors, R.color.category_colors);

        LinearLayoutManager layoutManagerColors = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView listViewColors = (RecyclerView) findViewById(R.id.list_colors);
        listViewColors.setLayoutManager(layoutManagerColors);

        listViewColors.setAdapter(adapterColors);

        final ArrayList<Word> wordsDeliveryTime = new ArrayList<Word>();
        wordsDeliveryTime.add(new Word("10 mins", R.drawable.color_red));
        wordsDeliveryTime.add(new Word("20 mins", R.drawable.color_green));
        wordsDeliveryTime.add(new Word("30 mins", R.drawable.color_brown));
        wordsDeliveryTime.add(new Word("1 hour", R.drawable.color_gray));
        wordsDeliveryTime.add(new Word("2 hours", R.drawable.color_black));
        wordsDeliveryTime.add(new Word("6 hours",R.drawable.color_white));
        wordsDeliveryTime.add(new Word("Today", R.drawable.color_dusty_yellow));
        wordsDeliveryTime.add(new Word("Tomorrow", R.drawable.color_mustard_yellow));

        CustomAdapter adapterDeliveryTime = new CustomAdapter(this, wordsDeliveryTime, R.color.category_delivery_time);

        LinearLayoutManager layoutManagerDeliveryTime = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView listViewDeliveryTime = (RecyclerView) findViewById(R.id.list_delivery_time);
        listViewDeliveryTime.setLayoutManager(layoutManagerDeliveryTime);

        listViewDeliveryTime.setAdapter(adapterDeliveryTime);


    }

}
