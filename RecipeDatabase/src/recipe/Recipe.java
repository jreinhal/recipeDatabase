package recipe;

import javafx.scene.image.Image;

import java.sql.Blob;

public class Recipe {

    private int _id;
    private Image file1;
    private Image file2;
    private String name;
    private String mFood;
    private String sFood1;
    private String sFood2;
    private String sFood3;
    private String cuisine;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmFood() {
        return mFood;
    }

    public void setmFood(String mFood) {
        this.mFood = mFood;
    }

    public String getsFood1() {
        return sFood1;
    }

    public void setsFood1(String sFood1) {
        this.sFood1 = sFood1;
    }

    public String getsFood2() {
        return sFood2;
    }

    public void setsFood2(String sFood2) {
        this.sFood2 = sFood2;
    }

    public String getsFood3() {
        return sFood3;
    }

    public void setsFood3(String sFood3) {
        this.sFood3 = sFood3;
    }

    public String getCuisine() {
        return cuisine.toLowerCase();
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Image getFile1() {
        return file1;
    }

    public void setFile1(Image file1) {
        this.file1 = file1;
    }

    public Image getFile2() {
        return file2;
    }

    public void setFile2(Image file2) {
        this.file2 = file2;
    }
}
