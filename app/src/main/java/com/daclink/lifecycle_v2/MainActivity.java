package com.daclink.lifecycle_v2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daclink.lifecycle_v2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "LifeCycleDemo";
  private static final String BUTTON_STATE = "ButtonState";

  ActivityMainBinding binding;

  Button button;
  TextView mTextView;
  boolean messageOne = false;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate(Bundle) called");
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());

    if (savedInstanceState != null) {
      messageOne = savedInstanceState.getBoolean(BUTTON_STATE, true);
    }

    button = binding.button;
    mTextView = binding.textView;
    getMessage();

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        messageOne = !messageOne;
        getMessage();
      }
    });

    //TODO: add long click listener

  }

  private void getMessage() {
    if (messageOne) {
      mTextView.setText(R.string.message2);
    } else {
      mTextView.setText(R.string.message1);
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    Log.d(TAG, "onStart() called");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(TAG, "onResume() called");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d(TAG, "onPause() called");
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    Log.i(TAG, "onSaveInstanceState called");
    savedInstanceState.putBoolean(BUTTON_STATE, messageOne);
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d(TAG, "onStop() called");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy() called");
  }
}
