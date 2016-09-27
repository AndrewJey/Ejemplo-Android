package com.example.soporte.togglebutton;

import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    TextView text;
    Thread thread;
    Timer timer;
    String Strtext = "Hola Mundo \n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggleButton.isChecked()) {
                    timer = new Timer(true);
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            Ejectar();
                        }
                    };
                    timer.schedule(timerTask, 1000, 1000);
                } else {
                    timer.cancel();
                    Strtext = "";
                    text.setText(Strtext);
                }
            }
        });

    }

    public void Ejectar() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Strtext = Strtext + "Prueba de texto" + "\n";
                                text.setText(Strtext);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
