package coopon.manimaran.about_us_activity.adapter;

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

import coopon.manimaran.about_us_activity.R;
import coopon.manimaran.about_us_activity.model.ThirdPartyLibModel;

public class ThirdPartyLibraryAdapter extends RecyclerView.Adapter<ThirdPartyLibraryAdapter.ViewHolder> {

    private List<ThirdPartyLibModel> mList;
    private Context mContext;

    public ThirdPartyLibraryAdapter(Context context, List<ThirdPartyLibModel> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        int pos = holder.getAdapterPosition();
        final ThirdPartyLibModel model = mList.get(pos);
        holder.txtName.setText(model.getName());
        holder.txtLicense.setText(model.getLicense());

        holder.btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(mContext, holder.btnOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.option_for_third_party_library);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int i = item.getItemId();
                        String url = null;
                        if (i == R.id.web_page) {//handle web page
                            url = model.getUrl();
                        } else if (i == R.id.license_url) {//handle license url
                            url = model.getLicense_url();
                        }
                        Activity activity = (Activity) mContext;
                        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_third_party_library, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /* adapter view holder */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtLicense;
        ImageView btnOption;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtLicense = itemView.findViewById(R.id.txt_license);
            btnOption = itemView.findViewById(R.id.btn_option);
        }

    }

}
