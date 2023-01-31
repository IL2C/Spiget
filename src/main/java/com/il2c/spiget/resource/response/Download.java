package com.il2c.spiget.resource.response;

import java.io.BufferedInputStream;

public class Download {

    private final String url;
    private final BufferedInputStream bufferedInputStream;

    public Download(String url, BufferedInputStream bufferedInputStream) {
        this.url = url;
        this.bufferedInputStream = bufferedInputStream;
    }

    public String getURL() {
        return url;
    }

    public BufferedInputStream getBufferedInputStream() {
        return bufferedInputStream;
    }

    public boolean isExternal() {
        return bufferedInputStream == null;
    }
}
