package com.diozaas.harikedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvUang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG","ini oncreate method");
        Toast.makeText(this, "ini oncreate method", Toast.LENGTH_SHORT).show();

        HitungDuit();
    }

    private void HitungDuit() {
        Double uangTransportHariIni = 25000.0;
        Double uangTransportBesok3Hari = 75000.0;
        Double hasilUangTransportSeluruhnya = uangTransportHariIni + uangTransportBesok3Hari;
        Toast.makeText(this, "Hasil uang transport Rp "+hasilUangTransportSeluruhnya, Toast.LENGTH_SHORT).show();
        tvUang = (TextView)findViewById(R.id.tv_uang);
        tvUang.setText("Hasil uang transport Rp "+hasilUangTransportSeluruhnya);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","ini onstart method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG","ini onrestart method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","ini onresume method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG","ini onpause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG","ini onstop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG","ini destroy method");
    }
}
