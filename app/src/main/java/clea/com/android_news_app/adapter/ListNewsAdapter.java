package clea.com.android_news_app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;

import clea.com.android_news_app.Interface.ItemClickListner;
import clea.com.android_news_app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * created by Bishal on 2019 April 21 5:46 PM
 * version:      V1.0
 * project:      Android_news_App
 * package:      clea.com.android_news_app.adapter
 */

class ListNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemClickListner itemClickListener;

    TextView article_title;
    RelativeTimeTextView article_time;
    CircleImageView article_image;

    public ListNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        article_title=itemView.findViewById(R.id.article_title);
        article_image=itemView.findViewById(R.id.artical_image);
        article_time=itemView.findViewById(R.id.article_time);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
public class ListNewsAdapter {

}
