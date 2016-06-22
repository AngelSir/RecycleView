package zhang.buaa.com.myapplication002;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> datas;
    private LayoutInflater mInflater;
    private onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mText.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mText;

        public ViewHolder(final View itemView) {
            super(itemView);
            //绑定控件
            mText = (TextView) itemView.findViewById(R.id.mtext1);
            //自己设置监听事件的时候，需要在Adapter中进行申明
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.setOnClick(v, getLayoutPosition(), datas.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    //设置监听因为这个控件没有自带的onClick事件所以需要自己去写监听的控件
    interface onItemClickListener {
        void setOnClick(View v, int position, String name);
    }

    //数据的更新notifyItemInserted(position),notifyItemRemoved(position)
    //添加两个方法用于更新数据
    public void addData(int position,String name){
        datas.add(position,"基德");
        notifyItemInserted(position);
    }
    public void daleteData(int position){
        datas.remove(position);
        notifyItemRemoved(position);
    }

}
