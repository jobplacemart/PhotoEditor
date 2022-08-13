package com.jaydip.dropshadowforinsta.panorama;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.jaydip.dropshadowforinsta.R;
//import com.google.android.material.timepicker.TimeModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressLint("WrongConstant")
public class PSPanoramaResultActivity extends PSBaseActivity implements View.OnClickListener {
    public static final String TAG = "PSPanoramaResultActivity";
    String MY_PREFS_NAME = "share_pref";
    public String SelectFileName = "";
    LinearLayout btn_back;
    public TextView count;
    private LinearLayout delete_images;
    private String delete_temp_path;
    public ProgressDialog dialog;
    private String directory_name;
    public String directory_path;
    private TextView[] dots;
    private Boolean from_main;
    LinearLayout image_layout;
    ArrayList<String> images = new ArrayList<>();
    public Boolean is_save = false;
    LinearLayout layoutDots;
    LinearLayout layout_tutorial;
    public LinearLayout ll_count;
    public String result_image_uri;
    LinearLayout save_image;
    private String select_image_uri;
    int sequen;
    ArrayList<String> sequence_images = new ArrayList<>();
    LinearLayout share_post;
    public String temp_path;
    ImageView uCropView;
    ViewPager viewPager;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (!this.from_main.booleanValue()) {
            super.onBackPressed();
        } else if (!this.is_save.booleanValue()) {
            back();
        } else {
            back();
        }
    }

    public void back() {
        delete_temp_folder(this.delete_temp_path);
        super.onBackPressed();
    }

    public boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                File file2 = new File(file, list[i]);
                boolean deleteDir = deleteDir(new File(file, list[i]));
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                if (!deleteDir) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public void delete_temp_folder(String str) {
        if (new File(str).exists()) {
            deleteDir(new File(str));
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        FindViewById();
        this.delete_temp_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + getString(R.string.folder_name) + File.separator + getString(R.string.folder_panorama) + File.separator + ".temp";
        int i = getResources().getDisplayMetrics().widthPixels;
        ViewGroup.LayoutParams layoutParams = this.image_layout.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.image_layout.setLayoutParams(layoutParams);
        Intent intent = getIntent();
        Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("from_main", false));
        this.from_main = valueOf;
        if (valueOf.booleanValue()) {
            this.sequen = intent.getIntExtra("row_count", 2);
            this.select_image_uri = intent.getStringExtra("select_image_uri");
            this.result_image_uri = intent.getStringExtra("result_uri");
            this.SelectFileName = getFileName(Uri.parse(this.select_image_uri));
            new spiltimages().execute(new Void[0]);
        } else {
            this.save_image.setVisibility(8);
            this.delete_images.setVisibility(0);
            this.share_post.setVisibility(0);
            this.directory_name = intent.getStringExtra("directory_name");
            this.directory_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + getString(R.string.folder_name) + File.separator + getString(R.string.folder_panorama) + File.separator + this.directory_name;
            this.sequence_images = new ArrayList<>();
            File[] listFiles = new File(this.directory_path).listFiles();
            int length = listFiles.length;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                Log.e("directory_name", "onCreate: " + listFiles[i2].getAbsolutePath());
                if (!listFiles[i2].getAbsolutePath().contains("main_image")) {
                    this.sequence_images.add(listFiles[i2].getAbsolutePath());
                }
            }
            Collections.sort(this.sequence_images, new Comparator<String>() {
                public int compare(String str, String str2) {
                    return String.valueOf(Utitlity.getFileNameWithoutExtension(new File(str))).compareToIgnoreCase(String.valueOf(Utitlity.getFileNameWithoutExtension(new File(str2))));
                }
            });
            this.ll_count.setVisibility(0);
            this.viewPager.measure(-1, -2);
            this.viewPager.setAdapter(new PSViewPagerAdapter(this, this.sequence_images));
            TextView textView = this.count;
            textView.setText("1/" + this.sequence_images.size());
            addBottomDots(0);
        }
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int i) {
            }

            @Override
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
                PSPanoramaResultActivity.this.addBottomDots(i);
                TextView textView = PSPanoramaResultActivity.this.count;
                textView.setText("" + (i + 1) + "/" + PSPanoramaResultActivity.this.sequence_images.size());
                StringBuilder sb = new StringBuilder();
                sb.append("onPageSelected: ");
                sb.append(i);
                Log.e("onPageSelected", sb.toString());
            }
        });
    }

    @SuppressLint("Range")
    public String getFileName(Uri uri) {
        String str = null;
        if (uri.getScheme().equals("content")) {
            Cursor query = getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndex("_display_name"));
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
        }
        if (str != null) {
            return str;
        }
        String path = uri.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    public void FindViewById() {
        this.ll_count = (LinearLayout) findViewById(R.id.ll_count);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.btn_back);
        this.btn_back = linearLayout;
        linearLayout.setOnClickListener(this);
        this.image_layout = (LinearLayout) findViewById(R.id.image_layout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.layout_tutorial);
        this.layout_tutorial = linearLayout2;
        linearLayout2.setOnClickListener(this);
//        this.uCropView = (ImageView) findViewById(R.id.ucrop);
        this.count = (TextView) findViewById(R.id.count);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.save_images);
        this.save_image = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.share_post);
        this.share_post = linearLayout4;
        linearLayout4.setOnClickListener(this);
        this.layoutDots = (LinearLayout) findViewById(R.id.layoutDots);
        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.delete_images);
        this.delete_images = linearLayout5;
        linearLayout5.setOnClickListener(this);
    }

    public void addBottomDots(int i) {
        TextView[] textViewArr;
        this.dots = new TextView[this.sequence_images.size()];
        this.layoutDots.removeAllViews();
        int i2 = 0;
        while (true) {
            textViewArr = this.dots;
            if (i2 >= textViewArr.length) {
                break;
            }
            textViewArr[i2] = new TextView(this);
            this.dots[i2].setText(Html.fromHtml("&#8226;"));
            this.dots[i2].setTextSize(35.0f);
            this.dots[i2].setTextColor(getResources().getColor(R.color.dot_dark_screen3));
            this.layoutDots.addView(this.dots[i2]);
            i2++;
        }
        if (textViewArr.length > 0) {
            textViewArr[i].setTextColor(getResources().getColor(R.color.active_color));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /*{ENCODED_INT: 2131296378}*/:
                onBackPressed();
                return;
            case R.id.delete_images /*{ENCODED_INT: 2131296459}*/:
                if (new File(this.directory_path).exists()) {
                    DialogInterface.OnClickListener r3 = new DialogInterface.OnClickListener() {
                        /* class com.jaydip.storymakerforinsta.panorama.PSPanoramaResultActivity.AnonymousClass3 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                PSPanoramaResultActivity pSPanoramaResultActivity = PSPanoramaResultActivity.this;
                                pSPanoramaResultActivity.delete_temp_folder(pSPanoramaResultActivity.directory_path);
                                PSPanoramaResultActivity.this.onBackPressed();
                            }
                        }
                    };
                    new AlertDialog.Builder(this, R.style.MyDialogTheme).setMessage("Delete this photos?").setPositiveButton("Yes", r3).setNegativeButton("No", r3).show();
                    return;
                }
                Toast.makeText(this, "Photo doesn't exit", 0).show();
                return;
            case R.id.layout_tutorial /*{ENCODED_INT: 2131296596}*/:
                startActivity(new Intent(this, PSTutorialActivity.class));
                return;
            case R.id.save_images /*{ENCODED_INT: 2131296737}*/:
                new saveimages().execute(new Void[0]);
                return;
            case R.id.share_post /*{ENCODED_INT: 2131296771}*/:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage("com.instagram.android");
                try {
                    startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(this, "Instagram Not Installed!", 1).show();
                    return;
                }
            default:
                return;
        }
    }

    public void Spilt_images(String str) {
        try {
            if (Uri.parse(str) != null) {
                this.images = splitBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(str)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void SaveBitmapSpilt(Bitmap bitmap, int i, String str) {
        File file = new File(str, String.format("%02d", Integer.valueOf(i + 1)) + ".jpeg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(file.getAbsolutePath()))));
            this.sequence_images.add(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public ArrayList<String> splitBitmap(Bitmap bitmap) {
        String.valueOf(System.currentTimeMillis());
        this.temp_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + getString(R.string.folder_name) + File.separator + getString(R.string.folder_panorama) + File.separator + ".temp" + File.separator + this.SelectFileName;
        if (!new File(this.temp_path).exists()) {
            new File(this.temp_path).mkdirs();
        }
        int i = 0;
        for (int i2 = 0; i2 < this.sequen; i2++) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, 0, bitmap.getWidth() / this.sequen, bitmap.getHeight());
            i += bitmap.getWidth() / this.sequen;
            this.images.add(String.valueOf(createBitmap));
            SaveBitmapSpilt(createBitmap, i2, this.temp_path);
        }
        return this.images;
    }

    public void copyFileToDownloads(Uri uri, String str) throws Exception {
        File file = new File(str, "main_image.png");
        FileInputStream fileInputStream = new FileInputStream(new File(uri.getPath()));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
        fileInputStream.close();
        fileOutputStream.close();
    }

    public void copyDirectoryOneLocationToAnotherLocation(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i = 0; i < file.listFiles().length; i++) {
                copyDirectoryOneLocationToAnotherLocation(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(file2.getAbsolutePath()))));
                return;
            }
        }
    }

    private class saveimages extends AsyncTask<Void, Void, Void> {
        private saveimages() {
        }

        public void onPreExecute() {
            PSPanoramaResultActivity.this.dialog = new ProgressDialog(PSPanoramaResultActivity.this);
            PSPanoramaResultActivity.this.dialog.setMessage("Please wait...");
            PSPanoramaResultActivity.this.dialog.setCancelable(false);
            PSPanoramaResultActivity.this.dialog.show();
        }

        public Void doInBackground(Void... voidArr) {
            String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + PSPanoramaResultActivity.this.getString(R.string.folder_name) + File.separator + PSPanoramaResultActivity.this.getString(R.string.folder_panorama) + File.separator + PSPanoramaResultActivity.this.SelectFileName + "_" + System.currentTimeMillis();
            if (!new File(str).exists()) {
                new File(str).mkdirs();
            }
            try {
                if (PSPanoramaResultActivity.this.result_image_uri != null) {
                    PSPanoramaResultActivity pSPanoramaResultActivity = PSPanoramaResultActivity.this;
                    pSPanoramaResultActivity.copyFileToDownloads(Uri.parse(Utitlity.getPath(pSPanoramaResultActivity, Uri.parse(pSPanoramaResultActivity.result_image_uri))), str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                PSPanoramaResultActivity.this.copyDirectoryOneLocationToAnotherLocation(new File(PSPanoramaResultActivity.this.temp_path), new File(str));
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Void r6) {
            PSPanoramaResultActivity.this.dialog.dismiss();
            PSPanoramaResultActivity.this.is_save = true;
            PSPanoramaResultActivity.this.save_image.setVisibility(8);
            PSPanoramaResultActivity.this.share_post.setVisibility(0);
            SharedPreferences sharedPreferences = PSPanoramaResultActivity.this.getSharedPreferences("app_rater", 0);
            sharedPreferences.getInt("total_launch_count", 1);
            sharedPreferences.getInt("never_count", 1);
            sharedPreferences.getInt("rate_count", 1);
            Long.valueOf(sharedPreferences.getLong("first_launch_date_time", 0));
            Long.valueOf(sharedPreferences.getLong("launch_date_time", 0));
        }
    }

    private class spiltimages extends AsyncTask<Void, Void, Void> {
        private spiltimages() {
        }

        public void onPreExecute() {
            PSPanoramaResultActivity.this.dialog = new ProgressDialog(PSPanoramaResultActivity.this);
            PSPanoramaResultActivity.this.dialog.setMessage("Please wait...");
            PSPanoramaResultActivity.this.dialog.setCancelable(false);
            PSPanoramaResultActivity.this.dialog.show();
        }

        public Void doInBackground(Void... voidArr) {
            PSPanoramaResultActivity pSPanoramaResultActivity = PSPanoramaResultActivity.this;
            pSPanoramaResultActivity.Spilt_images(pSPanoramaResultActivity.result_image_uri);
            return null;
        }

        public void onPostExecute(Void r5) {
            PSPanoramaResultActivity.this.dialog.dismiss();
            PSPanoramaResultActivity.this.ll_count.setVisibility(0);
            PSPanoramaResultActivity.this.viewPager.measure(-1, -2);
            PSPanoramaResultActivity pSPanoramaResultActivity = PSPanoramaResultActivity.this;
            pSPanoramaResultActivity.viewPager.setAdapter(new PSViewPagerAdapter(pSPanoramaResultActivity, pSPanoramaResultActivity.sequence_images));
            TextView textView = PSPanoramaResultActivity.this.count;
            textView.setText("1/" + PSPanoramaResultActivity.this.sequence_images.size());
            PSPanoramaResultActivity.this.addBottomDots(0);
        }
    }
}
