package com.caihong.effectivejava;

public class MyHashTable implements Cloneable {
    private Entry[] buckets;

    private static class Entry {
        private final Object key;
        private Object value;
        private Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /*
                Entry deepClone() {
                    // 可能导致栈溢出
                    return new Entry(key, value, next == null ? null : next.deepClone());
                }
        */
        Entry deepClone() {
            Entry clone = new Entry(key, value, next);
            for (Entry tmp = clone; tmp.next != null; tmp = tmp.next) {
                tmp.next = new Entry(tmp.next.key, tmp.next.value, tmp.next.next);
            }
            return clone;
        }
    }

    @Override
    protected MyHashTable clone() {
        try {
            MyHashTable clone = (MyHashTable) super.clone();
            clone.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    clone.buckets[i] = buckets[i].deepClone();
                }
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
