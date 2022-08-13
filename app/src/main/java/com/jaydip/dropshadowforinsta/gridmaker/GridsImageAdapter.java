package com.jaydip.dropshadowforinsta.gridmaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class GridsImageAdapter extends RecyclerView.Adapter<GridsImageAdapter.ViewHolder> {
    private final List<Bitmap> list;

    public GridsImageAdapter(List<Bitmap> list2) {
        this.list = list2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_grids, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.imgv.setImageBitmap(this.list.get(i));
        viewHolder.tvPos.setText(String.valueOf(this.list.size() - i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.jaydip.storymakerforinsta.gridmaker.GridsImageAdapter.AnonymousClass1 */

            public void onClick(View view) {
                viewHolder.tvPos.setBackgroundResource(R.drawable.bg_item_adapter_seleted);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", GridsImageAdapter.this.getImageUri(view.getContext(), (Bitmap) GridsImageAdapter.this.list.get(i)));
                intent.setPackage("com.instagram.android");
                view.getContext().startActivity(Intent.createChooser(intent, "Share.."));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Uri getImageUri(Context context, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", (String) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgv;
        private final TextView tvPos;

        public ViewHolder(View view) {
            super(view);
            this.imgv = (ImageView) view.findViewById(R.id.imgv);
            this.tvPos = (TextView) view.findViewById(R.id.tvPos);
        }
    }
}
