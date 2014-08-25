package net.uyghurdev.avaroid.santunush;
import java.util.Random;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

public class Santallash extends Activity implements OnClickListener {
	   int inAnswer=0;
	   lazim lzm=new lazim();
	   int[] iaAnswer = new int[9];
	   private Button bt1;
	   private Button bt2;
	   private Button bt3;
	   private Button bt4;
	   private Button bt5;
	   private Button bt6;
	   private Button bt7;
	   private Button bt8;
	   private Button bt9;
	   private MediaPlayer mMediaPlayer;
	   private boolean sound=true;
	   private ImageButton next;
	   private ImageButton menu;
	   private ImageView imview;
	   private ImageButton ibsantunush;
	   public Handler hand=new Handler();
	 public void onCreate(Bundle savedInstanceState) {
	          super.onCreate(savedInstanceState);
	           requestWindowFeature(Window.FEATURE_NO_TITLE);
		        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	          setContentView(R.layout.santallash);
	          LinearLayout.LayoutParams mParam = new LinearLayout.LayoutParams(     
	                  LinearLayout.LayoutParams.FILL_PARENT,     
	                  LinearLayout.LayoutParams.WRAP_CONTENT     
	          );
	          LinearLayout.LayoutParams mParam2 = new LinearLayout.LayoutParams(     
	                  LinearLayout.LayoutParams.FILL_PARENT,     
	                  LinearLayout.LayoutParams.WRAP_CONTENT     
	          );
	          
	  		DisplayMetrics dm=new DisplayMetrics();  
	          getWindowManager().getDefaultDisplay().getMetrics(dm);  
	          int barHeight;
	          
	          if(dm.heightPixels>1000)
	          {
	          	barHeight=100;
	          	mParam2.height=barHeight+10;
	              mParam2.width=barHeight+15;
	              mParam2.leftMargin=20;
	              mParam2.rightMargin=20;
	          }
	          else if(dm.heightPixels<1000 && dm.heightPixels>600)
	          {
	          	barHeight=dm.heightPixels/10;
	          	mParam2.height=barHeight+10;
	              mParam2.width=barHeight+12;
	              mParam2.leftMargin=15;
	              mParam2.rightMargin=15;
	          }
	          else
	          {
	          	barHeight=64;
	          	mParam2.height=barHeight+2;
	              mParam2.width=barHeight+5;
	              mParam2.leftMargin=10;
	              mParam2.rightMargin=10;
	          }
	          int btnWidth=(dm.widthPixels-20)  /3;
	          mParam.height=barHeight+2;
	          mParam.width=btnWidth-10;
	          mParam.leftMargin=5;
	          mParam.rightMargin=5;
	          
	          init();
	          ibsantunush.setLayoutParams(mParam);
	          next.setLayoutParams(mParam);
	          menu.setLayoutParams(mParam);
	          setBtnParam(bt1,mParam2,lzm.mycolor[0]);
	          setBtnParam(bt2,mParam2,lzm.mycolor[1]);
	          setBtnParam(bt3,mParam2,lzm.mycolor[2]);
	          setBtnParam(bt4,mParam2,lzm.mycolor[3]);
	          setBtnParam(bt5,mParam2,lzm.mycolor[4]);
	          setBtnParam(bt6,mParam2,lzm.mycolor[5]);
	          setBtnParam(bt7,mParam2,lzm.mycolor[6]);
	          setBtnParam(bt8,mParam2,lzm.mycolor[7]);
	          setBtnParam(bt9,mParam2,lzm.mycolor[8]);
	          
		      bt1.setOnClickListener(this);
		      bt2.setOnClickListener(this);
		      bt3.setOnClickListener(this);
		      bt4.setOnClickListener(this);
		      bt5.setOnClickListener(this);
		      bt6.setOnClickListener(this);
		      bt7.setOnClickListener(this);
		      bt8.setOnClickListener(this);
		      bt9.setOnClickListener(this);
		      tNext();
		     
	         ibsantunush.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						Intent tunush = new Intent();
						tunush.setClass(Santallash.this,Santunush.class);
						Santallash.this.startActivity(tunush);
					}
				});
	         next.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						tNext();
					}
				});
	         menu.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						Santallash.this.openOptionsMenu();
					}
				});
	         
	         imview.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						 player(inAnswer-1);
					}
				});
	       
	        
	    }
	 private void init() {
		// TODO Auto-generated method stub
		 ibsantunush = (ImageButton) findViewById(R.id.imbtsuntunush);
         next = (ImageButton) findViewById(R.id.imbtnext);
         menu = (ImageButton) findViewById(R.id.imbtmenu);
         
         
         imview=(ImageView)findViewById(R.id.imvwtsan);
         bt1=(Button)findViewById(R.id.Button01);
         bt2=(Button)findViewById(R.id.Button02);
	      bt3=(Button)findViewById(R.id.Button03);
	      bt4=(Button)findViewById(R.id.Button06);
	      bt5=(Button)findViewById(R.id.Button07);
	      bt6=(Button)findViewById(R.id.Button08);
	      bt7=(Button)findViewById(R.id.Button11);
	      bt8=(Button)findViewById(R.id.Button12);
	      bt9=(Button)findViewById(R.id.Button13);
	}
	public void setBtnParam(Button mBtn, LinearLayout.LayoutParams mParam2,int idx)
		{
			mBtn.setLayoutParams(mParam2);
			 GradientDrawable drawable = (GradientDrawable) this.getResources().getDrawable(R.drawable.shape_normal);
			 drawable.setColor(this.getResources().getColor(idx));
			 drawable.invalidateSelf();
			mBtn.setBackgroundResource(R.drawable.shape_gradient_bg);
			mBtn.setTextSize(mParam2.height/3);
			mBtn.setShadowLayer(2, 0, 0, Color.BLACK);
		}
	 public void onClick(View v) {
		
		if(inAnswer==Integer.valueOf(((Button)v).getText().toString()).intValue())
		//if(v==((Button)v))
		{
		    player(20);
			toast();
		}
		else{
			player(21);
		}
		 
		}
	 
public void toast(){
	Toast toast = new Toast(this); 
    ImageView view = new ImageView(this); 
    view.setImageResource(R.drawable.good);
    toast.setGravity(Gravity.LEFT,0,0);
    toast.setView(view); 
    toast.show();
    hand.postDelayed( new Runnable() {
    public void run() {
	tNext();
	     }
      },2000);
    
}
	 public void tNext()
	 {   
		    int bk=0;
		    Random rndGenerator=new Random();
	        bk=rndGenerator.nextInt(19); 
	        Log.d("Trace",Integer.toString(bk));
	        inAnswer=bk+1;
	        genrateAnswer(bk+1);
	        setnumber();
	        imview.setBackgroundResource(lzm.myimage[bk]);
	        player(bk);
	        Log.d("Trace","tnext end");
	 }
	 public void player(int i)
	 {
		 if(sound==true){
		     if(mMediaPlayer!=null)
		     {
		    	
		       	 mMediaPlayer.release();
		        
		    }
		     mMediaPlayer=MediaPlayer.create(Santallash.this,lzm.mymp3[i]);
	    	 mMediaPlayer.start();
	   }
	else{ mMediaPlayer.stop();
	      }
		 
	 }
	 public void setnumber()
     {
		 bt1.setText(iaAnswer[0]+"");
		 bt2.setText(iaAnswer[1]+"");
		 bt3.setText(iaAnswer[2]+"");
		 bt4.setText(iaAnswer[3]+"");
		 bt5.setText(iaAnswer[4]+"");
		 bt6.setText(iaAnswer[5]+"");
		 bt7.setText(iaAnswer[6]+"");
		 bt8.setText(iaAnswer[7]+"");
		 bt9.setText(iaAnswer[8]+"");
		 
     }
	 private int[] genrateAnswer(int intRightAnswer) {
		
			Random rndGenrator = new Random();
			int intRightAnswerPosition = rndGenrator.nextInt(9);
			for (int nIndex = 0; nIndex < 9; nIndex++)
			{
				if (nIndex == intRightAnswerPosition) 
				{
					iaAnswer[nIndex] = intRightAnswer;// Right Answer Insert
				} 
				else 
				{
					int rnd = rndGenrator.nextInt(20) + 1;
					for (int ndex = 0; ndex < nIndex; ndex++)
					{
						if (iaAnswer[ndex] == rnd||intRightAnswer == rnd)
						{
							rnd = rndGenrator.nextInt(20)+1; 
							ndex = 0;
								
						}
					}
					iaAnswer[nIndex] = rnd;
				}
			}
			return iaAnswer;
		}
	 
	 public boolean onCreateOptionsMenu(Menu menu) { 
		 menu.add(0, 1, 1,"").setIcon(R.drawable.sound);
		 menu.add(0, 2, 2,"توغرىسىدا").setIcon(R.drawable.about_icon); 
		 return super.onCreateOptionsMenu(menu); 
		 
	 };
	 public boolean onOptionsItemSelected(MenuItem item) {
		 // TODO Auto-generated method stub        
		 if(item.getItemId() == 1){            
			 if(sound==true){
					
				    Toast toast = new Toast(this); 
				    ImageView view = new ImageView(this); 
				    view.setImageResource(R.drawable.off);
				    //toast.setGravity(Gravity.CENTER,0,0);
				    toast.setView(view); 
				    toast.show();
				 sound=false;
				 }
			 else
			 {
				 Toast toast = new Toast(this); 
				    ImageView view = new ImageView(this); 
				    view.setImageResource(R.drawable.on);
				   // toast.setGravity(Gravity.CENTER, 0,0);
				    toast.setView(view); 
				    toast.show();
				 sound=true;
			 }
			
			 }        
		 else if(item.getItemId() == 2){
			 
			 About(Santallash.this);
			 }  
	
		 return true; 
		 
		 
		 
		 
		 }
	 private void About(Context context) {  
		 LayoutInflater inflater = LayoutInflater.from(this);  
		    final View textEntryView = inflater.inflate(R.layout.aboutdialog, null); 
		    
		    final TextView about=(TextView)textEntryView.findViewById(R.id.txtabout);
		    about.setText(getResources().getString(R.string.company_name_ug));  
		    final TextView txtlink=(TextView)textEntryView.findViewById(R.id.txtlink);
		    txtlink.setText(getResources().getString(R.string.web_name));  
		    Linkify.addLinks(txtlink, Linkify.ALL);  
		    final AlertDialog.Builder builder = new AlertDialog.Builder(context);  
		       builder.setCancelable(false);  
		       builder.setIcon(R.drawable.avar);  
		       builder.setTitle(getResources().getString(R.string.about_title)); 
		       builder.setMessage(getResources().getString(R.string.version));
		       builder.setView(textEntryView);   
		        /*builder.setPositiveButton("确认",  
		               new DialogInterface.OnClickListener() {  
		                    public void onClick(DialogInterface dialog, int whichButton) {  
		                     setTitle(edtInput.getText());  
		                    }  
		               });  */
		        builder.setNegativeButton("تاقاش",  
		                new DialogInterface.OnClickListener() {  
		             public void onClick(DialogInterface dialog, int whichButton) {  
		                     setTitle("");  
		               }  
		          });  
		     builder.show();  
		   }  
	 
}
