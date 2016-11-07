package ruolan.com.myhearts.ui.base;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.ThroughtAdapter;

/**
 * Created by Administrator on 2016/10/21.
 */

public abstract class BaseAdapter<T, H extends BaseViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    protected static final String TAG = BaseAdapter.class.getSimpleName();

    protected final Context context;

    protected int layoutResId;

    public List<T> datas;

//    public static final int TYPE_NORMAL = 1;
//    private static final int TYPE_FOOTER = 2;

    private OnItemClickListener mOnItemClickListener = null;


    public interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

//
//    @Override
//    public int getItemViewType(int position) {
//
//        if (position + 1 == getItemCount()) {
//            return TYPE_FOOTER;
//        }
//        return TYPE_NORMAL;
//    }


    public BaseAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }


    public BaseAdapter(Context context, int layoutResId, List<T> datas) {
        this.datas = datas == null ? new ArrayList<T>() : datas;
        this.context = context;
        this.layoutResId = layoutResId;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == TYPE_FOOTER){
//            View view = LayoutInflater.from(context).inflate(R.layout.item_foot,parent,false);
//            return new FooterViewHolder(view);
//        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        BaseViewHolder vh = new BaseViewHolder(view, mOnItemClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
        if (viewHoder instanceof BaseViewHolder) {
            BaseViewHolder holder = (BaseViewHolder) viewHoder;
            T item = getItem(position);
            convert((H) holder, item);
        }
    }


    @Override
    public int getItemCount() {
        return datas == null
                ? 0 : datas.size();
    }


    public T getItem(int position) {
        if (position >= datas.size()) return null;
        return datas.get(position);
    }


    public void clear() {
//        int itemCount = datas.size();
//        datas.clear();
//        this.notifyItemRangeRemoved(0,itemCount);

        if (datas == null || datas.size() <= 0)
            return;

        for (Iterator it = datas.iterator(); it.hasNext(); ) {

            T t = (T) it.next();
            int position = datas.indexOf(t);
            it.remove();
            notifyItemRemoved(position);
        }
    }

    /**
     * 从列表中删除某项
     *
     * @param t
     */
    public void removeItem(T t) {

        int position = datas.indexOf(t);
        datas.remove(position);
        notifyItemRemoved(position);
    }


    public List<T> getDatas() {

        return datas;
    }


    public void addData(List<T> datas) {

        addData(0,datas);
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addData(int position, List<T> list) {

        if (list != null && list.size() > 0) {

            for (T t : list) {
                datas.add(position, t);
                notifyItemInserted(position);
            }

        }
    }


    public void refreshData(List<T> list) {

        clear();
        if (list != null && list.size() > 0) {


            int size = list.size();
            for (int i = 0; i < size; i++) {
                datas.add(i, list.get(i));
                notifyItemInserted(i);
            }

        }
    }

    public void loadMoreData(List<T> list) {

        if (list != null && list.size() > 0) {

            int size = list.size();
            int begin = datas.size();
            for (int i = 0; i < size; i++) {
                datas.add(list.get(i));
                notifyItemInserted(i + begin);
            }

        }

    }


    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param viewHoder A fully initialized helper.
     * @param item      The item that needs to be displayed.
     */
    protected abstract void convert(H viewHoder, T item);


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;

    }


    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


}
