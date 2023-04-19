package com.caihong.javathinking.arrays;

public class CountingGenerator {
    private static final char[] CASE_ARRAY = "ABCDEFG".toCharArray();

    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = true;

        public Boolean() {
        }

        public Boolean(boolean value) {
            this.value = value;
        }

        @Override
        public java.lang.Boolean next() {
            return value;
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        private int index = -1;

        @Override
        public java.lang.Character next() {
            index = (index + 1) % CASE_ARRAY.length;
            return CASE_ARRAY[index];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 4;
        private static final Generator<java.lang.Character> cg = new Character();

        public String() {
        }

        public String(int length) {
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] chars = new char[length];
            for (int i = 0; i < length; i++) {
                chars[i] = cg.next();
            }
            return new java.lang.String(chars);
        }
    }
}
