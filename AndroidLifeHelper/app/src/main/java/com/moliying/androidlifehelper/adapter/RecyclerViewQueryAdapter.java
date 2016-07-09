package com.moliying.androidlifehelper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.bean.AccountModelBean;

import java.util.List;

/**
 * Created by ldc on 2016/7/9.
 */
public class RecyclerViewQueryAdapter extends RecyclerView.Adapter<RecyclerViewQueryAdapter.ViewHolder>{
    private List<AccountModelBean> accountModelBeanList;

    public RecyclerViewQueryAdapter(List<AccountModelBean> accountModelBeanList) {
        this.accountModelBeanList = accountModelBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_query_activity_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setProjectnameTextView(accountModelBeanList.get(position).getProjectname());
        holder.setMoneyTextView(accountModelBeanList.get(position).getMoney());
        holder.setUsernameTextView(accountModelBeanList.get(position).getUsername());
        holder.setTimeTextView(accountModelBeanList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        if (accountModelBeanList != null){
            return accountModelBeanList.size();
        }
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView projectnameTextView,moneyTextView,usernameTextView,timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            projectnameTextView = (TextView) itemView.findViewById(R.id.item_query_project_name);
            moneyTextView = (TextView) itemView.findViewById(R.id.item_query_money);
            usernameTextView = (TextView) itemView.findViewById(R.id.item_query_username);
            timeTextView = (TextView) itemView.findViewById(R.id.item_query_time);
        }

        public void setProjectnameTextView(String projectname){
            if (null == projectname)return;
            projectnameTextView.setText(projectname);
        }
        public void setMoneyTextView(String money){
            if (null == money)return;
            moneyTextView.setText(money);
        }
        public void setUsernameTextView(String username){
            if (null == username)return;
            usernameTextView.setText(username);
        }
        public void setTimeTextView(String time){
            if (null == time) return;
            timeTextView.setText(time);
        }
    }
}
