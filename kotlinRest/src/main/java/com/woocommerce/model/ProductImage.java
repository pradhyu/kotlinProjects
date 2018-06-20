package com.woocommerce.model;


import java.util.Date;

/**
 * Created by kumardivyarajat on 10/01/16.
 */
public class ProductImage extends WCObject implements Parcelable {

    public ProductImage() {
    }

    long id;
    Date created_at;
    Date updated_at;
    String src;
    String title;
    String alt;
    int position;

    public String getSrc() {
        return src;
    }
}
