package io.meisterwerk.coinsocean.adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.meisterwerk.coinsocean.R;
import io.meisterwerk.coinsocean.listeners.OnClickListener;
import io.meisterwerk.coinsocean.model.TestModel;

public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.ViewHolder> {

    private Context mContext;
    private OnClickListener mClickListener;
    private ArrayList<TestModel> mSome;
    private View mView;

    public TopListAdapter(Context context, OnClickListener clickListener, ArrayList<TestModel> some) {
        mContext = context;
        mClickListener = clickListener;
        mSome = some;
    }

    @Override
    public TopListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_list_item, parent, false);
        return new TopListAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final TopListAdapter.ViewHolder holder, int position) {
        @DrawableRes int resId = mSome.get(position).isGrowing() ? R.drawable.top_list_background_gradient_growing : R.drawable.top_list_background_gradient_downfall;
        holder.containerItem.setBackground(mContext.getDrawable(resId));
    }

    @Override
    public int getItemCount() {
        return mSome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout containerItem;

        public ViewHolder(View view) {
            super(view);

            containerItem = mView.findViewById(R.id.container_item);
            view.setOnClickListener(v -> mClickListener.onItemClickListener(getAdapterPosition()));
        }
    }
}

