package com.example.caesarciphercharactersoddwitheven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView outputTextView;
    private EditText messageTextView;
    private SeekBar privateKeySeekBar;
    private SeekBar privateKeySeekBar2;
    private TextView privateKey1;
    private TextView privateKey2;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = findViewById(R.id.outputtv);
        messageTextView = findViewById(R.id.messagetv);
        privateKeySeekBar = findViewById(R.id.seekBar1);
        privateKeySeekBar2 = findViewById(R.id.seekBar2);
        privateKey1 = findViewById(R.id.textViewKey1);
        privateKey2= findViewById(R.id.textViewKey2);

        submit = findViewById(R.id.encryptbtn);



        // listen for seek bar and update the private key text view to reflect the progress
        privateKeySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                privateKey1 .setText("Private Key: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        // listen for seek bar and update the private key text view to reflect the progress
        privateKeySeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                privateKey2 .setText("Private Key: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });




     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String message = messageTextView.getText().toString();
             int key1 = privateKeySeekBar.getProgress();
             int key2 = privateKeySeekBar2.getProgress();

             String encryptedMessage = CaesarCipher.encryptTwo(message,key1,key2);
             outputTextView.setText(encryptedMessage);


         }
     });

    }
}
