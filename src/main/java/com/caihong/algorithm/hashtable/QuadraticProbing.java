package com.caihong.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 应使用双泛型
// HashEntry需要使用双泛型以保存Key吗？目前无法实现Map.Entry<K,V>
public class QuadraticProbing<Key, Value> {
    private HashEntry<Key, Value>[] array;
    private int currentSize;
    private static final int DEFAULT_TABLE_SIZE = 11;

    public QuadraticProbing() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbing(int size) {
        allocateArray(size);
        makeEmpty();
    }

    // HashMap中没有双参的contains方法
    // 独创
    public boolean contains(Key key, Value value) {
        int currentPos = findPos(key, value);
        return isActive(currentPos);
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    // 获取当前位置
    private int findPos(Key key, Value value) {
        int currentPos = myHash(key);
        int temp = currentPos;
        int num = 1;
        // 相等时不在乎是否活跃
        // 1为null，退出
        // 2不为null且不相同时，继续
        // 3不为null且相同时，退出
        while (array[currentPos] != null && !array[currentPos].element.equals(value)) {
            currentPos = temp + num * num;
            num++;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private int myHash(Key key) {
        int hashCode = key.hashCode() % array.length;
        if (hashCode < 0) {
            hashCode += array.length;
        }
        return hashCode;
    }

    //支持对标记为删除的值，用新值覆盖；返回旧值，Key不存在时返回null
    public Value put(Key key, Value value) {
        // 不能使用findPos
        int pos = getCanInsertPos(key, value);
        // 已存在
        if (isActive(pos)) {
            return value;
        }

        HashEntry<Key, Value> entry = array[pos];
        HashEntry<Key, Value> oldEntry = entry;

        /*if (entry == null) {
            entry = new HashEntry<>(value);
            currentSize++;
        } else if (entry != null && entry.element.equals(value)) {
            // 修改为活跃，原HashEntry不会被释放，没有产生垃圾；但这种情况出现的很少
            entry.isActive = true;
        } else {
            // 覆盖
            entry = new HashEntry<>(value);
        }*/

        // 上面简写后
        // 新插入时
        if (entry == null) {
            currentSize++;
        }
        // 插入或覆盖
        entry = new HashEntry<>(key, value);

        // 是否扩容
        if (currentSize > array.length / 2) {
            rehash();
        }

        return oldEntry == null ? null : oldEntry.element;
    }

    private void rehash() {
        HashEntry<Key, Value>[] oldArray = array;
        int newSize = nextPrime(array.length * 2);
        array = new HashEntry[newSize];
        currentSize = 0;
        for (HashEntry<Key, Value> entry : oldArray) {
            if (entry != null && entry.isActive) {
                put(entry.key, entry.element);
            }
        }
    }

    // 于size的最小素数
    private int nextPrime(int size) {
        if (size <= 2) {
            return 2;
        }
        while (!isPrime(size)) {
            size++;
        }
        return size;
    }

    // 素数判断 N,size / 2不合理
    private boolean isPrime(int size) {
        for (int i = 3; i <= Math.sqrt(size); i++) {
            if (size % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        makeEmpty();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public Set<Key> keySet() {
        Set<Key> set = new HashSet<>();
        if (currentSize != 0) {
            for (HashEntry<Key, Value> entry : array) {
                if (entry != null && entry.isActive) {
                    set.add(entry.key);
                }
            }
        }
        return set;
    }

    public Set<Entry> entrySet(){
        Set<Entry> set = new HashSet<>();
        if (currentSize != 0) {
            for (HashEntry<Key, Value> entry : array) {
                if (entry != null && entry.isActive) {
                    set.add(new Entry(entry.key,entry.element));
                }
            }
        }
        return set;
    }

    public Collection<Value> values() {
        Collection<Value> list = new ArrayList<>();
        if (!isEmpty()) {
            for (HashEntry<Key, Value> entry : array) {
                if (entry != null) {
                    list.add(entry.element);
                }
            }
        }
        return list;
    }

    public boolean containsKey(Key key) {
        return array[myHash(key)] == null;
    }

    public boolean containsValue(Value value) {
        Collection<Value> values = values();
        if (values != null) {
            for (Value value1 : values) {
                if (value1.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 获取可插入位置
    private int getCanInsertPos(Key key, Value value) {
        int currentPos = myHash(key);
        int temp = currentPos;
        int num = 1;
        // 不在乎是否相同
        // 为null，退出
        // 不为null且不活跃时，退出
        // 不为null且活跃时，继续
        while (array[currentPos] != null && array[currentPos].isActive) {
            currentPos = temp + num * num;
            num++;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    // 是否返回boolean? 如果Key不存在时返回true还是false？
    // 所以返回旧值为好，Key不存在时返回null
    public Value remove(Key key) {
        HashEntry<Key, Value> entry = getHashEntry(key);
        if (entry != null) {
            entry.isActive = false;
            return entry.element;
        }
        return null;
    }

    public Value get(Key key) {
        HashEntry<Key, Value> entry = getHashEntry(key);
        return entry == null ? null : entry.element;
    }

    private HashEntry<Key, Value> getHashEntry(Key key) {
        HashEntry<Key, Value> entry = array[myHash(key)];
        return entry == null ? null : entry;
    }

    private void makeEmpty() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    /**
     * @param size
     */
    private void allocateArray(int size) {
        array = new HashEntry[size];
    }


    // 需要保存key
    private static class HashEntry<Key, Value> {
        private Key key;
        private Value element;
        private boolean isActive; // 默认值为false

        public HashEntry(Key key, Value element) {
            this(key, element, true);
        }

        public HashEntry(Key key, Value element, boolean isActive) {
            this.key = key;
            this.element = element;
            this.isActive = isActive;
        }
    }

    // 有HashEntry还需要Entry吗？
    public static class Entry<Key, Value>{
        // key必须在constructor里被初始化,，同时不能有getter()
        private final Key key;
        private Value element;

        public Entry(Key key, Value element) {
            this.key = key;
            this.element = element;
        }

        public Key getKey() {
            return key;
        }

        public Value getElement() {
            return element;
        }

        public void setElement(Value element) {
            this.element = element;
        }
    }
}
