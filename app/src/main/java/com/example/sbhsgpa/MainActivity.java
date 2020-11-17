package com.example.sbhsgpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] results = new int[8];
    String[] course = {"Regular", "Honors", "AP"};
    String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
    Spinner g1, g2, g3, g4, g5, g6, g7, g8;
    Spinner c1, c2, c3, c4, c5, c6, c7, c8;
    Button remove,add,resetall,resetgrade;
    int pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8;
    int p1, p2, p3, p4, p5, p6, p7, p8;
    TextView wgpa, uwgpa;
    int current = 8;
    TextView t1, t2, t3, t4, t5, t6, t7, t8;
    double[] reg = {4.0, 3.67, 3.33, 3, 2.67, 2.33, 2, 1.67, 1, 0,};
    double[] honors = {4.5, 4.17, 3.83, 3.50, 3.17, 2.83, 2.5, 2.17, 1, 0};
    double[] ap = {5, 4.67, 4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 1.00, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (Spinner) findViewById(R.id.c1);
        c2 = (Spinner) findViewById(R.id.c2);
        c3 = (Spinner) findViewById(R.id.c3);
        c4 = (Spinner) findViewById(R.id.c4);
        c5 = (Spinner) findViewById(R.id.c5);
        c6 = (Spinner) findViewById(R.id.c6);
        c7 = (Spinner) findViewById(R.id.c7);
        c8 = (Spinner) findViewById(R.id.c8);
        g1 = (Spinner) findViewById(R.id.g1);
        g2 = (Spinner) findViewById(R.id.g2);
        g3 = (Spinner) findViewById(R.id.g3);
        g4 = (Spinner) findViewById(R.id.g4);
        g5 = (Spinner) findViewById(R.id.g5);
        g6 = (Spinner) findViewById(R.id.g6);
        g7 = (Spinner) findViewById(R.id.g7);
        g8 = (Spinner) findViewById(R.id.g8);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);
        t7 = (TextView) findViewById(R.id.textView7);
        t8 = (TextView) findViewById(R.id.textView8);
        remove = (Button) findViewById(R.id.remove);
        add = (Button) findViewById(R.id.add);
        wgpa = (TextView) findViewById(R.id.txtweight);
        uwgpa = (TextView) findViewById(R.id.txtunweight);
        resetall = (Button) findViewById(R.id.resetall);
        resetgrade = (Button) findViewById(R.id.button4);

        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rstall();
            }
        });

        resetgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rstgrades();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current > 4){
                    current--;
                    reshow();
                    calculate();
                } else {
                    Toast.makeText(MainActivity.this, "No less than 4 classes", Toast.LENGTH_SHORT).show();
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current < 8){//suspected cause of error
                    current++;
                    reshow();
                    calculate();
                } else {
                    Toast.makeText(MainActivity.this, "No more than 8 classes", Toast.LENGTH_SHORT).show();
                }
            }
        });


        c1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p1 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p2 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p3 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p4 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c5.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p5 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c6.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p6 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c7.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p7 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c8.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p8 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, course);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c1.setAdapter(a);
        c2.setAdapter(a);
        c3.setAdapter(a);
        c4.setAdapter(a);
        c5.setAdapter(a);
        c6.setAdapter(a);
        c7.setAdapter(a);
        c8.setAdapter(a);

        g1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos1 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos2 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos3 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos4 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g5.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos5 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g6.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos6 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g7.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos7 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        g8.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos8 = position;
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, grades);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        g1.setAdapter(aa);
        g2.setAdapter(aa);
        g3.setAdapter(aa);
        g4.setAdapter(aa);
        g5.setAdapter(aa);
        g6.setAdapter(aa);
        g7.setAdapter(aa);
        g8.setAdapter(aa);

    }
    public void calculate() {
        double wg = 0;/////////////fix 1-4 responses not changing it. Changing course weightage doesn't change GPA
        if(current > 0){
            if(p1 == 0){
                wg+=reg[pos1];
            } else if(p1==1){
                wg+=honors[pos1];
            } else if(p1==2){
                wg+=ap[pos1];
            }
        }
        if(current > 1){
            if(p2 == 0){
                wg+=reg[pos2];
            } else if(p2==1){
                wg+=honors[pos2];
            } else if(p2==2){
                wg+=ap[pos2];
            }
        }

        if(current > 2){
            if(p3 == 0){
                wg+=reg[pos3];
            } else if(p3==1){
                wg+=honors[pos3];
            } else if(p3==2){
                wg+=ap[pos3];
            }
        }
        if(current > 3){
            if(p4 == 0){
                wg+=reg[pos4];
            } else if(p4==1){
                wg+=honors[pos4];
            } else if(p4==2){
                wg+=ap[pos4];
            }
        }
        if(current > 4){
            if(p5==0){
                wg+=reg[pos5];
            } else if(p5 == 1){
                wg+=honors[pos5];
            } else if(p5==2){
                wg+=ap[pos5];
            }
        }

        if(current > 5){
            if(p6==0){
                wg+=reg[pos6];
            } else if(p6 == 1){
                wg+=honors[pos6];
            } else if(p6==2){
                wg+=ap[pos6];
            }
        }
        if(current > 6){
            if(p7==0){
                wg+=reg[pos7];
            } else if(p7 == 1){
                wg+=honors[pos7];
            } else if(p7==2){
                wg+=ap[pos7];
            }
        }
        if(current > 7){
            if(p8==0){
                wg+=reg[pos8];
            } else if(p8 == 1){
                wg+=honors[pos8];
            } else if(p8==2){
                wg+=ap[pos8];
            }
        }
        wg/=current;
        wgpa.setText("Weighted GPA: " + wg);

        double uwg = 0;
        uwg+=reg[pos1];
        uwg+=reg[pos2];
        uwg+=reg[pos3];
        uwg+=reg[pos4];
        if(current > 4){
            uwg+=reg[pos5];
        }
        if(current > 5){
            uwg+=reg[pos6];
        }
        if(current > 6){
            uwg+=reg[pos7];
        }
        if(current > 7){
            uwg+=reg[pos8];
        }
        uwg/=current;
        uwgpa.setText("Unweighted GPA: " + uwg);

    }
    public void reshow() {
        g1.setVisibility(View.VISIBLE);
        c1.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        g2.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        g3.setVisibility(View.VISIBLE);
        c3.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        g4.setVisibility(View.VISIBLE);
        c4.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        g5.setVisibility(View.VISIBLE);
        c5.setVisibility(View.VISIBLE);
        t5.setVisibility(View.VISIBLE);
        g6.setVisibility(View.VISIBLE);
        c6.setVisibility(View.VISIBLE);
        t6.setVisibility(View.VISIBLE);
        g7.setVisibility(View.VISIBLE);
        c7.setVisibility(View.VISIBLE);
        t7.setVisibility(View.VISIBLE);
        g8.setVisibility(View.VISIBLE);
        c8.setVisibility(View.VISIBLE);
        t8.setVisibility(View.VISIBLE);
        if(current == 4){
            g5.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            t5.setVisibility(View.GONE);
            g6.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
            t6.setVisibility(View.GONE);
            g7.setVisibility(View.GONE);
            c7.setVisibility(View.GONE);
            t7.setVisibility(View.GONE);
            g8.setVisibility(View.GONE);
            c8.setVisibility(View.GONE);
            t8.setVisibility(View.GONE);
        } else if(current == 5){
            g6.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
            t6.setVisibility(View.GONE);
            g7.setVisibility(View.GONE);
            c7.setVisibility(View.GONE);
            t7.setVisibility(View.GONE);
            g8.setVisibility(View.GONE);
            c8.setVisibility(View.GONE);
            t8.setVisibility(View.GONE);
        } else if(current == 6){
            g7.setVisibility(View.GONE);
            c7.setVisibility(View.GONE);
            t7.setVisibility(View.GONE);
            g8.setVisibility(View.GONE);
            c8.setVisibility(View.GONE);
            t8.setVisibility(View.GONE);
        } else if(current == 7){
            g8.setVisibility(View.GONE);
            c8.setVisibility(View.GONE);
            t8.setVisibility(View.GONE);
        }
    }
    public void rstall() {
        current = 8;
        reshow();
        rstgrades();
        c1.setSelection(0);
        c2.setSelection(0);
        c3.setSelection(0);
        c4.setSelection(0);
        c5.setSelection(0);
        c6.setSelection(0);
        c7.setSelection(0);
        c8.setSelection(0);

    }
    public void rstgrades() {
        g1.setSelection(0);
        g2.setSelection(0);
        g3.setSelection(0);
        g4.setSelection(0);
        g5.setSelection(0);
        g6.setSelection(0);
        g7.setSelection(0);
        g8.setSelection(0);
    }
}