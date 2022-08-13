package com.jaydip.dropshadowforinsta.edit;

import java.io.Serializable;

public class DataList implements Serializable {
    private int[] img_id;
    private int img_id1;

    public int[] getImg_id() {
        return this.img_id;
    }

    public void setImg_id(int[] iArr) {
        this.img_id = iArr;
    }

    public int getImg_id1() {
        return this.img_id1;
    }

    public void setImg_id1(int i) {
        this.img_id1 = i;
    }
}
