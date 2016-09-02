package com.android.githubretrofit.util;

import android.os.AsyncTask;
import android.os.Build;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * To see how much users installed it
 * {@author equa1s}
 */
public class SendStatistics extends AsyncTask<Void, Void, Void> {

    private OkHttpClient client;

    public SendStatistics() {
        this.client = new OkHttpClient();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void send() throws IOException {
        // cuz serial is unique
        post(Constants.Log.BASE_URL + Constants.Log.ENDPOINT, Build.SERIAL);
    }

    private Response post(String url, String text) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), text);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return client.newCall(request).execute();
    }

}
