package com.jaydip.dropshadowforinsta.creation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import java.io.File;
import java.util.ArrayList;

public class Galleryadapter extends BaseAdapter {
    private static LayoutInflater inflater;
    private final Activity activity;
    ArrayList<String> imagegallary = new ArrayList<>();
    SparseBooleanArray mSparseBooleanArray;

    public long getItemId(int i) {
        return (long) i;
    }

    static class ViewHolder {
        ImageView imgDelete;
        ImageView imgIcon;
        ImageView imgShare;

        ViewHolder() {
        }
    }

    public Galleryadapter(Activity activity2, ArrayList<String> arrayList) {
        this.activity = activity2;
        this.imagegallary = arrayList;
        inflater = (LayoutInflater) activity2.getSystemService("layout_inflater");
        this.mSparseBooleanArray = new SparseBooleanArray(this.imagegallary.size());
    }

    public int getCount() {
        return this.imagegallary.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(final int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.activity).inflate(R.layout.list_gallery, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            viewHolder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            viewHolder.imgShare = (ImageView) view.findViewById(R.id.imgShare);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imgShare.setOnClickListener(new View.OnClickListener() {
            class C03301 implements DialogInterface.OnClickListener {
                C03301() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Glob.app_name);
                    sb.append(" Created By : ");
                    sb.append("https://play.google.com/store/apps/details?id=" + Galleryadapter.this.activity.getPackageName());
                    Galleryadapter.this.shareImage(sb.toString(), Galleryadapter.this.imagegallary.get(i2));
                }
            }

            class C03312 implements DialogInterface.OnClickListener {
                C03312() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Galleryadapter.this.activity);
                builder.setTitle("Confirm Share...");
                builder.setMessage("Are you sure you want Share this?");
                builder.setPositiveButton("YES", new C03301());
                builder.setNegativeButton("NO", new C03312());
                builder.show();
            }
        });
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            class C03331 implements DialogInterface.OnClickListener {
                C03331() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    File file = new File(Galleryadapter.this.imagegallary.get(i2));
                    if (file.exists()) {
                        file.delete();
                    }
                    Galleryadapter.this.imagegallary.remove(i2);
                    Galleryadapter.this.notifyDataSetChanged();
                    if (Galleryadapter.this.imagegallary.size() == 0) {
                        Toast.makeText(Galleryadapter.this.activity, "No Image Found..", Toast.LENGTH_LONG).show();
                    }
                }
            }

            class C03342 implements DialogInterface.OnClickListener {
                C03342() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Galleryadapter.this.activity);
                builder.setTitle("Confirm Delete...");
                builder.setMessage("Are you sure you want delete this?");
                builder.setPositiveButton("YES", new C03331());
                builder.setNegativeButton("NO", new C03342());
                builder.show();
            }
        });
        Glide.with(this.activity).load(this.imagegallary.get(i2)).into(viewHolder.imgIcon);
        System.gc();
        return view;
    }

    public void shareImage(String str, String str2) {
        MediaScannerConnection.scanFile(this.activity, new String[]{str2}, null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String str, Uri uri) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.putExtra("android.intent.extra.STREAM", uri);
                Galleryadapter.this.activity.startActivity(Intent.createChooser(intent, "Share image"));
            }
        });
    }
}
