package com.teamdroid.algoninja;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;


/**
 * Created by Murali on 14-06-2015.
 */
public class AlgoListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;
    public AlgorithmLab algorithmLab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //myDataset = getResources().getStringArray(R.array.algorithm_name);
        algorithmLab = new AlgorithmLab(getActivity());
        ArrayList<Algorithm> myDataset = algorithmLab.getAlgorithmArrayList();
        View view = inflater.inflate(R.layout.fragment_algo_list, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);


        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        Log.i("MY_APP_LOG","onCreateView() called");
        return view;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<Algorithm> mDataset;


        public MyAdapter(ArrayList<Algorithm> myDataset) {
            mDataset = myDataset;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.i("MY_APP_LOG","onCreateViewHolder() called");
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_algo_row, parent, false);


            ViewHolder vh = new ViewHolder(MaterialRippleLayout.on(v)
                    .rippleOverlay(false)
                    .rippleAlpha(0.2f)
                    .rippleColor(0xFF585858)//
                    .rippleHover(true)
                    .create());
            return vh;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Log.i("MY_APP_LOG","onBindViewHolder() called");
            holder.algoNameTextView.setText(mDataset.get(position).getName());    //

        }


        @Override
        public int getItemCount() {
            Log.i("MY_APP_LOG","getItemCount() called");
            return mDataset.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView algoNameTextView;
            public TextView difficultyTextView;
            CheckBox favouriteCheckBox;

            public ViewHolder(View v) {
                super(v);
                algoNameTextView = (TextView) v.findViewById(R.id.algoNameTextView);
                difficultyTextView = (TextView) v.findViewById(R.id.difficultyTextView);
                favouriteCheckBox = (CheckBox) v.findViewById(R.id.favouriteCheckBox);
                v.setOnClickListener(this);
                Log.i("MY_APP_LOG","ViewHolder constructor called");
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlgoDetailActivity.class);
                intent.putExtra(AlgoDetailActivity.ALGO_NAME, mDataset.get(getPosition()).getName());
                intent.putExtra(AlgoDetailActivity.ALGO_INDEX,getPosition());
                startActivity(intent);
                //Toast.makeText(getActivity(),"Ripple is good",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
