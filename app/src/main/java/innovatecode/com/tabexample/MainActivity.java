package innovatecode.com.tabexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Fragment tabOneFragment;
    private Fragment tabTwoFragment;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            //Restore the fragment's instance
            tabOneFragment = (TabOneFragment) getSupportFragmentManager().getFragment(
                    savedInstanceState, "tabOneFragment");
            tabTwoFragment = (TabTwoFragment) getSupportFragmentManager().getFragment(
                    savedInstanceState, "tabTwoFragment");
        } else {
            tabOneFragment = new TabOneFragment();
            tabTwoFragment = new TabTwoFragment();
        }

        if (findViewById(R.id.tab_layout) != null) {
            setUpPortraitLayout();
        } else {
            setUpLandscapeLayout();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "tabOneFragment", tabOneFragment);
        getSupportFragmentManager().putFragment(outState, "tabTwoFragment", tabTwoFragment);
    }

    private void setUpPortraitLayout() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Assign created adapter to viewPager
        viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // This method setup all required method for TabLayout with Viewpager
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpLandscapeLayout() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_left, tabOneFragment);
        transaction.replace(R.id.fragment_right, tabTwoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private class TabsPagerAdapter extends FragmentPagerAdapter {
        // As we are implementing two tabs
        private static final int NUM_ITEMS = 2;

        public TabsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        // For each tab different fragment is returned
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return tabOneFragment;

                case 1:
                    return tabTwoFragment;

                default:
                    throw new IllegalStateException("Invalid tab index");
            }
        }

        @Override
        public int getCount() { return NUM_ITEMS; }

        @Override
        public CharSequence getPageTitle(int position) {  return "Tab " + (position + 1); }

    }
}