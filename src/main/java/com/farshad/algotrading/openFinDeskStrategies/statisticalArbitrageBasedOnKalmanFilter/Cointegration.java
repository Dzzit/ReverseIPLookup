package com.farshad.algotrading.openFinDeskStrategies.statisticalArbitrageBasedOnKalmanFilter;


import org.la4j.Matrix;

public class Cointegration {
    double mDelta;
    double mR;
    KalmanFilter mFilter;
    int mNobs = 2;

    public Cointegration(double delta, double r) {
        mDelta = delta;
        mR = r;

        Matrix vw = Matrix.identity(mNobs).multiply(mDelta / (1 - delta));
        Matrix a = Matrix.identity(mNobs);

        Matrix x = Matrix.z