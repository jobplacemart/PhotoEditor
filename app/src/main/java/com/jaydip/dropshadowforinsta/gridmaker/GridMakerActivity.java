package com.jaydip.dropshadowforinsta.gridmaker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
//import com.adsdemo.AdmobAds;
import com.iceteck.silicompressorr.SiliCompressor;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.callback.CropCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GridMakerActivity extends AppCompatActivity implements View.OnClickListener, AdapterEvent {
    private CropSizeAdapter adapter;
    public ImageView btnBack;
    public ImageButton btnCkeck;
    public ImageButton btnClose;
    public ImageButton btnRotateLeft;
    public ImageButton btnRotateRight;
    public ConstraintLayout constraintLayout;
    public RelativeLayout constraintLayout2;
    public CropImageView cropImage;
    private List<CropSize> cropSizes;
    public Guideline guideline2;
    private int itemCur = 2;
    public RecyclerView recyclerView;
    public TextView textView7;

    public static Uri imageUri;

    RelativeLayout rlBanner;
    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_grid_maker);

        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);

        this.imageUri = getIntent().getParcelableExtra(Conts.CODE_DATA);
        Bitmap imageBitmap = null;
        try {
            imageBitmap = SiliCompressor.with(getApplicationContext()).getCompressBitmap(String.valueOf(imageUri));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.btnCkeck = (ImageButton) findViewById(R.id.btnCkeck);
        this.btnRotateLeft = (ImageButton) findViewById(R.id.btnRotateLeft);
        this.btnRotateRight = (ImageButton) findViewById(R.id.btnRotateRight);
        this.btnClose = (ImageButton) findViewById(R.id.btnClose);
        this.constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        this.constraintLayout2 = (RelativeLayout) findViewById(R.id.constraintLayout2);
        this.cropImage = (CropImageView) findViewById(R.id.cropImage);
        this.guideline2 = (Guideline) findViewById(R.id.guideline2);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.textView7 = (TextView) findViewById(R.id.textView7);
        this.cropImage.setImageBitmap(imageBitmap);
//        this.cropImage.setImageURI(this.data);
        this.cropImage.setCropMode(CropImageView.CropMode.FREE);
        this.cropImage.setCustomRatio(3, 3);
        this.btnRotateLeft.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        this.btnCkeck.setOnClickListener(this);
        this.btnRotateRight.setOnClickListener(this);
        this.btnClose.setOnClickListener(this);
        createListCropSize();
        settingrecyclerView();
    }

    private void settingrecyclerView() {
        CropSizeAdapter cropSizeAdapter = new CropSizeAdapter(this.cropSizes, this);
        this.adapter = cropSizeAdapter;
        this.recyclerView.setAdapter(cropSizeAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    private void createListCropSize() {
        this.cropSizes = new ArrayList();
        for (int i = 1; i < 11; i++) {
            this.cropSizes.add(new CropSize(3, i, false));
        }
        this.cropSizes.get(2).setSelected(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCkeck :
                cropImage();
                return;

            case R.id.btn_back:
                onBackPressed();
                return;

            case R.id.btnClose :
                onBackPressed();
                return;

            case R.id.btnRotateLeft :
                this.cropImage.rotateImage(CropImageView.RotateDegrees.ROTATE_M90D);
                return;

            case R.id.btnRotateRight :
                this.cropImage.rotateImage(CropImageView.RotateDegrees.ROTATE_90D);
                return;
        }
    }

    public void cropImage() {
        CropImageView cropImageView = this.cropImage;
        cropImageView.crop(cropImageView.getSourceUri()).execute(new CropCallback() {
            @Override
            public void onError(Throwable th) {
            }

            @Override
            public void onSuccess(final Bitmap bitmap) {
                GridMakerActivity.this.sendBitmap(bitmap);
            }
        });
    }

    private void sendBitmap(Bitmap bitmap) {
        lambda$sendBitmap$0$GridMakerActivity(bitmap);
    }

    public void lambda$sendBitmap$0$GridMakerActivity(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppDatabase appDatabase = (AppDatabase) Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Conts.DATABASE_NAME).allowMainThreadQueries().build();
        appDatabase.arrByteDao().deleteAll();
        appDatabase.arrByteDao().insert(new MyArrByte(byteArray));

        admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
            @Override
            public void OnClose(boolean isFail) {
                Intent intent = new Intent(GridMakerActivity.this, YourGirdsActivity.class);
                intent.putExtra(Conts.CODE_DATA, cropSizes.get(itemCur));
                startActivity(intent);
            }});

    }

    @Override
    public void onItemClick(int i) {
        this.itemCur = i;
        this.cropImage.setCustomRatio(this.cropSizes.get(i).getColum(), this.cropSizes.get(i).getRow());
    }
}
