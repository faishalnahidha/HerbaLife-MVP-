package com.izzanmutik.herbalifemvp.penyakit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.izzanmutik.herbalifemvp.R;
import com.izzanmutik.herbalifemvp.model.Penyakit;
import com.izzanmutik.herbalifemvp.other.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PenyakitFragment extends Fragment implements PenyakitContract.View {

    private PenyakitContract.Presenter mPresenter;

    private PenyakitAdapter mAdapter;

    private RecyclerView mRecyclerView;

    public PenyakitFragment() {
        // Required empty public constructor
    }

    public static PenyakitFragment newInstance() {
        return new PenyakitFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mAdapter = new PenyakitAdapter(new ArrayList<Penyakit>(0), mItemListener);
        mPresenter = new PenyakitPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_penyakit, container, false);

        // Set up penyakit view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.penyakit_recyclerView);
        mRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    /**
     * Listener for clicks on penyakit in RecyclerView
     */
    PenyakitItemListener mItemListener = new PenyakitItemListener() {
        @Override
        public void onClick(View view, int position) {
            Penyakit mPenyakit= mAdapter.getItem(position);
            mPresenter.openDetailPenyakit(mPenyakit);
        }
    };

    @Override
    public void showPenyakitList(List<Penyakit> penyakitList) {
        mAdapter.replaceData(penyakitList);
    }

    @Override
    public void showDetailPenyakit(long id) {

    }

    @Override
    public void setPresenter(PenyakitContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public static class PenyakitAdapter
            extends RecyclerView.Adapter<PenyakitFragment.PenyakitAdapter.MyViewHolder> {

        private List<Penyakit> mPenyakitList;
        private PenyakitItemListener mItemListener;

        private ColorGenerator generator = ColorGenerator.MATERIAL;

        public PenyakitAdapter(List<Penyakit> penyakitList, PenyakitItemListener itemListener) {
            setList(penyakitList);
            this.mItemListener = itemListener;
        }

        public void replaceData(List<Penyakit> katalogList){
            setList(katalogList);
            notifyDataSetChanged();
        }

        private void setList(List<Penyakit> katalogList){
            mPenyakitList= katalogList;
        }

        public Penyakit getItem(int position){
            return mPenyakitList.get(position);
        }

        public long getItemId(int position){
            return mPenyakitList.get(position).getId();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_penyakit, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PenyakitAdapter.MyViewHolder holder, int position) {
            Penyakit mPenyakit = mPenyakitList.get(position);
            holder.nama.setText(mPenyakit.getNama());

            String letter = String.valueOf(mPenyakit.getNama().charAt(0));
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(letter, generator.getColor(getItem(position)));
            holder.letterIcon.setImageDrawable(drawable);
        }

        @Override
        public int getItemCount() {
            return mPenyakitList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder
                implements View.OnClickListener{

            public TextView nama;
            public ImageView letterIcon;

            public MyViewHolder(View itemView) {
                super(itemView);
                nama = (TextView) itemView.findViewById(R.id.rowPenyakit_textViewNama);
                letterIcon = (ImageView) itemView.findViewById(R.id.rowPenyakit_imageView);

            }

            @Override
            public void onClick(View v) {
                mItemListener.onClick(v, getAdapterPosition());
            }
        }
    }

    public interface PenyakitItemListener {

        void onClick(View view, int position);
    }
}
