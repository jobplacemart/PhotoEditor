package com.jaydip.dropshadowforinsta.gridmaker;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import com.iceteck.silicompressorr.SiliCompressor;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import jp.wasabeef.blurry.Blurry;

public class SquareActivity extends AppCompatActivity implements View.OnClickListener, BlurFragmentEvent, ColorAdapterEvent {
    public ImageView btnBack;
    public ImageView btnCkeck;
    public RelativeLayout cardView;
    public ConstraintLayout containerImage;
//    private Uri data;
    private AppDatabase db;
    public Guideline guideline3;
    public Guideline guideline5;
    public ImageView imgBlur;
    public ImageView imgOriginal;
    public LinearLayout ln;
    private final int sampling = 1;
    public TabLayout tableLayout;
    public TextView textView7;
    public ViewPager viewpager;

    public static Uri imageUri;

    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    static void lambda$showDialogChooseColor$1(DialogInterface dialogInterface, int i) {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_square);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);
        this.db = (AppDatabase) Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Conts.DATABASE_NAME).allowMainThreadQueries().build();
        this.btnBack = (ImageView) findViewById(R.id.btnBack);
        this.btnCkeck = (ImageView) findViewById(R.id.btnCkeck);
        this.cardView = (RelativeLayout) findViewById(R.id.cardView);
        this.containerImage = (ConstraintLayout) findViewById(R.id.containerImage);
        this.guideline3 = (Guideline) findViewById(R.id.guideline3);
        this.guideline5 = (Guideline) findViewById(R.id.guideline5);
        this.imgBlur = (ImageView) findViewById(R.id.imgBlur);
        this.imgOriginal = (ImageView) findViewById(R.id.imgOriginal);
        this.ln = (LinearLayout) findViewById(R.id.ln);
        this.tableLayout = (TabLayout) findViewById(R.id.tableLayout);
        this.textView7 = (TextView) findViewById(R.id.textView7);
        this.viewpager = (ViewPager) findViewById(R.id.viewpager);
        this.btnBack.setOnClickListener(this);
        this.btnCkeck.setOnClickListener(this);

        this.imageUri = getIntent().getParcelableExtra(Conts.CODE_DATA);
        Bitmap imageBitmap = null;
        try {
            imageBitmap = SiliCompressor.with(getApplicationContext()).getCompressBitmap(String.valueOf(imageUri));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.imgOriginal.setImageBitmap(imageBitmap);
        loadImageBlur(1);
        this.viewpager.setAdapter(new SquareAdapterViewPager(getSupportFragmentManager(), this, this));
        this.tableLayout.setupWithViewPager(this.viewpager);
    }

    private void loadImageBlur(int i) {
        try {
            Blurry.with(getApplicationContext()).sampling(i).from(MediaStore.Images.Media.getBitmap(getContentResolver(), this.imageUri)).into(this.imgBlur);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack :
                onBackPressed();
                return;
            case R.id.btnCkeck :
                SquareActivity.this.getBitmap();
                return;
            default:
                return;
        }
    }

    private void getBitmap() {
        sendBitmap(loadBitmapFromView(this.containerImage));
    }

    private void sendBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.db.arrByteDao().deleteAll();
        this.db.arrByteDao().insert(new MyArrByte(byteArray));
        admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
            @Override
            public void OnClose(boolean isFail) {
                startActivity(new Intent(SquareActivity.this, YourSquareActivity.class));
            }
        });
    }

    private Bitmap loadBitmapFromView(View view) {
        view.buildDrawingCache(true);
        Bitmap copy = view.getDrawingCache(true).copy(Bitmap.Config.RGB_565, false);
        view.destroyDrawingCache();
        return copy;
    }

    private void showDialogChooseColor() {
        ColorPickerDialogBuilder.with(this, R.style.AlertDialogCustom).setTitle("Choose color").wheelType(ColorPickerView.WHEEL_TYPE.FLOWER).density(12).setPositiveButton("ok", new ColorPickerClickListener() {
            @Override
            public final void onClick(DialogInterface dialogInterface, int i, Integer[] numArr) {
                SquareActivity.this.lambda$showDialogChooseColor$0$SquareActivity(dialogInterface, i, numArr);
            }
        }).setNegativeButton("cancel", C$$Lambda$SquareActivity$FO0BoD53szJFQi0cnFmA5wlVTA.INSTANCE).build().show();
    }

    public void lambda$showDialogChooseColor$0$SquareActivity(DialogInterface dialogInterface, int i, Integer[] numArr) {
        chooseColor(i);
    }

    private void chooseColor(int i) {
        this.imgBlur.setBackgroundColor(i);
        this.imgBlur.setImageBitmap(null);
    }

    private void chooseColorAdapter(int i) {
        this.imgBlur.setBackgroundColor(getResources().getColor(i));
        this.imgBlur.setImageBitmap(null);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void blurImage(int i) {
        if (i != 0) {
            loadImageBlur(i);
        } else {
            this.imgBlur.setImageURI(this.imageUri);
        }
    }

    @Override
    public void onClickItem(int i) {
        if (i != 0) {
            chooseColorAdapter(i);
        } else {
            showDialogChooseColor();
        }
    }
}
