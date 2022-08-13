package com.jaydip.dropshadowforinsta.gridmaker;

import java.io.Serializable;

public class CropSize implements Serializable {
    private int colum;
    private boolean isSelected;
    private int row;

    public CropSize() {
    }

    public CropSize(int i, int i2, boolean z) {
        this.colum = i;
        this.row = i2;
        this.isSelected = z;
    }

    public int getColum() {
        return this.colum;
    }

    public void setColum(int i) {
        this.colum = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int i) {
        this.row = i;
    }

    public String toString() {
        return this.colum + "x" + this.row;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
