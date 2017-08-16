package com.sergeivasilenko.livedataremoveobserverissue;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created on 16.08.17.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class MainViewModel extends ViewModel {

	private static final MutableLiveData<String> mText = new MutableLiveData<>();

	public MainViewModel() {

	}

	public LiveData<String> getText() {
		return mText;
	}

	public void setText(String text) {
		mText.setValue(text);
	}
}
