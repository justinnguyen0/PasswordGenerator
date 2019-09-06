package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Button generate;
    Button btn_copy;

    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);

        generate = (Button) findViewById(R.id.generate);

        btn_copy = findViewById(R.id.btn_copy);



        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = result.getText().toString();

                if (!text.equals("")) {
                    ClipData clipData = ClipData.newPlainText("text", text);
                    clipboardManager.setPrimaryClip(clipData);

                    Toast.makeText(MainActivity.this, "Copied",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = 15;

                result.setText(GetPassword(length));
            }
        });
    }

    public String GetPassword(int length) {
        char[] chars=("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012345678" +
                "9!@#$%^&*?()_").toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        Random rand = new Random();

        for(int i = 0; i < length; i++) {
            char c = chars[rand.nextInt(chars.length)];
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
