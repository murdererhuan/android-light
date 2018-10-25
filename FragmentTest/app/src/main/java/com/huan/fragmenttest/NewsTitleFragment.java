package com.huan.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {

    private Boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        //填充数据
        RecyclerView newTitleRecyclerView=(RecyclerView)view.findViewById(R.id.news_title_recycle_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        newTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter=new NewsAdapter(getNews());
        newTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
                isTwoPane=true;//找到喂双页模式
        }else {
            isTwoPane=false; //找不到为单页模式
        }
    }

    public List<New> getNews() {
        List<New> newList=new ArrayList<>();
        for (int i=1;i<=50;i++){
            New news=new New();
            news.setTitle("This is news title"+i);
            news.setContent(getRandomLengthContent("This is news content " + i + ". "));
            newList.add(news);
        }
        return newList;
    }

    private String getRandomLengthContent(String s) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<=length;i++){
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<New> mNewList;


        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView newsTitleText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                newsTitleText=(TextView)itemView.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<New> mNewList) {
            this.mNewList = mNewList;
        }

        @NonNull
        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item,viewGroup,false);
            final ViewHolder holder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    New news=mNewList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        //如果是双页模式，则刷新NewsContentFragment中的内容
                        NewsContentFragment newsContentFragment=(NewsContentFragment) getFragmentManager()
                                .findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else {
                        //如果是单页模式，则直接启动NewsContentActivity
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
            New news=mNewList.get(i);
            viewHolder.newsTitleText.setText(news.getTitle());

        }

        @Override
        public int getItemCount() {
            return mNewList.size();
        }


    }
}
