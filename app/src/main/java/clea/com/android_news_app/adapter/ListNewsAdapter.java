package clea.com.android_news_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import clea.com.android_news_app.DetailArticle;
import clea.com.android_news_app.Interface.ItemClickListner;
import clea.com.android_news_app.Model.Article;
import clea.com.android_news_app.R;
import clea.com.android_news_app.common.ISO8601Parse;
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

    public void setItemClickListener(ItemClickListner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsViewHolder>  {

    private List<Article> articleList;
    private Context context;

    public ListNewsAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListNewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.news_layout,viewGroup,false);
        return new ListNewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsViewHolder listNewsViewHolder, int position) {
        Picasso.get()
                .load(articleList.get(position).getUrlToImage())
                .into(listNewsViewHolder.article_image);

        if(articleList.get(position).getTitle().length() > 65)
            listNewsViewHolder.article_title.setText(articleList.get(position).getTitle().substring(0,65)+"...");
        else
            listNewsViewHolder.article_title.setText(articleList.get(position).getTitle());

        if(articleList.get(position).getPublishedAt() != null) {
            Date date = null;
            try {
                date = ISO8601Parse.parse(articleList.get(position).getPublishedAt());
            } catch (ParseException ex) {
                ex.printStackTrace();

            }

            listNewsViewHolder.article_time.setReferenceTime(date.getTime());
        }

        //Set Event Click
        listNewsViewHolder.setItemClickListener(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent detail = new Intent(context, DetailArticle.class);
                detail.putExtra("webURL",articleList.get(position).getUrl());
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
