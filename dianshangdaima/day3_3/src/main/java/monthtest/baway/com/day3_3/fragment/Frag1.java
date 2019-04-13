package monthtest.baway.com.day3_3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import monthtest.baway.com.day3_3.R;
import monthtest.baway.com.day3_3.adapter.ListviewAdapter;
import monthtest.baway.com.day3_3.bean.ListviewBean;
import monthtest.baway.com.day3_3.mvp.showmvp.IShowContract;
import monthtest.baway.com.day3_3.mvp.showmvp.Presenter;

public class Frag1 extends Fragment implements IShowContract.IView {

    private ListView listview;
    private Presenter presenter;
    private Gson gson;
    private ListviewBean listviewBean;
    private ListviewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        listview = view.findViewById(R.id.listview);
        presenter = new Presenter();
        presenter.attch(this);
        return view;
    }

    @Override
    public void getPresenter(String name) {
        gson = new Gson();
        listviewBean = gson.fromJson(name, ListviewBean.class);
        List<ListviewBean.ResultBean> result = listviewBean.getResult();
        adapter = new ListviewAdapter(result, getActivity());
        listview.setAdapter(adapter);
    }
}
