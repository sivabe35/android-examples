package developer.shivam.swiperecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NameHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvName;

    public NameHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("Developer Name", ((TextView) view.findViewById(R.id.tvName)).getText().toString());
    }
}
