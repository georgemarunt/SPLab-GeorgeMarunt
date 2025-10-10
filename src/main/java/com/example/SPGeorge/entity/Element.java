package com.example.SPGeorge.entity;


public interface Element {
    default void add(Element element) { throw new UnsupportedOperationException("Not supported yet."); }
    default void remove(Element element) {throw new UnsupportedOperationException("Not supported yet.");}
    default Element get(int index) {throw new UnsupportedOperationException("Not supported yet.");}
    void print(String indent);
}
