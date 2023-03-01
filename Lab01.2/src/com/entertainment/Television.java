package com.entertainment;

import java.util.Objects;

/*
 * Natural order is defined by 'brand' (String) and volume (int) then tied on brand.
 *
 * To be "consistent with equals", out sort key(s) must align with what was chosen
 * for equals() nad hashCode().
 */
public class Television implements Comparable<Television> {
    // Instance Variables
    private String brand;
    private int volume;

    // Television HAS-A Tuner, delegates all channel-related functionality to Tuner
    private Tuner tuner = new Tuner();  // instantiated internally, not exposed

    // Constructors
    public Television() {
        // no operation, default constructor
    }

    public Television(String brand, int volume) {
        setBrand(brand);    // delegate to its setter
        setVolume(volume);  // delegate to its setter
    }

    // Business Methods
    public void changeChannel(int channel) {
        tuner.setChannel(channel);  // delegate to contained Tuner object
    }

    public int getCurrentChannel() {
        return tuner.getChannel();  // delegate to contained Tuner object
    }

    // Accessor Methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

/*
    // generated equals() and hashCode()
    @Override
    public boolean equals(Object obj) {
        // if I am the same physical object as obj
        if (this == obj) return true;

        // if obj is null OR I and obj are not the same EXACT type
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() &&
                Objects.equals(this.getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }
*/

    @Override
    public int hashCode() {
        // this is a poorly written has function, because it easily results in "hash collisions"
        // a "hash collision" is when different objects (by equals()) have the SAME hashcode (dumb luck)
        // return getBrand().length() + getVolume();

        // we can use java.util.Objects to help us create a "scientifically correct" hash function,
        // i.e., one that minimizes the probability of hash collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' is really a reference to a Television object
        if (this.getClass() == obj.getClass()) {    // okay to use == for Class objects
            // downcast to more specific type Television, so we can call Television methods
            Television other = (Television) obj;

            // do the checks: brands are the same AND volumes are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
                    this.getVolume() == other.getVolume();                 // int can't be null
        }
        return result;
    }

    /*
     * Natural order is defined by 'brand' (String) and then volume (int) when tied on brand.
     * Since brand (String) is already Comparable, just delegate to its compareTo() method.
     */
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {  // tied on brand, so break the tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s [brand=%s, volume=%s, currentChannel=%s]",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}