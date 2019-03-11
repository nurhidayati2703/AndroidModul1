package com.example.nurhidayati.parsingvariable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit, btnHapus;
    EditText editNama, editTahun, editAlamat, editTelepon, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        editNama = (EditText)findViewById(R.id.editNama);
        editTahun = (EditText)findViewById(R.id.editTahun);
        editAlamat = (EditText)findViewById(R.id.editAlamat);
        editTelepon = (EditText)findViewById(R.id.editTelepon);
        editEmail = (EditText)findViewById(R.id.editEmail);

        btnHapus.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            editNama.setText("");
            editTahun.setText("");
            editAlamat.setText("");
            editTelepon.setText("");
            editEmail.setText("");
        }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {

            if(editNama.getText().toString().length()==0){
                editNama.setError("Harap isi nama Anda");
            }
            else if(editTahun.getText().toString().length()==0){
                editTahun.setError("Tahun diperlukan");
            }
            else if(editAlamat.getText().toString().length()==0){
                editAlamat.setError("Harap isi alamat Anda");
            }
            else if(editTelepon.getText().toString().length()==0){
                editTelepon.setError("Nomor Telepon diperlukan");
            }
            else if(editEmail.getText().toString().length()==0){
                editEmail.setError("Harap isi email Anda");
            }
            else {
                //jika form sudah terisi semua
                Toast.makeText(getApplicationContext(), "Registrasi Berhasil!",
                        Toast.LENGTH_SHORT).show();

                String nama = editNama.getText().toString();
                String tahun = editTahun.getText().toString();
                String alamat= editAlamat.getText().toString();
                String telepon = editTelepon.getText().toString();
                String email = editEmail.getText().toString();

                Intent i = null;
                i= new Intent(MainActivity.this,Main2Activity.class);
                Bundle b =new Bundle();
                b.putString("parse_nama", nama);
                b.putString("parse_tahun", tahun);
                b.putString("parse_alamat",alamat);
                b.putString("parse_telepon", telepon);
                b.putString("parse_email", email);

                i.putExtras(b);
                startActivity(i);
            }


        }

        });
    }
}
