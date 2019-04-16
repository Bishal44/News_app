package clea.com.android_news_app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import clea.com.android_news_app.Interface.ItemClickListner;
import clea.com.android_news_app.Model.Website;
import clea.com.android_news_app.R;
import de.hdodenhof.circleimageview.CircleImageView;

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

    public ListSourceAdapter(Context context, Website website) {
        this.context = context;
        this.website = website;
    }

    @NonNull
    @Override
    public ListSourceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.source_layout,viewGroup,false);

        return new ListSourceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListSourceViewHolder listSourceViewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return website.getSources().size();
    }
}
