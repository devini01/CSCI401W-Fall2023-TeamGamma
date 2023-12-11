package org.meicode.rafflescreennew.utils.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

//parcelable makes it easier to pass instances of a class quicker between the various components in the app
public class ShoeItem implements Parcelable {

    //just added
    private String shoeName , shoeBrandName;
    private int shoeImage;
    private double shoePrice;
    private Date releaseDate;

    public ShoeItem(String shoeName, String shoeBrandName, int shoeImage, double shoePrice, Date releaseDate) {
        //represents the different properties for the item shoe
        this.shoeName = shoeName;
        this.shoeBrandName = shoeBrandName;
        this.shoeImage = shoeImage;
        this.shoePrice = shoePrice;
        this.releaseDate = releaseDate;
    }

    //creates a ShoeItem object from a parcel
    protected ShoeItem(Parcel in) {
        shoeName = in.readString();
        shoeBrandName = in.readString();
        shoeImage = in.readInt();
        shoePrice = in.readDouble();
        releaseDate = new Date(in.readLong());
    }

    public static final Creator<ShoeItem> CREATOR = new Creator<ShoeItem>() {
        @Override
        public ShoeItem createFromParcel(Parcel in) {
            return new ShoeItem(in);
        }

        @Override
        public ShoeItem[] newArray(int size) {
            return new ShoeItem[size];
        }
    };

    // Getter and Setter methods for accessing and modifying the private fields
    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeBrandName() {
        return shoeBrandName;
    }

    public void setShoeBrandName(String shoeBrandName) {
        this.shoeBrandName = shoeBrandName;
    }

    public int getShoeImage() {
        return shoeImage;
    }

    public void setShoeImage(int shoeImage) {
        this.shoeImage = shoeImage;
    }

    public double getShoePrice() {
        return shoePrice;
    }

    public void setShoePrice(double shoePrice) {
        this.shoePrice = shoePrice;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(shoeName);
        dest.writeString(shoeBrandName);
        dest.writeInt(shoeImage);
        dest.writeDouble(shoePrice);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : 0); // Write the release date as a long
    }
}
