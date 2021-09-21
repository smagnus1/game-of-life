package com.game_of_life;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key =  Objects.requireNonNull(key, "NO");
        this.value= Objects.requireNonNull(value, "NO");
    }

    //unimplemented
    public boolean equals(Object o) {
        return true;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

        //unimplemented
    public int hashCode() {
        return 0;
    }

    public String toString() {
        return key.toString() + value.toString();
    }

/*     public void print() {
        System.out.println("The pair's values are: " + key + " " + value);
    } */

}
