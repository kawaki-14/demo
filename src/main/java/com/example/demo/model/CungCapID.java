package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class CungCapID implements Serializable {
    private String maNCC;
    private String maNS;

    public CungCapID() {}
    public CungCapID(String maNCC, String maNS) {
        this.maNCC = maNCC;
        this.maNS = maNS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CungCapID that = (CungCapID) o;
        return Objects.equals(maNCC, that.maNCC) && Objects.equals(maNS, that.maNS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNCC, maNS);
    }
}