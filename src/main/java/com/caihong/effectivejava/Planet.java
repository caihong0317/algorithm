package com.caihong.effectivejava;

public enum Planet {
    EARTH(1, 2);
    private final double mass;
    private final double radius;
    private final double surfaceG;
    private static final double G = 6.6E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceG = mass * G / Math.pow(radius, 2);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceG() {
        return surfaceG;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceG;
    }
}
