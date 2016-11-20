package example.com.redditlike.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import example.com.redditlike.R;
import example.com.redditlike.constants.Constants;
import example.com.redditlike.fragments.CategoriesFragment;

public class MainActivity extends AppCompatActivity implements Constants
{


    CategoriesFragment HotCategoriesFragment,
                       NewsCategoriesFragment,
                       RisingCategoriesFragment,
                       ControversialCategoriesFragment,
                       TopCategoriesFragment,
                       PromotedCategoriesFragment;



    CustomPagerAdapter customPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =(ViewPager)findViewById(R.id.viewPager);
        tabLayout =(TabLayout)findViewById(R.id.tabLayout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("RedditLike");




        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }





    // Custom adapter for tablayout and viewpager  and FragmentTabViewPager containing BAR CHART for humidity, wind, temperature, Rain
    class CustomPagerAdapter extends FragmentStatePagerAdapter
    {
        FragmentManager fragMan;

        public CustomPagerAdapter(FragmentManager fm)
        {
            super(fm);
            fragMan = fm;
        }


        public FragmentManager getFragmentManager() {
            return fragMan;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case 0:
                    HotCategoriesFragment = HotCategoriesFragment.newInstance(HOT);
                    return HotCategoriesFragment;

                case 1:
                    NewsCategoriesFragment = NewsCategoriesFragment.newInstance(NEWS);
                    return NewsCategoriesFragment;

                case 2:
                    RisingCategoriesFragment = RisingCategoriesFragment.newInstance(RISING);
                    return RisingCategoriesFragment;


                case 3:
                    ControversialCategoriesFragment = ControversialCategoriesFragment.newInstance(CONTROVERSIAL);
                    return ControversialCategoriesFragment;


                case 4:
                    TopCategoriesFragment= TopCategoriesFragment.newInstance(TOP);
                    return TopCategoriesFragment;


                case 5:
                    PromotedCategoriesFragment= PromotedCategoriesFragment.newInstance(PROMOTED);
                    return PromotedCategoriesFragment;


                default:
                    return null;
            }

        }




        @Override
        public Parcelable saveState()
        {
            return null;
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {

        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.hot);
                case 1:
                    return getResources().getString(R.string.news);
                case 2:
                    return getResources().getString(R.string.rising);
                case 3:
                    return getResources().getString(R.string.controversial);
                case 4:
                    return getResources().getString(R.string.top);
                case 5:
                    return getResources().getString(R.string.promoted);

                default:
                    return "";
            }

        }



    }




}
