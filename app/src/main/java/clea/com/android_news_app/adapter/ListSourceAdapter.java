package clea.com.android_news_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import clea.com.android_news_app.Interface.IconBetterIdeaService;
import clea.com.android_news_app.Interface.ItemClickListner;
import clea.com.android_news_app.ListNews;
import clea.com.android_news_app.Model.IconBetterIdea;
import clea.com.android_news_app.Model.Website;
import clea.com.android_news_app.R;
import clea.com.android_news_app.common.Common;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * created by Bishal on 2019 April 14 2:45 PM
 * version:      V1.0
 * project:      Android_news_App
 * package:      clea.com.android_news_app.adapter
 */


class ListSourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    ItemClickListner itemClickListner;
    TextView source_title;
    CircleImageView source_image;




    public ListSourceViewHolder(@NonNull View itemView) {
        super(itemView);
        source_image=itemView.findViewById(R.id.source_image);
        source_title=itemView.findViewById(R.id.source_name);

        //on click the icon and name of news
        itemView.setOnClickListener(this);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v,getAdapterPosition(),false);

    }
}
public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder>{

    private Context context;
    private Website  website;

    private IconBetterIdeaService ideaService;

    public ListSourceAdapter(Context context, Website website) {
        this.context = context;
        this.website = website;


        ideaService= Common.getIconService();
    }

    @NonNull
    @Override
    public ListSourceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.source_layout,viewGroup,false);

        return new ListSourceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ListSourceViewHolder listSourceViewHolder, int i) {
        //i is position
        StringBuilder iconBetterIdeaApi=new StringBuilder("http://icons.better-idea.org/allicons.json?url=");
        iconBetterIdeaApi.append(website.getSources().get(i).getUrl());

        ideaService.getIconUrl(iconBetterIdeaApi.toString()).
                enqueue(new Callback<IconBetterIdea>() {
                    @Override
                    public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                        if(response.body().getIcons().size()>0){
                            Picasso.get().load(response.body().getIcons().get(0).getUrl())
                                    .into(listSourceViewHolder.source_image);
                        }
                    }

                    @Override
                    public void onFailure(Call<IconBetterIdea> call, Throwable t) {

                    }
                }
        );

        listSourceViewHolder.source_title.setText(website.getSources().get(i).getName());
        listSourceViewHolder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent=new Intent(context, ListNews.class);
                intent.putExtra("source",website.getSources().get(position).getId());
                intent.putExtra("sorts_by",website.getSources().get(position).getSortByAvavible().get(0));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return website.getSources().size();
    }
}
