package com.sender;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LogSender extends Thread {

    private Artifact artifact;
    private OkHttpClient client;

    public LogSender(Artifact artifact) {
        this.artifact = artifact;
        this.client = new OkHttpClient();
    }

    @Override
    public void run() {
        try {
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send() throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), artifact.getData());
        Request request = new Request.Builder()
                .url(artifact.getData1() + artifact.getData2())
                .post(body)
                .build();

        client.newCall(request).execute();
    }

}
