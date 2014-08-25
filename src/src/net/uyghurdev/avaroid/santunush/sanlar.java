package net.uyghurdev.avaroid.santunush;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class sanlar extends Activity {
	lazim lzm = new lazim();
	private ImageView imvw;
	private ImageView bek;
	private MediaPlayer mMediaPlayer;
	private boolean sound = true;
	private int i = 0;
	private int n = 0;
	public Context context;
	public Handler hand = new Handler();
	public String str[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.sanlar);
		imvw = (ImageView) findViewById(R.id.imvw);
		bek = (ImageView) findViewById(R.id.imvwbek);

		imvw.setOnClickListener(new ImageView.OnClickListener() {
			public void onClick(View v) {

				if (n > 11) {
					n = 0;
				}
				// text.setTextColor(lzm.mycolor[i]);
				if (i > 19) {
					i = 0;
				}
				// text.setText(str[i]);
				// text.setTextColor(70);
				imvw.setBackgroundResource(lzm.mynumber[i]);
				player(i);
				Bitmap newb = Bitmap.createBitmap(300, 300, Config.ARGB_8888);
				Canvas canvasTemp = new Canvas(newb);
				canvasTemp.drawColor(Color.TRANSPARENT);
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(lzm.color[n]);
				paint.setStyle(Paint.Style.FILL);
				paint.setStrokeWidth(1);
				canvasTemp.drawCircle(160, 140, 140, paint);
				Drawable drawable = new BitmapDrawable(newb);
				bek.setBackgroundDrawable(drawable);
				n++;
				i++;
			}
		});

	}

	public void player(int i) {
		if (sound == true) {
			if (mMediaPlayer != null) {
				
					mMediaPlayer.release();
				
			}
			mMediaPlayer = MediaPlayer.create(sanlar.this, lzm.mymp3[i]);
			mMediaPlayer.start();
		} else if (sound == false) {
			if (mMediaPlayer != null) {

				mMediaPlayer.stop();
			}
		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, "قايتىش");

		return super.onCreateOptionsMenu(menu);

	};

	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == 1) {
			Intent main = new Intent();
			main.setClass(sanlar.this, Santunush.class);
			sanlar.this.startActivity(main);
		}
		return true;
	};
}