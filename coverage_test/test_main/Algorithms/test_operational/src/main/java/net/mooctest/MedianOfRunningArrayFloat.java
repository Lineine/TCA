package net.mooctest;

public final class MedianOfRunningArrayFloat extends MedianOfRunningArray<Float> {
    @Override
    public Float calculateAverage(final Float a, final Float b) {
        return (a + b) / 2.0f;
    }
}
