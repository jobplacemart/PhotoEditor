package com.jaydip.dropshadowforinsta.gridmaker;

import java.io.Serializable;

public class MyArrByte implements Serializable {
    private byte[] bytes;
    public int id;

    public MyArrByte() {
    }

    public MyArrByte(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public void setBytes(byte[] bArr) {
        this.bytes = bArr;
    }
}
