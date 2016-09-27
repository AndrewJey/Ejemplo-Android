package com.example.soporte.botoneseventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buton;
    int cantidad = 0;
    RelativeLayout view;
    float downXValue = 0;
    float downYValue = 0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buton = (Button) findViewById(R.id.button);
        view = (RelativeLayout) findViewById(R.id.view);
        text = (TextView) findViewById(R.id.textView);
        Eventos();
    }

    public void Eventos() {
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = cantidad + 1;
                Toast.makeText(getApplicationContext(), "Se presiono el boton " + cantidad + "veces", Toast.LENGTH_SHORT).show();
            }
        });
        buton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Se presiono el boton mucho tiempo", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // store the X value when the user's finger was pressed down
                        downXValue = event.getX();
                        downYValue = event.getY();
                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        // Get the X value when the user released his/her finger
                        float currentX = event.getX();
                        float currentY = event.getY();
                        // check if horizontal or vertical movement was bigger

                        if (Math.abs(downXValue - currentX) > Math.abs(downYValue
                                - currentY)) {
                            // going backwards: pushing stuff to the right
                            if (downXValue < currentX) {
                                text.setText("right");

                            }
                            // going forwards: pushing stuff to the left
                            if (downXValue > currentX) {
                                text.setText("left");
                            }
                        } else {
                            if (downYValue < currentY) {
                                text.setText("down");
                            }
                            if (downYValue > currentY) {
                                text.setText("up");
                            }
                        }
                        break;
                    }

                }
                return true;
            }
        });
    }
}
