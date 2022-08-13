
package com.farshad.algotrading.openFinDeskStrategies.statisticalArbitrageBasedOnKalmanFilter;


import org.la4j.LinearAlgebra;
import org.la4j.Matrix;
import org.la4j.matrix.DenseMatrix;

/**
 * n: Number of states
 * m: Number of sensors
 * <p>
 * https://www.udacity.com/wiki/cs373/kalman-filter-matrices
 * <p>
 * Steps:
 * <p>
 * PREDICT X'
 * <p>
 * First, we predict our next x:
 * <p>
 * x' = Fx + u
 * <p>
 * UPDATE P'
 * <p>
 * We also update the covariance matrix according to the next prediction:
 * <p>
 * P' = FP(transp F)
 * <p>
 * UPDATE Y
 * <p>
 * y becomes the difference between the move and what we expected:
 * <p>
 * y = z - Hx
 * <p>
 * UPDATE S
 * <p>
 * S is the covariance of the move, adding up the covariance in move space of the position and the covariance of the measurement:
 * <p>
 * S = HP(transp H) + R
 * <p>
 * CALCULATE K
 * <p>
 * Now I start to wave my hands. I assume this next matrix is called K because this is the work of the Kalman filter. Whatever is happening here, it doesn't depend on u or z. We're computing how much of the difference between the observed move and the expected move to add to x.
 * <p>
 * K = P (transp H) (inv S)
 * <p>
 * UPDATE X'
 * <p>
 * We update x:
 * <p>
 * x' = x + Ky
 * <p>
 * SUBTRACT P
 * <p>
 * And we subtract some uncertainty from P, again not depending on u or z:
 * <p>
 * P' = P - P(transp H)(inv S)HP
 */
public class KalmanFilter {
    private final int mStateCount; // n
    private final int mSensorCount; // m
    // state

    /**
     * stateCount x 1
     */
    private Matrix mState; // x, state estimate

    /**
     * stateCount x stateCount
     * <p>
     * Symmetric.
     * Down the diagonal of P, we find the variances of the measurements of x.
     * On the off diagonals, at P[i][j], we find the covariances of x[i] with x[j].
     */
    private Matrix mStateCovariance; // Covariance matrix of x, process noise (w)

    // predict

    /**
     * stateCount x stateCount
     * <p>
     * Kalman filters model a system over time.
     * After each tick of time, we predict what the values of x are, and then we measure and do some computation.
     * F is used in the update step. Here's how it works: For each value in x, we write an equation to update that value,
     * a linear equation in all the variables in x. Then we can just read off the coefficients to make the matrix.
     */
    private Matrix mUpdateMatrix; // F, State transition matrix.

    /**
     * stateCount x stateCount
     * <p>
     * Error in the process, after each update this uncertainty is added.
     */
    private Matrix mUpdateCovariance; // Q, Estimated error in process.

    /**
     * stateCount x 1
     * <p>
     * The control input, the move vector.
     * It's the change to x that we cause, or that we know is happening.
     * Since we add it to x, it has dimension n. When the filter updates, it adds u to the new x.
     * <p>