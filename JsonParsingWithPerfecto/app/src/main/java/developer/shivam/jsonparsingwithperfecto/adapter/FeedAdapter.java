package developer.shivam.jsonparsingwithperfecto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import developer.shivam.jsonparsingwithperfecto.R;
import developer.shivam.jsonparsingwithperfecto.model.Feed;

public class FeedAdapter extends BaseAdapter {

    Context context;
    List<Feed> list;

    public FeedAdapter (Context context, List<Feed> list) {
        this.context = context;
        this.list  = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class Holder {
        ImageView background;
        CircleImageView profilePic;
        TextView name;
        TextView status;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;

        if (view == null) {

            holder = new Holder();

            view = LayoutInflater.from(context).inflate(R.layout.feed_item_row, null);

            holder.name = (TextView) view.findViewById(R.id.tvName);
            holder.status = (TextView) view.findViewById(R.id.tvStatus);
            holder.profilePic = (CircleImageView) view.findViewById(R.id.ivProfilePic);
            holder.background = (ImageView) view.findViewById(R.id.ivBackground);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.name.setText(list.get(i).getName());
        holder.status.setText(list.get(i).getStatus());
        Picasso.with(context).load(list.get(i).getProfilePicture()).into(holder.profilePic);
        Picasso.with(context).load(list.get(i).getBackground()).into(holder.background);

        return view;
    }
}
