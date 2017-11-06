package com.example.irfan.kalkulatorgeometry_uts;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPil;
    private EditText inputan1, inputan2;
    private Button buttonHit;
    private TextView luas, keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerPil = (Spinner) findViewById(R.id.spinnerPilihan);
        inputan1 = (EditText) findViewById(R.id.input1);
        inputan2 = (EditText) findViewById(R.id.input2);
        buttonHit = (Button) findViewById(R.id.buttonHitung);
        luas = (TextView) findViewById(R.id.luas);
        keliling = (TextView) findViewById(R.id.keliling);


        buttonHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input1 = inputan1.getText().toString().trim();
                String input2 = inputan2.getText().toString().trim();

                int A = Integer.parseInt(input1);
                int B = Integer.parseInt(input2);

                double Luas = 0;
                double Keliling = 0;

                if (spinnerPil.getSelectedItem().toString().equals("Persegi_Panjang")) {
                    Luas = A * B;
                    Keliling = (2 * A) + (2 * B);
                } else if (spinnerPil.getSelectedItem().toString().equals("Lingkaran")) {
                    Luas = Math.PI * Math.pow(A,2);
                    Keliling = Math.PI * (2 * A);
                } else {
                    Luas = (A * B) / 2;
                    Keliling = (A + B + (Math.sqrt((Math.pow(A,2)) + (Math.pow(B,2)))));
                }
                luas.setText("Luas \t\t\t= " + Luas);
                keliling.setText("Keliling \t= " + Keliling);

            }
        });
    }

    public void tampilNotif (View view) {
        NotificationManagerCompat managerKu = NotificationManagerCompat.from(this);
        NotificationCompat.Builder notifKu = new NotificationCompat.Builder(this);

        notifKu.setContentTitle("Hasil Kalkulasi");
        notifKu.setContentText("Cek sekarang !");
        notifKu.setSmallIcon(android.R.drawable.ic_menu_agenda);

        Intent i1 = new Intent(this,MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this,1,i1,0);
        notifKu.setContentIntent(pd);
        notifKu.setAutoCancel(true);

        managerKu.notify(1,notifKu.build());
        finish();
    }
}
