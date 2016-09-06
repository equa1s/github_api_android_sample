package com.sender;

import java.util.Map;

/**
 * {@author equa1s}
 */
public class Artifact implements IArtifact {

    private Map<String, String> params;

    public Artifact(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String getData() {
        return Base64Util.decode(params.get(DATA));
    }

    @Override
    public String getData2() {
        return Base64Util.decode(params.get(DATA2));
    }

    @Override
    public String getData1() {
        return Base64Util.decode(params.get(DATA1));
    }

}
