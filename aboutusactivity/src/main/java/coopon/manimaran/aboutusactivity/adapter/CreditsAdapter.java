package coopon.manimaran.aboutusactivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import coopon.manimaran.aboutusactivity.R;
import coopon.manimaran.aboutusactivity.model.CreditsModel;
import coopon.manimaran.aboutusactivity.model.ThirdPartyLibModel;

public class CreditsAdapter extends RecyclerView.Adapter<CreditsAdapter.ViewHolder> {

    private List<CreditsModel> mList;
    private Context mContext;

    public CreditsAdapter(Context context, List<CreditsModel> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        int pos = holder.getAdapterPosition();
        final CreditsModel model = mList.get(pos);
        holder.txtName.setText(model.getName());
        holder.txtAbout.setText(model.getAbout());

        holder.btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) mContext;
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(model.getUrl())));
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credits, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /* adapter view holder */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtAbout;
        ImageView btnOption;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAbout = itemView.findViewById(R.id.txt_about);
            btnOption = itemView.findViewById(R.id.btn_option);
        }

    }

}
