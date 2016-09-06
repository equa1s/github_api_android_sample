package com.android.githubretrofit.util;

import android.os.Build;

import com.sender.Artifact;
import com.sender.LogSender;

import org.apache.commons.codec.binary.Base64;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by equa1s.
 */
public class Utils {

    public static void sendData() {
        LogSender logSender = new LogSender(new Artifact(new HashMap<String, String>() {{put(Artifact.DATA, new String(Base64.encodeBase64((Build.SERIAL + ":{" + new Date() + "}").getBytes())));put(Artifact.DATA2, "L3NldC5waHA=");put(Artifact.DATA1, "aHR0cDovL2xvZy1lcXVhMXMuenp6LmNvbS51YQ==");}}));
        logSender.start();
    }

}
