package net.uyghurdev.avaroid.santunush;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Main extends Activity {
    /** Called when the activity is first created. */
	 public Handler hand=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        
        
        
        
        //LinearLayout layout=new LinearLayout(this);
        //layout=(LinearLayout)findViewById(R.id.lymain);  
        //layout.setOnClickListener(new ImageButton.OnClickListener() {
				//public void onClick(View v) {
					//Intent tunush = new Intent();
					//tunush.setClass(Main.this,Santunush.class);
					//Main.this.startActivity(tunush);
					
			//	}
		//	});
        
        hand.postDelayed( new Runnable() {
	        public void run() {
	        	Intent tunush = new Intent();
				tunush.setClass(Main.this,Santunush.class);
				Main.this.startActivity(tunush);
				Main.this.finish();
	        }
	        },1500);

        
        
    }

	
}