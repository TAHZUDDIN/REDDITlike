package example.com.redditlike.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import example.com.redditlike.R;
import example.com.redditlike.activities.WebviewActivity;
import example.com.redditlike.adapters.NewsRecyclerAdapter;
import example.com.redditlike.apiobjects.AllUser;
import example.com.redditlike.constants.Constants;
import example.com.redditlike.listeners.StartActivityListener;
import example.com.redditlike.parsingclasses.ReturnDataReddit;
import example.com.redditlike.volleylibclasses.AppRequestListener;
import example.com.redditlike.volleylibclasses.BaseTask;
import example.com.redditlike.volleylibclasses.GetFeedServiceClass;


public class CategoriesFragment extends Fragment implements AppRequestListener, Constants,
                                        StartActivityListener ,SwipeRefreshLayout.OnRefreshListener
{

    String TAG ;
    ReturnDataReddit returnDataReddit;
    View fragmentView;
    RecyclerView  picsRecyclerView;
    LinearLayoutManager llm;
    NewsRecyclerAdapter newsRecyclerAdapter;
    View progress_bar;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static CategoriesFragment newInstance(String tagString) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TAG_STRING, tagString);
        fragment.setArguments(bundle);
        return fragment;
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TAG = getArguments().getString(Constants.TAG_STRING);
        callAPIsAcoordingly();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_holding_navigationmainview, container, false);

        picsRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.id_main_recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)fragmentView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        progress_bar = fragmentView.findViewById(R.id.progress_bar);
        progress_bar.setVisibility(View.VISIBLE);

        return fragmentView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }




    public void hotAPI()
    {
        String url = "https://www.reddit.com/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }


    public void newsAPI()
    {
        String url = "https://www.reddit.com/new/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }
    public void risingAPI()
    {
        String url = "https://www.reddit.com/rising/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }
    public void topAPI()
    {
        String url = "https://www.reddit.com/top/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }
    public void controversialAPI()
    {
        String url = "https://www.reddit.com/controversial/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }
    public void promotedAPI()
    {
        String url = "https://www.reddit.com/ads/.json";
        AllUser.getInstance().getHotAllUser(url, CategoriesFragment.this, getActivity());
    }




    @Override
    public <T> void onRequestStarted(BaseTask<T> request)
    {

    }



    @Override
    public <T> void onRequestCompleted(BaseTask<T> request)
    {
           if(mSwipeRefreshLayout!=null && mSwipeRefreshLayout.isRefreshing()== true )
              mSwipeRefreshLayout.setRefreshing(false);

            if (((GetFeedServiceClass) request).getDataObject() != null)
            {
                if(progress_bar!= null)
                   progress_bar.setVisibility(View.GONE);

                setAdapter(((GetFeedServiceClass) request).getDataObject());
            }

    }






    @Override
    public <T> void onRequestFailed(BaseTask<T> request) {

    }






    public void callAPIsAcoordingly()
    {

        switch (TAG)
        {
            case  "top":
                topAPI();
                break;

            case  "news":
                newsAPI();
                break;

            case  "rising":
                risingAPI();
                break;
            case  "hot":
                hotAPI();
                break;
            case  "controversial":
                controversialAPI();
                break;
            case  "promoted":
                promotedAPI();
                break;

        }
    }





    public void setAdapter(ReturnDataReddit rdReddit)
    {
        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        picsRecyclerView.setLayoutManager(llm);

        newsRecyclerAdapter = new NewsRecyclerAdapter(rdReddit);
        newsRecyclerAdapter.setStartActivityListener(CategoriesFragment.this);
        picsRecyclerView.setAdapter(newsRecyclerAdapter);

    }


    @Override
    public void startActivityMethod(String url)
    {
        Intent i = new Intent(getActivity(), WebviewActivity.class);
        i.putExtra("url",url);
        if (url != null && url.length()!=0)
           getActivity().startActivity(i);
        else
            Toast.makeText(getActivity(),"No link to show ", Toast.LENGTH_SHORT).show();


    }



    // Method on Inteface SwipeRefresh Listener
    @Override
    public void onRefresh()
    {
        callAPIsAcoordingly();
    }
}
