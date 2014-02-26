package com.sovejo.lexdroidejemplonotificaciones;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements android.view.View.OnClickListener 
{
	Button boton;
	NotificationManager notMan;
	static final int unico = 4500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		boton = (Button) findViewById(R.id.boton);
		boton.setOnClickListener(this);
		
		notMan = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		notMan.cancel(unico);
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent penint = PendingIntent.getActivity(this, 0, intent, 0);
		
		String aviso = "Notificacion";
		String texto = "S?? ha funcionado";
		
		Notification notification = new Notification(R.drawable.ic_launcher, aviso, System.currentTimeMillis());
		notification.setLatestEventInfo(this, texto, aviso, penint);
		notification.defaults = Notification.DEFAULT_ALL;
		
		notMan.notify(unico, notification);
		
		finish();
	}
}
