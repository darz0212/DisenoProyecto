package co.edu.konradlorenz.tucomida;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder>{

    private Context mContext;
    private List<Comment> commentList;

    public CommentsAdapter(Context mContext, List<Comment> commentList) {
        this.mContext = mContext;
        this.commentList = commentList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userEmitterName, commentDescription;
        public ImageView commentThumbnail;
        private View elementView;

        public MyViewHolder(View view) {
            super(view);
            userEmitterName = (TextView) view.findViewById(R.id.userCommentTextView);
            commentDescription = (TextView) view.findViewById(R.id.commentTextView);
            commentThumbnail = (ImageView) view.findViewById(R.id.commentThumbnail);
            elementView = view;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.MyViewHolder holder, int position) {
        final Comment comment = commentList.get(position);

        holder.userEmitterName.setText(comment.getEmitter());
        holder.commentDescription.setText(comment.getCommentDetail());
        Glide.with(mContext).load(R.drawable.usuario).into(holder.commentThumbnail);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}


