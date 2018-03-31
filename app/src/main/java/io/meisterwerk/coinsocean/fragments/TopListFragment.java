package io.meisterwerk.coinsocean.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

import io.meisterwerk.coinsocean.R;
import io.meisterwerk.coinsocean.adapters.TopListAdapter;
import io.meisterwerk.coinsocean.listeners.OnClickListener;
import io.meisterwerk.coinsocean.model.TestModel;

public class TopListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TabLayout mTabLayout;
    private static ArrayList<TestModel> someStatic;

    private OnFragmentInteractionListener mListener;
    private OnClickListener mOnClickListener = position -> Log.e(": ", position + "");

    public TopListFragment() {
    }

    static {
        someStatic = new ArrayList<TestModel>() {{
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));
            add(new TestModel("some", false));
            add(new TestModel("some", true));

        }};
    }

    public static TopListFragment newInstance(String param1, String param2) {
        TopListFragment fragment = new TopListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_top_list, container, false);
        View slider = rootView.findViewById(R.id.view);
        final RecyclerView topListRecyclerView = rootView.findViewById(R.id.top_list_recycler_view);

        slider.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return false;
            }
        });

        setupRecyclerView(topListRecyclerView);
        setupTabLayout(rootView);

        return rootView;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupRecyclerView(RecyclerView topListRecyclerView) {
        topListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        topListRecyclerView.setMotionEventSplittingEnabled(false);
        topListRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                topListRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                for (int i = 0; i < topListRecyclerView.getChildCount(); i++) {
                    View v = topListRecyclerView.getChildAt(i);
                    v.setAlpha(0.3f);
                    v.animate().alpha(1.0f)
                            .setDuration(250)
                            .setStartDelay(i * 50)
                            .start();
                }
                return true;
            }
        });
        TopListAdapter topListAdapter = new TopListAdapter(getActivity(), mOnClickListener, someStatic);
        topListRecyclerView.setAdapter(topListAdapter);
    }

    private void setupTabLayout(View rootView) {
        mTabLayout = rootView.findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("FAVORITES"));
        mTabLayout.addTab(mTabLayout.newTab().setText("MARKET CAP"));
        mTabLayout.addTab(mTabLayout.newTab().setText("PRICE"));
        mTabLayout.addTab(mTabLayout.newTab().setText("24H PERC"));
        mTabLayout.addTab(mTabLayout.newTab().setText("24H VOLUME"));

        setupTabListeners(mTabLayout);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setupTabListeners(TabLayout tabLayout) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    void selectPage(TabLayout tabLayout, int pageIndex) {
        tabLayout.getTabAt(pageIndex).select();
        tabLayout.setScrollPosition(pageIndex, 1f, true);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
