package livro.com.br;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

    public static final String EXTRA_PACKAGE_NAME="livro.com.br";
    private static final int START_STICKY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("Notificação");
            String channelId = getString(R.string.Channel_ID);
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(channelId);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        return true;
    }

    public void mostrarPermissao(View view){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
    }

    public void mostrarcamera(View view){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);

            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(camera);
    }

    public int mostrarNotificacao(View view){
        if (createNotificationChannel() == true){

            String channelID = getString(R.string.Channel_ID);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Notificação foi Chamado")
                    .setContentText("ola, vc me chamou?")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

            Notification n = builder.build();
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.notify("", 0, n);
        }else
            return START_STICKY;

        return  START_STICKY;
    }

    public void mostrarConfiguracao(View view){
        Intent config = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity (config);

    }

    public void segundarela(View view){
        Intent tela2 = new Intent(this, Activity_2.class);
        startActivity(tela2);
    }



}
