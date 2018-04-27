package co.edu.konradlorenz.tucomida;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {

    private  String name;
    private int thumbnail;
    private String ingredients;
    private float preparationTime;
    private String difficulty;
    private String steps;
    private int video;
    private float approximatePrice;
    private ArrayList<Comment> commentList;

    public Dish() {
    }

    public Dish(String name, int thumbnail, String ingredients, float preparationTime, String difficulty, String steps, int video, float approximatePrice, ArrayList<Comment> commentList) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.difficulty = difficulty;
        this.steps = steps;
        this.video = video;
        this.approximatePrice = approximatePrice;
        this.commentList = commentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public float getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(float preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public float getApproximatePrice() {
        return approximatePrice;
    }

    public void setApproximatePrice(float approximatePrice) {
        this.approximatePrice = approximatePrice;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    protected Dish(Parcel in) {
        name = in.readString();
        thumbnail = in.readInt();
        ingredients = in.readString();
        preparationTime = in.readFloat();
        difficulty = in.readString();
        steps = in.readString();
        video = in.readInt();
        approximatePrice = in.readFloat();
        if (in.readByte() == 0x01) {
            commentList = new ArrayList<Comment>();
            in.readList(commentList, Comment.class.getClassLoader());
        } else {
            commentList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(thumbnail);
        dest.writeString(ingredients);
        dest.writeFloat(preparationTime);
        dest.writeString(difficulty);
        dest.writeString(steps);
        dest.writeInt(video);
        dest.writeFloat(approximatePrice);
        if (commentList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(commentList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Dish> CREATOR = new Parcelable.Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };
}