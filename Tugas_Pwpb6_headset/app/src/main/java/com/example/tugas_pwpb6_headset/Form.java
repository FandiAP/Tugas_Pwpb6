package com.example.tugas_pwpb6_headset;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {
    Button asimpan;
    EditText anama, aAlamat;
    RadioGroup akurir, apembayaran;
    TextView ahasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        asimpan = (Button) findViewById(R.id.simpan);
        anama = (EditText) findViewById(R.id.isinama);
        aAlamat = (EditText) findViewById(R.id.isialamat);
        apembayaran = (RadioGroup) findViewById(R.id.pembayaran);
        akurir = (RadioGroup) findViewById(R.id.kurir);
        ahasil = (TextView) findViewById(R.id.hasil);

        asimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputnama = String.valueOf(anama.getText().toString());
                String inputalamat = String.valueOf(aAlamat.getText().toString());

                int kurir = akurir.getCheckedRadioButtonId();
                RadioButton akurir = (RadioButton) findViewById(kurir);
                String input = String.valueOf(akurir.getText().toString());

                int pembayaran = apembayaran.getCheckedRadioButtonId();
                RadioButton apembayaran = (RadioButton) findViewById(pembayaran);
                String bayar = String.valueOf(apembayaran.getText().toString());

                ahasil.setText("\n" + "Nama : " + inputnama +"\n"+"Alamat Pembeli : "+inputalamat+"\n"+
                        "Kurir : " + input +"\n"+ "Metode Pembayaran : "+bayar+"\n" );

            }
        });



    }

}

