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

        Matrix x = Matrix.zero(mNobs, 1);

        mFilter = new KalmanFilter(mNobs, 1);
        mFilter.setUpdateMatrix(a);
        mFilter.setState(x);
        mFilter.setStateCovariance(Matrix.zero(mNobs, mNobs));
        mFilter.setUpdateCovariance(vw);
        mFilter.setMeasurementCovariance(Matrix.constant(1, 1, r));
    }

    public void step(double x, double y) {
        mFilter.setExtractionMatrix(Matrix.from