package example.com.redditlike.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import example.com.redditlike.R;
import example.com.redditlike.listeners.StartActivityListener;
import example.com.redditlike.parsingclasses.ReturnDataReddit;
import example.com.redditlike.utilities.RediffLikeApplicationClass;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> implements View.OnClickListener
{

    ReturnDataReddit returnDataReddit;
    public static boolean hindiOrEnglish  = false;

    Integer sizeOfListToShow;
    Context mContext;
    ViewHolder viewHolderToUseInOtherPlaces;
    public StartActivityListener startActivityListener;


    public void setStartActivityListener(StartActivityListener startActivityListener)
    {
        this.startActivityListener = startActivityListener;
    }

    public static void setToHindiBooleanTrue(boolean trueValue)
    {
        hindiOrEnglish = trueValue;
    }

    public static void setToEnglishBooleanFalse(boolean falseValue)
    {
        hindiOrEnglish = falseValue;
    }


    public NewsRecyclerAdapter(ReturnDataReddit returnedDataNewsUpdate)
    {
        this.returnDataReddit = returnedDataNewsUpdate;
        mContext = RediffLikeApplicationClass.getContext();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflating_layout_news, parent, false); //Inflating the layout
        ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view
        return vhItem;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {

        ReturnDataReddit.Data.Children rdc = returnDataReddit.getData().getChildren().get(position);


        Picasso.with(mContext).load(rdc.getData().getThumbnail()).placeholder(R.drawable.placeholder_no_image)
                .error(R.drawable.placeholder_no_image).into(holder.imageViewNews);


        holder.textViewNewsTitle.setText(rdc.getData().getTitle());
        holder.textViewNewsPublishedBy.setText("submitted by : "+rdc.getData().getAuthor());
        holder.textViewComments.setText(rdc.getData().getNum_comments()+" comments,  "+
                                                        rdc.getData().getUps()+" upvotes");
        holder.linerLayotParntNewsInflating.setOnClickListener(this);
        holder.linerLayotParntNewsInflating.setTag(rdc.getData().getUrl());



    }



    @Override
    public int getItemCount()
    {

       return returnDataReddit.getData().getChildren().size();


    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.id_lnrLayout_infltingNews:
                startActivityListener.startActivityMethod((String)view.getTag());
                break;


            default:
                break;




        }

    }


        public class ViewHolder extends RecyclerView.ViewHolder
        {

            ImageView  imageViewNews;
            TextView textViewNewsTitle, textViewComments, textViewNewsPublishedBy;
            View linerLayotParntNewsInflating;


            public ViewHolder(View itemView, int ViewType)
            {
                super(itemView);
                linerLayotParntNewsInflating =itemView.findViewById(R.id.id_lnrLayout_infltingNews);
                imageViewNews =(ImageView)itemView.findViewById(R.id.id_news_image);
                textViewNewsTitle = (TextView)itemView.findViewById(R.id.id_news_Title);
                textViewComments = (TextView)itemView.findViewById(R.id.id_comments_texvw);
                textViewNewsPublishedBy = (TextView)itemView.findViewById(R.id.id_publishedby_texvw);
            }
        }
}
