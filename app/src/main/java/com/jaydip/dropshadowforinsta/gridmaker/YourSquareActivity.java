package com.jaydip.dropshadowforinsta.gridmaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;
import androidx.room.Room;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;
import java.io.ByteArrayOutputStream;

public class YourSquareActivity extends AppCompatActivity implements View.OnClickListener {
    public ImageView btnBack;
    public ImageView btnHome;
    public RelativeLayout btnSave;
    public RelativeLayout btnShare;
    public RelativeLayout cardView;
    private Bitmap data;
    private AppDatabase db;
    public Guideline guideline2;
    public Guideline guideline3;
    public Guideline guideline5;
    public ImageView img;
    public RelativeLayout rel;
    public TextView textView9;

    AdmobInterstitialAdUtil admobInterstitialAdUtil;
    RelativeLayout rlBanner;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_your_square);
        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);
        this.db = (AppDatabase) Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Conts.DATABASE_NAME).allowMainThreadQueries().build();
        this.textView9 = (TextView) findViewById(R.id.textView9);
        this.img = (ImageView) findViewById(R.id.img);
        this.guideline5 = (Guideline) findViewById(R.id.guideline5);
        this.guideline3 = (Guideline) findViewById(R.id.guideline3);
        this.guideline2 = (Guideline) findViewById(R.id.guideline2);
        this.rel = (RelativeLayout) findViewById(R.id.rel);
        this.cardView = (RelativeLayout) findViewById(R.id.cardView);
        this.btnShare = (RelativeLayout) findViewById(R.id.btnShare);
        this.btnHome = (ImageView) findViewById(R.id.btnHome);
        this.btnSave = (RelativeLayout) findViewById(R.id.btnSave);
        ImageView imageButton = (ImageView) findViewById(R.id.btnBack);
        this.btnBack = imageButton;
        imageButton.setOnClickListener(this);
        this.btnHome.setOnClickListener(this);
        this.btnSave.setOnClickListener(this);
        this.btnShare.setOnClickListener(this);
        MyArrByte myArrByte = this.db.arrByteDao().getAll().get(0);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(myArrByte.getBytes(), 0, myArrByte.getBytes().length);
        this.data = decodeByteArray;
        this.img.setImageBitmap(decodeByteArray);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                onBackPressed();
                return;
            case R.id.btnHome:
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {
                        Intent intent = new Intent(YourSquareActivity.this.getApplicationContext(), PSHomeActivity.class);
                        YourSquareActivity.this.startActivity(intent);
                        YourSquareActivity.this.finish();
                    }
                });
                return;
            case R.id.btnSave:
                SystemUtils.saveImage(this, this.data);
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {
                        Intent intent = new Intent(YourSquareActivity.this.getApplicationContext(), PSHomeActivity.class);
                        YourSquareActivity.this.startActivity(intent);
                        YourSquareActivity.this.finish();
                    }
                });
                return;
            case R.id.btnShare:
                shareBitmap();
                return;
            default:
                return;
        }
    }

    private void shareBitmap() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", getImageUri(this, this.data));
        startActivity(Intent.createChooser(intent, "Share..."));
    }

    private Uri getImageUri(Context context, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", (String) null));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 11 && iArr.length > 0 && iArr[0] == 0) {
            SystemUtils.saveImage(this, this.data);
        }
    }
}
