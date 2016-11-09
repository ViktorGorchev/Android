package com.example.admin.test;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private final String TAG_ON_DEBUG = MainActivity.class.getSimpleName();

    private final String EXTRA_TEST_STRING = "Test of data transfer between activities.";

    private Button mCloseActivityButton;

    private Button mSecondActivityButton;

    private Button mCallButton;

    private EditText mtextInputField;

    private Button mgoButton;

    private Button mresultFromSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mCloseActivityButton = (Button) findViewById(R.id.button);
        this.mCloseActivityButton.setOnClickListener(this);

        this.mSecondActivityButton = (Button) findViewById(R.id.button2);
        this.mSecondActivityButton.setOnClickListener(this);

        this.mCallButton = (Button) findViewById(R.id.button3);
        this.mCallButton.setOnClickListener(this);

        this.mtextInputField = (EditText) findViewById(R.id.editText);

        this.mgoButton = (Button) findViewById(R.id.button4);
        this.mgoButton.setOnClickListener(this);

        this.mresultFromSecondActivity = (Button) findViewById(R.id.button6);
        this.mresultFromSecondActivity.setOnClickListener(this);

        Log.d(TAG_ON_DEBUG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_ON_DEBUG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_ON_DEBUG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_ON_DEBUG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_ON_DEBUG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_ON_DEBUG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_ON_DEBUG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.mCloseActivityButton.getId()){
            super.finish();
        }

        if(view.getId() == this.mSecondActivityButton.getId()){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("Extra_name", EXTRA_TEST_STRING);

            Student pesho = new Student(22);
            intent.putExtra("student", pesho);

            startActivity(intent);
        }

        if(view.getId() == this.mCallButton.getId()){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+359123456789"));
            startActivity(intent);
        }

        if(view.getId() == this.mgoButton.getId()){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);

            String inputText = this.mtextInputField.getText().toString();
            intent.putExtra(SearchManager.QUERY, inputText);

            startActivity(intent);
        }

        if(view.getId() == this.mresultFromSecondActivity.getId()){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            startActivityForResult(intent, 500);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 500 && resultCode == RESULT_OK){
            Toast.makeText(this, data.getStringExtra("text_back"), Toast.LENGTH_SHORT).show();
        }
    }
}
