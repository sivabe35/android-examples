package developer.shivam.swiperecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import developer.shivam.swiperecyclerview.NameHolder;
import developer.shivam.swiperecyclerview.R;

public class NamesAdapter extends RecyclerView.Adapter<NameHolder> {

    List<String> names;
    Context context;

    public NamesAdapter(Context context, List<String> names) {
        this.names = names;
        this.context = context;
    }

    @Override
    public NameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.name_row_layout, null);
        return new NameHolder(view);
    }

    @Override
    public void onBindViewHolder(NameHolder holder, int position) {
        holder.tvName.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public void removeItem(int position) {
        names.remove(position);
        notifyDataSetChanged();
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, names.size());
    }
}
