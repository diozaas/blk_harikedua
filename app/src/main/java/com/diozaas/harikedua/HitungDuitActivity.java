package com.diozaas.harikedua;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HitungDuitActivity extends AppCompatActivity {

    // buat variabel global
    EditText edtNilaiPertama, edtNilaiKedua;
    Button btnHitung;
    TextView tvHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitung_duit);
        // inisialisasi
        edtNilaiPertama = (EditText)findViewById(R.id.edt_nilai_pertama);
        edtNilaiKedua = (EditText)findViewById(R.id.edt_nilai_kedua);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        tvHasil = (TextView)findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungHitungDuit();
//                Toast.makeText(HitungDuitActivity.this, "Cek button", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void hitungHitungDuit() {
        String ambilNilaiPertama = edtNilaiPertama.getText().toString();
        String ambilNilaiKedua = edtNilaiKedua.getText().toString();

        if(ambilNilaiPertama.isEmpty() || ambilNilaiKedua.isEmpty()) {
            Toast.makeText(this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else {
            Double hasil = Double.valueOf(ambilNilaiPertama) + Double.valueOf(ambilNilaiKedua);
            tvHasil.setText("Hasil "+hasil);

            // dialog
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(HitungDuitActivity.this);

            // attribute title dan message
            alertDialog.setTitle("Hasil dari penjumlahan");
            alertDialog.setMessage("Hasilnya adalah "+hasil);
            alertDialog.setCancelable(false);

            // munculkan positif button
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    edtNilaiPertama.setText("");
                    edtNilaiKedua.setText("");
                }
            });

            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    // intent punya dua parameter ( context/activity dia berasal, pindah kemana ? )
                    Intent pindahKeActivityLain = new Intent(HitungDuitActivity.this, WebViewActivity.class);
                    // di start activity
                    startActivity(pindahKeActivityLain);
                }
            });

            alertDialog.show();

        }
    }

}
