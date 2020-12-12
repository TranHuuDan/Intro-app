package com.example.doanjavak17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InforViewHolder> {
    private Context mContext;
    private List<Information> mlist;

    public InformationAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Information> list){
        this.mlist=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public InforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.information, parent,false);
        return new InforViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InforViewHolder holder, int position) {
        Information information=mlist.get(position);
        if(information==null)
        {
            return;
        }
        holder.imgView.setImageResource(information.getResourceimage());
        holder.tvName.setText(information.getName());
        holder.tvValue.setText(information.getValue());
    }

    @Override
    public int getItemCount() {
        if(mlist!=null)
        {
            return mlist.size();
        }
        return 0;
    }

    public class InforViewHolder extends RecyclerView.ViewHolder{
    private ImageView imgView;
    private TextView tvName,tvValue;
    public InforViewHolder(@NonNull View itemView) {
        super(itemView);
        imgView=itemView.findViewById(R.id.hinhinfo);
        tvName=itemView.findViewById(R.id.tv_inforname);
        tvValue=itemView.findViewById(R.id.tv_inforvalue);
    }
}
}