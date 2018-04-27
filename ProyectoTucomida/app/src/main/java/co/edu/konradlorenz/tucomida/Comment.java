package co.edu.konradlorenz.tucomida;

import android.os.Parcel;
import android.os.Parcelable;

public class Comment implements Parcelable {

    private String receiver;
    private String emitter;
    private String commentDetail;

    public Comment() {
    }

    public Comment(String receiver, String emitter, String commentDetail) {
        this.receiver = receiver;
        this.emitter = emitter;
        this.commentDetail = commentDetail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getEmitter() {
        return emitter;
    }

    public void setEmitter(String emitter) {
        this.emitter = emitter;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    protected Comment(Parcel in) {
        receiver = in.readString();
        emitter = in.readString();
        commentDetail = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(receiver);
        dest.writeString(emitter);
        dest.writeString(commentDetail);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };
}
