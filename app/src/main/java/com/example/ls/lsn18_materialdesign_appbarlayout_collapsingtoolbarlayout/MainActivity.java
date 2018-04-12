package com.example.ls.lsn18_materialdesign_appbarlayout_collapsingtoolbarlayout;

import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity implements HideScrollListener{

	private RecyclerView recyclerview;
	private ImageButton fab;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
		fab = findViewById(R.id.fab);
		
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		recyclerview.setLayoutManager(new LinearLayoutManager(this));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			list.add("Item"+i);
		}
		Adapter adapter = new FabRecyclerAdapter(list );
		recyclerview.setAdapter(adapter );
		
	}

	public void rotate(View v){
		Snackbar.make(v, "确定哦", Snackbar.LENGTH_SHORT)
				.setAction("点我呀", new OnClickListener() {
					
					@Override
					public void onClick(View v) {
					}
				})
				.show();
	}
	
	@Override
	public void onHide() {
		toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
		LayoutParams layoutParams = (LayoutParams) fab.getLayoutParams();
		
		fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
	}

	@Override
	public void onShow() {
		toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

		LayoutParams layoutParams = (LayoutParams) fab.getLayoutParams();
		fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

	}

}
