package com.jaydip.dropshadowforinsta.gridmaker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
//import com.adsdemo.AdmobAds;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class YourGirdsActivity extends AppCompatActivity implements View.OnClickListener {
    private GridsImageAdapter adapter;
    private List<Bitmap> bitmapList;
    public ImageView btnBack;
    public ImageButton btnHome;
    public ImageButton containerSave;
    private CropSize cropSize;
    private Bitmap data;
    private AppDatabase db;
    private GridLayoutManager layoutManager;
    public RecyclerView recyclerView;
    private int sizeImage;
    public TextView textView11;
    public TextView textView16;
    public TextView textView7;

    RelativeLayout rlBanner;
    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_your_girds);

        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);

        this.db = (AppDatabase) Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Conts.DATABASE_NAME).allowMainThreadQueries().build();
        this.btnBack = (ImageView) findViewById(R.id.iv_back);
        this.btnHome = (ImageButton) findViewById(R.id.btnHome);
        this.containerSave = (ImageButton) findViewById(R.id.containerSave);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.textView16 = (TextView) findViewById(R.id.textView16);
        this.textView7 = (TextView) findViewById(R.id.textView7);
        this.textView11 = (TextView) findViewById(R.id.textView11);
        this.btnBack.setOnClickListener(this);
        this.btnHome.setOnClickListener(this);
        this.containerSave.setOnClickListener(this);
        createData();
        this.layoutManager = new GridLayoutManager(this, this.cropSize.getColum());
        GridsImageAdapter gridsImageAdapter = new GridsImageAdapter(this.bitmapList);
        this.adapter = gridsImageAdapter;
        this.recyclerView.setAdapter(gridsImageAdapter);
        this.recyclerView.setLayoutManager(this.layoutManager);
    }

    private void createData() {
        MyArrByte myArrByte = this.db.arrByteDao().getAll().get(0);
        this.data = BitmapFactory.decodeByteArray(myArrByte.getBytes(), 0, myArrByte.getBytes().length);
        this.cropSize = (CropSize) getIntent().getSerializableExtra(Conts.CODE_DATA);
        this.sizeImage = this.data.getWidth() / this.cropSize.getColum();
        this.bitmapList = new ArrayList();
        for (int i = 0; i < this.cropSize.getRow(); i++) {
            for (int i2 = 0; i2 < this.cropSize.getColum(); i2++) {
                List<Bitmap> list = this.bitmapList;
                Bitmap bitmap = this.data;
                int i3 = this.sizeImage;
                list.add(Bitmap.createBitmap(bitmap, i2 * i3, i * i3, i3, i3));
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else if (id == R.id.btnHome) {
            Intent intent = new Intent(getApplicationContext(), PSHomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.containerSave) {
            for (int i = 0; i < this.bitmapList.size(); i++) {
                if (i == this.bitmapList.size() - 1) {
                    SystemUtils.saveImage(this, this.bitmapList.get(i));
                } else {
                    saveImageFinal(this, this.bitmapList.get(i));
                }
            }
        }
    }

    private void saveImageFinal(Activity activity, Bitmap bitmap) {
        if (!SystemUtils.checkPermisson(activity)) {
            String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
            File file2 = new File(file + "/" + activity.getString(R.string.app_name));
            file2.mkdirs();
            File file3 = new File(file2, "Image-" + System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                SystemUtils.refreshGallery(activity, file3.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
            @Override
            public void OnClose(boolean isFail) {
                startActivity(new Intent(YourGirdsActivity.this,PSHomeActivity.class));
            }
        });
    }
}
