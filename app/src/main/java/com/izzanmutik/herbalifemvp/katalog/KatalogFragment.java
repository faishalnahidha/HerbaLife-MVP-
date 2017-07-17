package com.izzanmutik.herbalifemvp.katalog;


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
import com.izzanmutik.herbalifemvp.model.Katalog;
import com.izzanmutik.herbalifemvp.other.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KatalogFragment extends Fragment implements KatalogContract.View {

    //private List<Katalog> mKatalogList = new ArrayList<>();

    private KatalogContract.Presenter mPresenter;

    private KatalogAdapter mAdapter;

    private RecyclerView mRecyclerView;


    public KatalogFragment() {
        // Required empty public constructor
    }

    public static KatalogFragment newInstance() {
        return new KatalogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new KatalogAdapter(new ArrayList<Katalog>(0), mItemListener);
        mPresenter = new KatalogPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public void setPresenter(KatalogContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_katalog, container, false);

        // Set up katalog view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.katalog_recyclerView);
        mRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    /**
     * Listener for clicks on katalog in RecyclerView
     */
    KatalogItemListener mItemListener = new KatalogItemListener() {
        @Override
        public void onClick(View view, int position) {
            Katalog mKatalog = mAdapter.getItem(position);
            mPresenter.openDetailKatalog(mKatalog);
        }
    };

    @Override
    public void showKatalog(List<Katalog> katalogList) {
        mAdapter.replaceData(katalogList);
    }

    @Override
    public void showDetailKatalog(long id) {

    }

    public static class KatalogAdapter
            extends RecyclerView.Adapter<KatalogFragment.KatalogAdapter.MyViewHolder> {

        private List<Katalog> mKatalogList;
        private KatalogItemListener mItemListener;

        private ColorGenerator generator = ColorGenerator.MATERIAL;

        public KatalogAdapter(List<Katalog> katalogList, KatalogItemListener itemListener) {
            setList(katalogList);
            this.mItemListener = itemListener;
        }

        public void replaceData(List<Katalog> katalogList){
            setList(katalogList);
            notifyDataSetChanged();
        }

        private void setList(List<Katalog> katalogList){
            mKatalogList = katalogList;
        }

        public Katalog getItem(int position) {
            return mKatalogList.get(position);
        }

        public long getItemId(int position) {
            return mKatalogList.get(position).getId();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_katalog, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            Katalog mKatalog = mKatalogList.get(position);
            holder.nama.setText(mKatalog.getNama());

            String letter = String.valueOf(mKatalog.getNama().substring(0, 2));
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(letter, generator.getColor(getItem(position)));
            holder.letterIcon.setImageDrawable(drawable);

        }

        @Override
        public int getItemCount() {
            return mKatalogList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{

            public TextView nama;
            public ImageView letterIcon;

            public MyViewHolder(View itemView) {
                super(itemView);
                nama = (TextView) itemView.findViewById(R.id.rowKatalog_textViewNama);
                letterIcon = (ImageView) itemView.findViewById(R.id.rowPenyakit_imageView);

            }

            @Override
            public void onClick(View v) {
                mItemListener.onClick(v, getAdapterPosition());
            }
        }

    }

    public interface KatalogItemListener {

        void onClick(View view, int position);
    }
}
