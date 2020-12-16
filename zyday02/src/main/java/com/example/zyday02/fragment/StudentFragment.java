package com.example.zyday02.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zyday02.R;
import com.example.zyday02.adapter.HomeStuRlvAdapter;
import com.example.zyday02.model.bean.StudentBean;
import com.example.zyday02.presenter.HomeStudentPresenterImllp;
import com.example.zyday02.view.IHomeStudentsView;
import com.example.zyday02.view.IVHomeView;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment implements IHomeStudentsView {
    private RecyclerView stu_rlv;
    private ArrayList<StudentBean.StudenlistDTO> mList;
    private HomeStuRlvAdapter mRlvAdapter;
    private HomeStudentPresenterImllp presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        initView(view);
        initDate();
        return view;
    }

    private void initView(View view) {
        stu_rlv=view.findViewById(R.id.stu_rlv);
        stu_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        stu_rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        mList = new ArrayList<>();
        mRlvAdapter = new HomeStuRlvAdapter(getActivity(), mList);

    }

    private void initDate() {
        presenter = new HomeStudentPresenterImllp(this);
        presenter.start();
    }

    @Override
    public void onShowScuess(Object object) {
        if(object instanceof StudentBean){
            StudentBean bean= (StudentBean) object;
            List<StudentBean.StudenlistDTO> list = bean.getStudenlist();
            mList.addAll(list);
            mRlvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onShowFail(String errorMsg) {
        Log.e("TAG","网络数据错误"+errorMsg);
    }
}