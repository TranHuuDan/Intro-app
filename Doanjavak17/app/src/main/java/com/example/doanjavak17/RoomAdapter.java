package com.example.doanjavak17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RomViewHolder> {
    private Context mContext;
    private List<Room> mListRom;
    private OnItemClickListener listener;
    public RoomAdapter(Context mContext, OnItemClickListener listener) {
        this.mContext = mContext;
        this.listener=listener;
    }
    public void setData(List<Room> list)
    {
    this.mListRom=list;
    notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rom, parent,false);

        return new RomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RomViewHolder holder, int position) {
        holder.bindData(mListRom.get(position));
    }

    @Override
    public int getItemCount() {
        if(mListRom!=null)
        {
            return mListRom.size();
        }
        return 0;
    }

    public class RomViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageRom;
        private TextView tvRom;
        private Room romTemp;
        public RomViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(romTemp);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(romTemp);
                    return false;
                }
            });
            imageRom=itemView.findViewById(R.id.hinh);
            tvRom=itemView.findViewById(R.id.tv);
        }
        private void bindData(Room rom)
        {

        this.romTemp=rom;
//        imageRom.setImageResource(rom.getResourceimage());
        tvRom.setText(rom.getName());
        Glide.with(mContext).load(rom.getResourceimage()).into(imageRom);
        }
    }
}
