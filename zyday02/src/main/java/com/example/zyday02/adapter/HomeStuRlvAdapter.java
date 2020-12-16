package com.example.zyday02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zyday02.R;
import com.example.zyday02.model.bean.StudentBean;

import java.util.ArrayList;

public class HomeStuRlvAdapter extends RecyclerView.Adapter<HomeStuRlvAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentBean.StudenlistDTO> mList;

    public HomeStuRlvAdapter(Context mContext, ArrayList<StudentBean.StudenlistDTO> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentBean.StudenlistDTO dto = mList.get(position);
        holder.name.setText(dto.getName());
        holder.skill.setText(dto.getSkill());
        holder.theory.setText(dto.getTheory());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView skill;
        private TextView theory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.item_studet_name);
            skill=itemView.findViewById(R.id.item_studet_skill);
            theory=itemView.findViewById(R.id.item_studet_theory);
        }
    }
}
