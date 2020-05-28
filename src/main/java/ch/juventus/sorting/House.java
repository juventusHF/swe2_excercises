package ch.juventus.sorting;

public class House implements Comparable<House>{

    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfWindows;
    private boolean isFree;

    public House (int numberOfBedrooms, int numberOfBathrooms, int numberOfWindows, boolean isFree) {
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfWindows = numberOfWindows;
        this.isFree = isFree;
    }

    @Override
    public int compareTo(House o) {
        if(numberOfBedrooms > o.getNumberOfBedrooms()) {
            return 1;
        } if(numberOfBedrooms < o.getNumberOfBedrooms()) {
            return -1;
        }
        return 0;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "House{" +
                "numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfWindows=" + numberOfWindows +
                ", isFree=" + isFree +
                '}';
    }
}
