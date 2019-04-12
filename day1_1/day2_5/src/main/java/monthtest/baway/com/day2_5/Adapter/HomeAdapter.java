package monthtest.baway.com.day2_5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import monthtest.baway.com.day2_5.Bean.HomeBean;
import monthtest.baway.com.day2_5.R;

public class HomeAdapter extends BaseAdapter {
    Context context;
    private List<HomeBean.ResultBean> homeBeanResult;
    private ViewHodels viewHodels;
    private View inflate;

    public HomeAdapter(Context context, List<HomeBean.ResultBean> homeBean) {
        this.context=context;
        this.homeBeanResult=homeBean;


    }

    @Override
    public int getCount() {
        return homeBeanResult.size();
    }

    @Override
    public Object getItem(int position) {
        return homeBeanResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodels viewHodels = null;
        if(convertView==null){
            viewHodels= new ViewHodels();
            convertView  = LayoutInflater.from(context).inflate(R.layout.home_list_item, null);
            viewHodels.textView=convertView.findViewById(R.id.home_list_tv);
            viewHodels.imageView=convertView.findViewById(R.id.home_list_im);
            convertView.setTag(viewHodels);
        }else {
            viewHodels= (ViewHodels) convertView.getTag();
        }

        viewHodels.textView.setText(homeBeanResult.get(position).getName());
        Glide.with(context).load(homeBeanResult.get(position).getLogo()).into(viewHodels.imageView);
        return convertView;
    }

    class  ViewHodels{
        TextView textView;
        ImageView imageView;


    }

}
