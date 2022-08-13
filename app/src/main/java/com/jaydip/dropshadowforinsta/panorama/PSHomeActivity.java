package com.jaydip.dropshadowforinsta.panorama;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.BitmapCompat;
import androidx.exifinterface.media.ExifInterface;

import com.iceteck.silicompressorr.SiliCompressor;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobNativeUtil_300;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import com.jaydip.dropshadowforinsta.dashboard.Main2Activity;
import com.jaydip.dropshadowforinsta.edit.Crope;
import com.jaydip.dropshadowforinsta.edit.MainActivity;
import com.jaydip.dropshadowforinsta.gridmaker.Conts;
import com.jaydip.dropshadowforinsta.gridmaker.GridMakerActivity;
import com.jaydip.dropshadowforinsta.gridmaker.SquareActivity;
import com.jaydip.dropshadowforinsta.gridmaker.SystemUtils;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressLint("WrongConstant")
public class PSHomeActivity extends PSBaseActivity {
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage";
    private static final String TAG = "PSHomeActivity";
    public static Uri imageUri;
    public int from = 0;
    public Boolean is_click = false;
    public int requestMode = 1;
    public int sequen;
    public UCrop uCrop;

    RelativeLayout rlDropShadow;
    RelativeLayout rlPhotoGrid;
    RelativeLayout rlPanoramaCut;
    RelativeLayout rlSquarePic;

    AdmobInterstitialAdUtil admobInterstitialAdUtil;
    RelativeLayout rlNative;
    ImageView imageSpace;
    RelativeLayout rlBanner;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sample);
        getWindow().setFlags(1024, 1024);
        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        rlNative = (RelativeLayout) findViewById(R.id.rl_native);
        imageSpace = (ImageView) findViewById(R.id.iv_space);
        AdmobNativeUtil_300.loadNative(this,rlNative,imageSpace);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(PSHomeActivity.this);
        setupUI();
        int intExtra = getIntent().getIntExtra("from", 0);
        this.from = intExtra;
        if (intExtra == 1) {
            this.rlPanoramaCut.performClick();
        }
    }

    public void checkFolder() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + File.separator + getString(R.string.folder_name) + File.separator + getString(R.string.folder_panorama));
        boolean exists = file.exists();
        StringBuilder sb = new StringBuilder();
        sb.append("checkFolder: ");
        sb.append(exists);
        Log.e("checkFolder", sb.toString());
        if (!exists) {
            file.mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor query = getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        String string = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
        query.close();
        return string;
    }

    private void setupUI() {
        rlPanoramaCut = (RelativeLayout) findViewById(R.id.rl_panorama_cut);
        rlPanoramaCut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Glob.selection = 1;
                if (Build.VERSION.SDK_INT >= 26) {
                    PSHomeActivity.this.checkFolder();
                }
                if (!PSHomeActivity.this.is_click.booleanValue()) {
                    PSHomeActivity.this.is_click = true;
                    PSHomeActivity.this.pickFromGallery();
                }
            }
        });
        rlPhotoGrid = (RelativeLayout) findViewById(R.id.rl_photo_grid);
        rlPhotoGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)                                                                                                                                                                                                                                                                                                       {
                PSHomeActivity.this.chooseImage(2);
            }
        });
        rlSquarePic = (RelativeLayout) findViewById(R.id.rl_square_pic);
        rlSquarePic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PSHomeActivity.this.chooseImage(111);
            }
        });
        rlDropShadow = (RelativeLayout) findViewById(R.id.rl_drop_shadow);
        rlDropShadow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PSHomeActivity.this.galleryIntent();
            }
        });
    }

    private void chooseImage(final int i) {
        if (!SystemUtils.checkPermisson(PSHomeActivity.this)) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            PSHomeActivity.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), i);
        }
    }

    private void pickFromGallery() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, this.requestMode);
    }

    private void galleryIntent() {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 9);
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.is_click = false;
        if (i2 == -1) {
            if (i == this.requestMode) {
                Glob.selectedUri = FileProvider.getUriForFile(this, "com.jaydip.storymakerforinsta.provider", new File(getRealPathFromURI(intent.getData())));
                if (Glob.selectedUri == null) {
                    Toast.makeText(this, (int) R.string.toast_cannot_retrieve_selected_image, 0).show();
                } else {
                    startCrop(Glob.selectedUri);
                }
            } else if (i == 69) {
                handleCropResult(intent);
            }
        }
        if (i2 == 96) {
            handleCropError(intent);
        } else if (i2 != -1) {
            Toast.makeText(this, "Not Selected!!!", 0).show();
        } else if (i == 9) {
            if (intent != null) {
                imageUri = intent.getData();
                try {
                    Bitmap bitmaps = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    Bitmap imageBitmap = SiliCompressor.with(getApplicationContext()).getCompressBitmap(String.valueOf(imageUri));
                    Glob.bitmap = imageBitmap;
                    startActivityForResult(new Intent(this, Crope.class), 28);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (i == 28) {
            admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                @Override
                public void OnClose(boolean isFail) {
                    startActivity(new Intent(PSHomeActivity.this, MainActivity.class));
                }
            });
        } else if (intent == null) {
        } else {
            if (i == 111) {
                startActivityEdit(intent, SquareActivity.class);
            } else if (i == 2) {
                startActivityEdit(intent, GridMakerActivity.class);
            }
        }
    }

    private void startActivityEdit(Intent intent, Class cls) {
        Intent intent2 = new Intent(this, cls);
        Uri gridImageUri = intent.getData();
        intent2.putExtra(Conts.CODE_DATA, gridImageUri);
        startActivity(intent2);
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 11 && iArr.length > 0 && iArr[0] == 0) {
            chooseImage(111);
        }
    }

    private void startCrop(Uri uri) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("_");
        sb.append(currentTimeMillis);
        sb.append(".png");
        UCrop.Options options = new UCrop.Options();
        options.setToolbarColor(getResources().getColor(R.color.white));
        options.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        options.setToolbarWidgetColor(getResources().getColor(R.color.txt_color));
        options.setLogoColor(ContextCompat.getColor(getApplicationContext(), R.color.inactive_color));
//        options.setActiveWidgetColor(ContextCompat.getColor(getApplicationContext(), R.color.active_color));
        options.setToolbarCancelDrawable(R.drawable.ic_back);
        Log.e(TAG, "startCrop: " + Glob.selectedUri);
        if (Glob.selection == 1) {
            this.uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), "SampleCropImage.png")));
            options.setToolbarTitle("Panorama");
            options.setCropGridRowCount(1);
            options.setCropGridColumnCount(3);
            options.setAspectRatioOptions(1, new AspectRatio(ExifInterface.GPS_MEASUREMENT_2D, 2.0f, 1.0f), new AspectRatio(ExifInterface.GPS_MEASUREMENT_3D, 3.0f, 1.0f), new AspectRatio("4", 4.0f, 1.0f), new AspectRatio("5", 5.0f, 1.0f), new AspectRatio("6", 6.0f, 1.0f), new AspectRatio("7", 7.0f, 1.0f), new AspectRatio("8", 8.0f, 1.0f), new AspectRatio("9", 9.0f, 1.0f), new AspectRatio("10", 10.0f, 1.0f));
            this.uCrop.withOptions(options);
            this.uCrop.start(this);
        }
    }

    private void handleCropResult(Intent intent) {
        Bitmap bitmap;
        Uri output = UCrop.getOutput(intent);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString(), "/CropImage");
        if (!file.exists() && !file.mkdirs()) {
            Toast.makeText(this, "Folder is not created,,Please try again!!!", 0).show();
        }
        File file2 = new File(file, "Image-crop.jpg");
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), output);
        } catch (IOException e) {
            e.printStackTrace();
            bitmap = null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (output != null) {
//            UCrop.getOutputRowCount(intent);
//            int outputColumnCount = UCrop.getOutputColumnCount(intent) + 1;
//            if (Glob.selection == 1) {
//                this.sequen = outputColumnCount;
//                try {
//                    Intent intent2 = new Intent(this, PSPanoramaResultActivity.class);
//                    intent2.putExtra("from_main", true);
//                    intent2.putExtra("row_count", this.sequen);
//                    intent2.putExtra("select_image_uri", Glob.selectedUri.toString());
//                    intent2.putExtra("result_uri", output.toString());
//                    startActivity(intent2);
//                } catch (Exception e3) {
//                    e3.printStackTrace();
//                }
//            }
        } else {
            Toast.makeText(this, (int) R.string.toast_cannot_retrieve_cropped_image, 0).show();
        }
    }

    private void handleCropError(Intent intent) {
        Throwable error = UCrop.getError(intent);
        if (error != null) {
            Log.e(TAG, "handleCropError: ", error);
            Toast.makeText(this, error.getMessage(), 1).show();
            return;
        }
        Toast.makeText(this, (int) R.string.toast_unexpected_error, 0).show();
    }

    @Override
    public void onResume() {
        this.is_click = false;
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }

}
