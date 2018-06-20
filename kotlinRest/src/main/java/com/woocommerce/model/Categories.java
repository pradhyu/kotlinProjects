package com.woocommerce.model;


import java.lang.reflect.Field;

/**
 * Created by kumardivyarajat on 04/01/16.
 */
public class Categories extends WCObject implements Parcelable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public long getParent_id() {
        return parent_id;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplay() {
        return display;
    }

    public String getImage() {
        return image;
    }

    public int getCount() {
        return count;
    }

    private String slug;
    private long parent_id;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String description;
    private String display;
    private String image;
    private int count;

    public Categories() {
    }



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
