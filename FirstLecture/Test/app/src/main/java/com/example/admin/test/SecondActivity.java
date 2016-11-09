package com.example.admin.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity implements View.OnClickListener {

    private TextView textView;

    private TextView smallTextView;

    private EditText mtextInputField;

    private Button mSendTextBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        this.textView = (TextView) findViewById(R.id.textView2);
        if(super.getIntent() != null && this.textView != null){
            String message = super.getIntent().getStringExtra("Extra_name");
            this.textView.setText(message);
        }

        this.smallTextView = (TextView) findViewById(R.id.textView3);
        if(super.getIntent() != null && this.smallTextView != null){
            Student pesho = super.getIntent().getParcelableExtra("student");
            if(pesho != null){
                String peshoAge = String.valueOf(pesho.getAge());
                this.smallTextView.setText(peshoAge);
            }
        }

        this.mtextInputField = (EditText) findViewById(R.id.editText2);

        this.mSendTextBackButton = (Button) findViewById(R.id.button5);
        this.mSendTextBackButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.mSendTextBackButton.getId()){
            Intent intent = new Intent();

            String inputTextToBeSendBack = this.mtextInputField.getText().toString();
            intent.putExtra("text_back", inputTextToBeSendBack);

            super.setResult(RESULT_OK, intent);
            super.finish();
        }
    }
}
