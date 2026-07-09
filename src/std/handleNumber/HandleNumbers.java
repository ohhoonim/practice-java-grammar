package std.handleNumber;

public class HandleNumbers {

    public static void main(String[] args) {

    }

    // Throwing an Exception
    public static double findLargestThrowException(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Ignoring Incorrect Values
    public static double findLargestIgnoreNonValues(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        boolean foundValidValue = false;

        for (double value : array) {
            if (!Double.isNaN(value) && !Double.isInfinite(value)) {
                if (!foundValidValue || value > max) {
                    max = value;
                    foundValidValue = true;
                }
            }
        }

        return foundValidValue ? max : -1.0;
    }

    // The Value Outside of The Allowed Range
    public static double findLargestReturnNegativeOne(double[] array) {
        if (array.length == 0) {
            return -1.0;
        }

        double max = Double.NEGATIVE_INFINITY;
        boolean foundValidValue = false;

        for (double value : array) {
            if (!Double.isNaN(value) && !Double.isInfinite(value)) {
                if (!foundValidValue || value > max) {
                    max = value;
                    foundValidValue = true;
                }
            }
        }

        return foundValidValue ? max : -1.0;
    }

    // Using Wrappers
    public static Double findLargestWithWrapper(double[] array) {
        Double max = null;

        for (double value : array) {
            if (!Double.isNaN(value) && !Double.isInfinite(value)) {
                if (max == null || value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    // Using Double.NaN
    public static double findLargestReturnNaN(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        boolean foundValidValue = false;

        for (double value : array) {
            if (!Double.isNaN(value) && !Double.isInfinite(value)) {
                if (!foundValidValue || value > max) {
                    max = value;
                    foundValidValue = true;
                }
            }
        }

        return foundValidValue ? max : Double.NaN;
    }
}
