package com.woocommerce.model;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

public class Product extends WCObject implements  Parcelable{


    public Product() {
    }

    private String title;
    private long id;
    private Date created_at;
    private Date updated_at;
    private String type;
    private String permalink;
    private String sku;
    private String price;
    private String regular_price;
    private String sale_price;
    private boolean managing_stock;
    private int stock_quantity;
    private boolean in_stock;
    private boolean backorders_allowed;
    private boolean backordered;
    private boolean sold_individually;
    private boolean featured;
    private boolean visible;
    private String catalog_visibility;
    private boolean on_sale;
    private String product_url;
    private String button_text;
    private String weight;
    private boolean shipping_required;
    private boolean  shipping_taxable;
    private String shipping_class;
    private String shipping_class_id;
    private String long_description;
    private String short_description;
    private boolean reviews_allowed;
    private String average_rating;
    private int rating_count;
    private ArrayList<Long> related_ids;
    private ArrayList<Long> upsell_ids;
    private ArrayList<Long> cross_sell_ids;
    private long parent_id;
    private ArrayList<String> categories;
    private ArrayList<String> tags;
    private ArrayList<ProductImage> productImages;
    private String featured_image_url;
    private int total_sales;
    private boolean hasVariations;
    private ArrayList<String> variationId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public boolean isManaging_stock() {
        return managing_stock;
    }

    public void setManaging_stock(boolean managing_stock) {
        this.managing_stock = managing_stock;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public String getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(String shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public ArrayList<Long> getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(ArrayList<Long> related_ids) {
        this.related_ids = related_ids;
    }

    public ArrayList<Long> getUpsell_ids() {
        return upsell_ids;
    }

    public void setUpsell_ids(ArrayList<Long> upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public ArrayList<Long> getCross_sell_ids() {
        return cross_sell_ids;
    }

    public void setCross_sell_ids(ArrayList<Long> cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(ArrayList<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public String getFeatured_image_url() {
        return featured_image_url;
    }

    public void setFeatured_image_url(String featured_image_url) {
        this.featured_image_url = featured_image_url;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public boolean isHasVariations() {
        return hasVariations;
    }

    public void setHasVariations(boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    public ArrayList<String> getVariationId() {
        return variationId;
    }

    public void setVariationId(ArrayList<String> variationId) {
        this.variationId = variationId;
    }

    public ArrayList<ProductAttribute> getProductAttributeArrayList() {
        return productAttributeArrayList;
    }

    public void setProductAttributeArrayList(ArrayList<ProductAttribute> productAttributeArrayList) {
        this.productAttributeArrayList = productAttributeArrayList;
    }

    private ArrayList<ProductAttribute> productAttributeArrayList;


    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }
}