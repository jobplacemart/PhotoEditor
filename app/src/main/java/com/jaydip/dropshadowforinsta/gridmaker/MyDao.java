package com.jaydip.dropshadowforinsta.gridmaker;

import java.util.List;

public interface MyDao {
    void deleteAll();

    List<MyArrByte> getAll();

    void insert(MyArrByte myArrByte);
}
