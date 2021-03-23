package com.example.android.fetch;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageView fetchProfilePicture = (ImageView) findViewById(R.id.profile_picture);
        fetchProfilePicture.setImageResource(R.drawable.color_mustard_yellow);
    }

}
