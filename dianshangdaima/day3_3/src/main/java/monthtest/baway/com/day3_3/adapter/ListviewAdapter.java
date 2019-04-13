package monthtest.baway.com.day3_3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import monthtest.baway.com.day3_3.R;
import monthtest.baway.com.day3_3.bean.ListviewBean;

public class ListviewAdapter extends BaseAdapter {
    List<ListviewBean.ResultBean> list;
    Context context;

    public ListviewAdapter(List<ListviewBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView_item);
            holder.textView = (TextView) convertView.findViewById(R.id.textView_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ListviewBean.ResultBean bean = list.get(position);
        holder.textView.setText(bean.getName());
        Glide.with(context).load(bean.getLogo())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
