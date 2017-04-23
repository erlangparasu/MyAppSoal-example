package com.herokuapp.erlangparasu.myappsoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Tag.MainActivity";

    private int mIndexSoal;
    private ArrayList<Soal> mListSoal;

    private TextView mTxtPilihanA;
    private TextView mTxtPilihanB;

    private Button mBtnJawabA;
    private Button mBtnJawabB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        mTxtPilihanA = (TextView) findViewById(R.id.textview_pilihanA);
        mTxtPilihanB = (TextView) findViewById(R.id.textview_pilihanB);

        mBtnJawabA = (Button) findViewById(R.id.button_jawabA);
        mBtnJawabB = (Button) findViewById(R.id.button_jawabB);

        //

        mIndexSoal = -1;

        //

        mListSoal = new ArrayList<>();

        mListSoal.add(
                new Soal("HTML", "CSS")
        );
        mListSoal.add(
                new Soal("Javascript", "PHP")
        );
        mListSoal.add(
                new Soal("SQL", "Java")
        );

        //

        mBtnJawabA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");

                int indexSoal = mIndexSoal;
                String jawaban = "A";

                jawab(indexSoal, jawaban);
                gantiSoal();
            }
        });
        mBtnJawabB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");

                int indexSoal = mIndexSoal;
                String jawaban = "B";

                jawab(indexSoal, jawaban);
                gantiSoal();
            }
        });

        //

        gantiSoal();
    }

    private void jawab(int indexSoal, String jawaban) {
        Log.d(TAG, "jawab: ");

        int nomorSoal = indexSoal + 1;

        Toast.makeText(
                this,
                "soalNomor=" + String.valueOf(nomorSoal) + ", dijawab=" + jawaban,
                Toast.LENGTH_SHORT
        ).show();

        // Lakukan tindakan selanjutnya
        // ...
    }

    private void gantiSoal() {
        Log.d(TAG, "gantiSoal: ");

        mIndexSoal++;

        int nomorSoal = mIndexSoal + 1;
        int jumlahSoal = mListSoal.size();

        if (nomorSoal <= jumlahSoal) {
            // Masih ada soal selanjutnya

            Soal soal = mListSoal.get(mIndexSoal);

            mTxtPilihanA.setText(
                    "A: " + soal.pilihanA
            );
            mTxtPilihanB.setText(
                    "B: " + soal.pilihanB
            );
        } else {
            // Soal sudah habis

            mIndexSoal = -1;

            mTxtPilihanA.setText(
                    "Terima"
            );
            mTxtPilihanB.setText(
                    "Kasih"
            );

            mBtnJawabA.setVisibility(View.GONE);
            mBtnJawabB.setVisibility(View.GONE);

            Toast.makeText(
                    this,
                    "Selesai",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
