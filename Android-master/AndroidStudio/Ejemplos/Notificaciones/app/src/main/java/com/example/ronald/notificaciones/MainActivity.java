package com.example.ronald.notificaciones;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText editTextMensaje;
    Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMensaje = (EditText)findViewById(R.id.editTextMensaje);
        btnEnviar= (Button)findViewById(R.id.buttonEnviar);
        btnEnviar.setOnClickListener(this);

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void Notificar(){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this);
        notifyBuilder.setSmallIcon(R.drawable.pumbaaicon);
        notifyBuilder.setContentTitle("Notifiacion");
        notifyBuilder.setContentText(editTextMensaje.getText());
        Intent resultIntent = new Intent(this, MainActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        notifyBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(getTaskId(), notifyBuilder.build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEnviar:
                Notificar();
                editTextMensaje.setText("");
        }
    }
}
