package com.anadobes.jygo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String PHONE_NO = "06........"; // Mat
    private static final String MESSAGE = "J'y Go";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmsIntentService.startActionSend(getApplicationContext(), PHONE_NO, MESSAGE);
        finish();
    }
}
