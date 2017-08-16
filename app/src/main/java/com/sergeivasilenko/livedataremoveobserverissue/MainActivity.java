package com.sergeivasilenko.livedataremoveobserverissue;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {

	private TextView mTextView1;
	private TextView mTextView2;

	private MainViewModel mMainViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextView1 = findViewById(R.id.text1);
		mTextView2 = findViewById(R.id.text2);

		mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
		mMainViewModel.getText().observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				mTextView1.setText(s);
				mMainViewModel.getText().removeObserver(this);
			}
		});
		mMainViewModel.getText().observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				// it will not be called first time
				mTextView2.setText(s);
			}
		});

		findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mMainViewModel.setText("Started");
			}
		});
	}
}
