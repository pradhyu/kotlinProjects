package com.woocommerce.model;


import java.util.ArrayList;

/**
 * Created by kumardivyarajat on 10/01/16.
 */
public class ProductAttribute extends WCObject implements Parcelable {


    public ProductAttribute() {
    }

    private String name;
    private String slug;
    private int position;
    private boolean visible;
    private boolean variations;
    private ArrayList<String> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVariations() {
        return variations;
    }

    public void setVariations(boolean variations) {
        this.variations = variations;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

}
