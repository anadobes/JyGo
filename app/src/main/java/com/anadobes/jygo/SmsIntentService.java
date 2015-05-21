package com.anadobes.jygo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class SmsIntentService extends IntentService {

    private static final String ACTION_SEND = "com.anadobes.jygo.action.SEND";
    private static final String EXTRA_PHONE_NO = "com.anadobes.jygo.extra.PHONE_NO";
    private static final String EXTRA_MESSAGE = "com.anadobes.jygo.extra.MESSAGE";

    public static void startActionSend(Context context, String phoneNo, String message) {
        Intent intent = new Intent(context, SmsIntentService.class);
        intent.setAction(ACTION_SEND);
        intent.putExtra(EXTRA_PHONE_NO, phoneNo);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.startService(intent);
    }

    public SmsIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SEND.equals(action)) {
                final String phoneNo = intent.getStringExtra(EXTRA_PHONE_NO);
                final String message = intent.getStringExtra(EXTRA_MESSAGE);
                handleActionSend(phoneNo, message);
            }
        }
    }

    private void handleActionSend(String phoneNo, String message) {
        Sms.sendTextMessage(getApplicationContext(), phoneNo, message);
    }
}
