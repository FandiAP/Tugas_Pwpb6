package com.example.tugas_pwpb6_headset;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;



public class HeadsetDetail extends AppCompatActivity implements View.OnClickListener {

    public String EXTRA_NAMA = "NAMA";
    public String EXTRA_HARGA = "HARGA";
    public String EXTRA_DESKRIPSI = "DESKRIPSI";
    public String EXTRA_GAMBAR = "GAMBAR";

    private int total = 0;

    ImageView img_item_Photo;
    Button btnBeli;
    TextView tv_item_Name,tv_harga, tv_Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headsetdetail);

        img_item_Photo = findViewById(R.id.img_item_photo);
        tv_item_Name = findViewById(R.id.tv_item_name);
        tv_harga= findViewById(R.id.tv_harga);
        tv_Desc = findViewById(R.id.tv_desc);
        btnBeli = findViewById(R.id.btnbeli);

        String brand = getIntent().getStringExtra(EXTRA_NAMA);
        Glide.with(this).load(getIntent().getStringExtra(EXTRA_GAMBAR)).into(img_item_Photo);
        String desc = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        String price = getIntent().getStringExtra(EXTRA_HARGA);

        tv_item_Name.setText(brand);
        tv_harga.setText(price);
        tv_Desc.setText(desc);

        Button btnBeli = findViewById(R.id.btnbeli);
        btnBeli.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnbeli:
                Intent moveIntent = new Intent(HeadsetDetail.this, Form.class);
                startActivity(moveIntent);
                break;
        }
    }
}
