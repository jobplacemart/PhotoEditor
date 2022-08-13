package com.jaydip.dropshadowforinsta.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import com.adsdemo.AdmobAds;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import com.jaydip.dropshadowforinsta.creation.ShareActivity;
import com.jaydip.dropshadowforinsta.shadowView.DropShadowView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressLint("WrongConstant")
public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, FrameItemClickListener, colorshadopwItemClickListener, View.OnClickListener {
    public static Uri imageUri;
    ImageView background2;
    RecyclerView bg;
    RecyclerView bg11;
    TextView blure_btn;
    RelativeLayout bottom_left;
    RelativeLayout center_shadow;
    RecyclerView color_bg;
    TextView color_btn;
    RelativeLayout color_rel;
    private Color_ShadowAdapter color_shadowAdapter;
    ArrayList<Integer> colorlist;
    TextView direction_btn;
    ImageView e1;
    ImageView e10;
    ImageView e11;
    ImageView e12;
    ImageView e13;
    ImageView e14;
    ImageView e15;
    ImageView e2;
    ImageView e4;
    ImageView e5;
    ImageView e6;
    ImageView e7;
    ImageView e9;
    ImageView effectbtn;
    HorizontalScrollView effectlist;
    private FrameListAdapter frameListAdapter;
    private FrameListAdapter1 frameListAdapter1;
    private LinearLayoutManager framelayoutManager;
    private LinearLayoutManager framelayoutManager1;
    private LinearLayoutManager framelayoutManager2;
    private FrameLayout framlayout;
    ImageView grident_btn;
    int[] img_id222 = {R.color.color00, R.color.color111, R.color.color0, R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12, R.color.color13, R.color.color14, R.color.color15};
    ImageView imggallery;
    RelativeLayout left_top;
    RelativeLayout linerlayout;
    public SeekBar mSeek1;
    public SeekBar mSeek2;
    public SeekBar mSeek3;
    public SeekBar mSeek4;
    ImageView original;
    public DropShadowView paletteImageView;
    TextView radius_btn;
    RelativeLayout right_bottom;
    RelativeLayout rlBg;
    ImageView savebtn;
    LinearLayout seekliner1;
    LinearLayout seekliner2;
    LinearLayout seekliner3;
    LinearLayout seekliner6;
    TextView style_btn;
    RelativeLayout top_right;

    ImageView ivBack;

    RelativeLayout rlBanner;
    AdmobInterstitialAdUtil admobInterstitialAdUtil;


    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(MainActivity.this);

    }

    private void initView() {
        DropShadowView dropShadowView = (DropShadowView) findViewById(R.id.palette);
        this.paletteImageView = dropShadowView;
        dropShadowView.setUserBitmap(Glob.bitmap);
        this.paletteImageView.setShadowxy(5, 5);
        this.center_shadow = (RelativeLayout) findViewById(R.id.center_shadow);
        this.right_bottom = (RelativeLayout) findViewById(R.id.right_bottom);
        this.top_right = (RelativeLayout) findViewById(R.id.top_right);
        this.left_top = (RelativeLayout) findViewById(R.id.left_top);
        this.bottom_left = (RelativeLayout) findViewById(R.id.bottom_left);
        this.seekliner1 = (LinearLayout) findViewById(R.id.seekliner1);
        this.seekliner2 = (LinearLayout) findViewById(R.id.seekliner2);
        this.seekliner3 = (LinearLayout) findViewById(R.id.seekliner3);
        this.seekliner6 = (LinearLayout) findViewById(R.id.seekliner6);
        this.blure_btn = (TextView) findViewById(R.id.blure_btn);
        this.radius_btn = (TextView) findViewById(R.id.radius_btn);
        this.direction_btn = (TextView) findViewById(R.id.direction_btn);
        this.color_btn = (TextView) findViewById(R.id.color_btn);
        this.style_btn = (TextView) findViewById(R.id.style_btn);
        this.color_rel = (RelativeLayout) findViewById(R.id.color_rel);
        this.ivBack = (ImageView) findViewById(R.id.iv_back);
        this.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        this.blure_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity.this.seekliner2.setVisibility(4);
                MainActivity.this.seekliner3.setVisibility(4);
                MainActivity.this.seekliner6.setVisibility(4);
                MainActivity.this.color_rel.setVisibility(4);
                if (MainActivity.this.seekliner1.getVisibility() == 0) {
                    MainActivity.this.seekliner1.setVisibility(4);
                } else {
                    MainActivity.this.seekliner1.setVisibility(0);
                }
            }
        });
        this.radius_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity.this.seekliner1.setVisibility(4);
                MainActivity.this.seekliner6.setVisibility(4);
                MainActivity.this.seekliner3.setVisibility(4);
                MainActivity.this.color_rel.setVisibility(4);
                if (MainActivity.this.seekliner2.getVisibility() == 0) {
                    MainActivity.this.seekliner2.setVisibility(4);
                } else {
                    MainActivity.this.seekliner2.setVisibility(0);
                }
            }
        });
        this.direction_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity.this.seekliner1.setVisibility(4);
                MainActivity.this.seekliner2.setVisibility(4);
                MainActivity.this.seekliner6.setVisibility(4);
                MainActivity.this.color_rel.setVisibility(4);
                if (MainActivity.this.seekliner3.getVisibility() == 0) {
                    MainActivity.this.seekliner3.setVisibility(4);
                } else {
                    MainActivity.this.seekliner3.setVisibility(0);
                }
            }
        });
        this.style_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity.this.seekliner1.setVisibility(4);
                MainActivity.this.seekliner2.setVisibility(4);
                MainActivity.this.seekliner3.setVisibility(4);
                MainActivity.this.color_rel.setVisibility(4);
                if (MainActivity.this.seekliner6.getVisibility() == 0) {
                    MainActivity.this.seekliner6.setVisibility(4);
                } else {
                    MainActivity.this.seekliner6.setVisibility(0);
                }
            }
        });
        this.center_shadow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.setcenterShadowOffest();
            }
        });
        this.right_bottom.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.setrightbottomShadowOffest();
            }
        });
        this.top_right.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.setrighttopShadowOffest();
            }
        });
        this.left_top.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.setlefttopShadowOffest();
            }
        });
        this.bottom_left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.setleftbottomShadowOffest();
            }
        });
        this.color_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.seekliner6.setVisibility(4);
                MainActivity.this.seekliner1.setVisibility(4);
                MainActivity.this.seekliner2.setVisibility(4);
                MainActivity.this.seekliner3.setVisibility(4);
                MainActivity.this.rlBg.setVisibility(4);
                if (MainActivity.this.color_rel.getVisibility() == 0) {
                    MainActivity.this.color_rel.setVisibility(4);
                } else {
                    MainActivity.this.color_rel.setVisibility(0);
                }
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.seek1);
        this.mSeek1 = seekBar;
        seekBar.setProgress(100);
        this.mSeek2 = (SeekBar) findViewById(R.id.seek2);
        this.mSeek3 = (SeekBar) findViewById(R.id.seek3);
        this.mSeek4 = (SeekBar) findViewById(R.id.seek4);
        this.framlayout = (FrameLayout) findViewById(R.id.framlayout);
        ImageView imageView = (ImageView) findViewById(R.id.savebtn);
        this.savebtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.linerlayout.setVisibility(4);
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity mainActivity = MainActivity.this;
                Glob.finalBitmap = mainActivity.getbitmap(mainActivity.framlayout);
                MainActivity.this.saveImage(Glob.finalBitmap);
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {
                        startActivity(new Intent(MainActivity.this,ShareActivity.class));
                    }
                });
            }
        });
        this.paletteImageView.setBgBitmap(Glob.gallerybitmap);
        this.rlBg = (RelativeLayout) findViewById(R.id.rlBg);
        this.grident_btn = (ImageView) findViewById(R.id.grident_btn);
        this.linerlayout = (RelativeLayout) findViewById(R.id.linerlayout);
        this.grident_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.linerlayout.setVisibility(4);
                MainActivity.this.effectlist.setVisibility(8);
                if (MainActivity.this.rlBg.getVisibility() == 0) {
                    MainActivity.this.rlBg.setVisibility(4);
                } else {
                    MainActivity.this.rlBg.setVisibility(0);
                }
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.background2);
        this.background2 = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.rlBg.setVisibility(4);
                MainActivity.this.seekliner6.setVisibility(4);
                MainActivity.this.effectlist.setVisibility(8);
                if (MainActivity.this.linerlayout.getVisibility() == 0) {
                    MainActivity.this.linerlayout.setVisibility(4);
                } else {
                    MainActivity.this.linerlayout.setVisibility(0);
                }
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.imggallery);
        this.imggallery = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.galleryIntent();
            }
        });
        this.effectbtn = (ImageView) findViewById(R.id.effectbtn);
        this.effectlist = (HorizontalScrollView) findViewById(R.id.effectlist);
        this.effectbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.linerlayout.setVisibility(4);
                MainActivity.this.rlBg.setVisibility(4);
                if (MainActivity.this.effectlist.getVisibility() == 0) {
                    MainActivity.this.effectlist.setVisibility(8);
                } else {
                    MainActivity.this.effectlist.setVisibility(0);
                }
            }
        });
        this.bg = (RecyclerView) findViewById(R.id.bg);
        this.bg11 = (RecyclerView) findViewById(R.id.bg11);
        this.color_bg = (RecyclerView) findViewById(R.id.color_bg);
        gridengt_bg();
        color_bg();
        color_shadowbg();
        effectbindview();
    }

    private void effectbindview() {
        ImageView imageView = (ImageView) findViewById(R.id.original);
        this.original = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.ef_1);
        this.e1 = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.ef_2);
        this.e2 = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.ef_4);
        this.e4 = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) findViewById(R.id.ef_5);
        this.e5 = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) findViewById(R.id.ef_6);
        this.e6 = imageView6;
        imageView6.setOnClickListener(this);
        ImageView imageView7 = (ImageView) findViewById(R.id.ef_7);
        this.e7 = imageView7;
        imageView7.setOnClickListener(this);
        ImageView imageView8 = (ImageView) findViewById(R.id.ef_9);
        this.e9 = imageView8;
        imageView8.setOnClickListener(this);
        ImageView imageView9 = (ImageView) findViewById(R.id.ef_10);
        this.e10 = imageView9;
        imageView9.setOnClickListener(this);
        ImageView imageView10 = (ImageView) findViewById(R.id.ef_11);
        this.e11 = imageView10;
        imageView10.setOnClickListener(this);
        ImageView imageView11 = (ImageView) findViewById(R.id.ef_12);
        this.e12 = imageView11;
        imageView11.setOnClickListener(this);
        ImageView imageView12 = (ImageView) findViewById(R.id.ef_13);
        this.e13 = imageView12;
        imageView12.setOnClickListener(this);
        ImageView imageView13 = (ImageView) findViewById(R.id.ef_14);
        this.e14 = imageView13;
        imageView13.setOnClickListener(this);
        ImageView imageView14 = (ImageView) findViewById(R.id.ef_15);
        this.e15 = imageView14;
        imageView14.setOnClickListener(this);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
        this.e1.setImageBitmap(Effects.applyEffect1(decodeResource));
        this.e2.setImageBitmap(Effects.applyEffect2(decodeResource));
        this.e4.setImageBitmap(Effects.applyEffect4(decodeResource));
        this.e5.setImageBitmap(Effects.applyEffect5(decodeResource));
        this.e6.setImageBitmap(Effects.applyEffect6(decodeResource));
        this.e7.setImageBitmap(Effects.applyEffect7(decodeResource));
        this.e9.setImageBitmap(Effects.applyEffect9(decodeResource));
        this.e10.setImageBitmap(Effects.applyEffect10(decodeResource));
        this.e11.setImageBitmap(Effects.applyEffect11(decodeResource));
        this.e12.setImageBitmap(Effects.applyEffect12(decodeResource));
        this.e13.setImageBitmap(Effects.applyEffect13(decodeResource));
        this.e14.setImageBitmap(Effects.applyEffect14(decodeResource));
        this.e15.setImageBitmap(Effects.applyEffect15(decodeResource));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.original) {
            switch (id) {
                case R.id.ef_1 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect1(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_10 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect22(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_11 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect18(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_12 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect17(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_13 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect21(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_14 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect14(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_15 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect15(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_2 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect2(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_4 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect4(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_5 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect5(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_6 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect6(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_7 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect7(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                case R.id.ef_9 :
                    this.paletteImageView.setUserBitmap(Effects.applyEffect20(Glob.bitmap));
                    callcolormethod(Color_ShadowAdapter.lastPosition);
                    return;
                default:
                    return;
            }
        } else {
            this.paletteImageView.setUserBitmap(Effects.applyEffectNone(Glob.bitmap));
            callcolormethod(Color_ShadowAdapter.lastPosition);
        }
    }

    public void setcenterShadowOffest() {
        this.paletteImageView.setShadowxy(0, 0);
    }

    public void setlefttopShadowOffest() {
        this.paletteImageView.setShadowxy(-5, -5);
    }

    public void setleftbottomShadowOffest() {
        this.paletteImageView.setShadowxy(-5, 5);
    }

    public void setrighttopShadowOffest() {
        this.paletteImageView.setShadowxy(5, -5);
    }

    public void setrightbottomShadowOffest() {
        this.paletteImageView.setShadowxy(5, 5);
    }

    private void galleryIntent() {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 9);
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && intent != null) {
            imageUri = intent.getData();
            try {
                Glob.gallerybitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                startActivity(new Intent(this, Crope1.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void gridengt_bg() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.framelayoutManager = linearLayoutManager;
        linearLayoutManager.scrollToPosition(0);
        this.bg.setLayoutManager(this.framelayoutManager);
        this.bg.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.bg.setHasFixedSize(true);
        this.frameListAdapter = new FrameListAdapter(this, this);
        this.bg.setLayoutManager(new GridLayoutManager((Context) this, 1, 0, false));
        this.bg.setAdapter(this.frameListAdapter);
    }

    private void color_bg() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.framelayoutManager1 = linearLayoutManager;
        linearLayoutManager.scrollToPosition(0);
        this.bg11.setLayoutManager(this.framelayoutManager1);
        this.bg11.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.bg11.setHasFixedSize(true);
        this.frameListAdapter1 = new FrameListAdapter1(this, this);
        this.bg11.setLayoutManager(new GridLayoutManager((Context) this, 1, 0, false));
        this.bg11.setAdapter(this.frameListAdapter1);
    }

    private void color_shadowbg() {
        this.colorlist = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.framelayoutManager2 = linearLayoutManager;
        linearLayoutManager.scrollToPosition(0);
        this.color_bg.setLayoutManager(this.framelayoutManager2);
        this.color_bg.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.color_bg.setHasFixedSize(true);
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.colorlist.add(Integer.valueOf(this.img_id222[0]));
        this.color_shadowAdapter = new Color_ShadowAdapter(this.colorlist, this, this);
        this.color_bg.setLayoutManager(new GridLayoutManager((Context) this, 1, 0, false));
        this.color_bg.setAdapter(this.color_shadowAdapter);
    }

    private void initListener() {
        this.mSeek1.setOnSeekBarChangeListener(this);
        this.mSeek2.setOnSeekBarChangeListener(this);
        this.mSeek3.setOnSeekBarChangeListener(this);
        this.mSeek4.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onframeItemClick(int[][] iArr, int i) {
        this.paletteImageView.h.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.paletteImageView.getHeight(), iArr[i][0], iArr[i][1], Shader.TileMode.MIRROR));
        this.paletteImageView.invalidate();
    }

    @Override
    public void onframeItemClick1(String[] strArr, int i) {
        this.paletteImageView.setBgColor(Color.parseColor(strArr[i]));
    }

    @Override
    public void onColorItemClick(int i, int i2) {
        if (i2 == 0) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color00));
        } else if (i2 == 1) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color111));
        } else if (i2 == 2) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color3));
        } else if (i2 == 3) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color4));
        } else if (i2 == 4) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color5));
        } else if (i2 == 5) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color6));
        } else if (i2 == 6) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color7));
        } else if (i2 == 7) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color8));
        } else if (i2 == 8) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color9));
        } else if (i2 == 9) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color10));
        } else if (i2 == 10) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color11));
        } else if (i2 == 11) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color12));
        } else if (i2 == 12) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color13));
        } else if (i2 == 13) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color14));
        } else if (i2 == 14) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color15));
        } else if (i2 == 15) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color1));
        } else if (i2 == 16) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color2));
        }
    }

    public void callcolormethod(int i) {
        if (i == 0) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color00));
        } else if (i == 1) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color111));
        } else if (i == 2) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color3));
        } else if (i == 3) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color4));
        } else if (i == 4) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color5));
        } else if (i == 5) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color6));
        } else if (i == 6) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color7));
        } else if (i == 7) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color8));
        } else if (i == 8) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color9));
        } else if (i == 9) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color10));
        } else if (i == 10) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color11));
        } else if (i == 11) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color12));
        } else if (i == 12) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color13));
        } else if (i == 13) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color14));
        } else if (i == 14) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color15));
        } else if (i == 15) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color1));
        } else if (i == 16) {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.color2));
        } else {
            this.paletteImageView.setShadowColor(getResources().getColor(R.color.orange));
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        show(seekBar, i);
    }

    private void show(SeekBar seekBar, int i) {
        switch (seekBar.getId()) {
            case R.id.seek1 :
                this.paletteImageView.setShadowAlpha((int) (((float) i) * 2.55f));
                return;
            case R.id.seek2 :
                this.paletteImageView.setBlurRadius(i);
                return;
            case R.id.seek3 :
                this.paletteImageView.setShadowX(i - 100);
                return;
            case R.id.seek4 :
                this.paletteImageView.setShadowY(i - 100);
                return;
            default:
                return;
        }
    }

    private void saveImage(Bitmap bitmap) {
        Log.v("TAG", "saveImageInCache is called");
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = new File(externalStoragePublicDirectory.getAbsolutePath() + "/" + Glob.Edit_Folder_name);
        file.mkdirs();
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".jpeg";
        File file2 = new File(file, str);
        file2.renameTo(file2);
        String str2 = "file://" + externalStoragePublicDirectory.getAbsolutePath() + "/" + Glob.Edit_Folder_name + "/" + str;
        Glob.shareuri = externalStoragePublicDirectory.getAbsolutePath() + "/" + Glob.Edit_Folder_name + "/" + str;
        Log.d("cache uri=", str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getbitmap(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return CropBitmapTransparency(createBitmap);
    }

    public Bitmap CropBitmapTransparency(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < bitmap.getHeight(); i3++) {
            for (int i4 = 0; i4 < bitmap.getWidth(); i4++) {
                if (((bitmap.getPixel(i4, i3) >> 24) & 255) > 0) {
                    if (i4 < width) {
                        width = i4;
                    }
                    if (i4 > i) {
                        i = i4;
                    }
                    if (i3 < height) {
                        height = i3;
                    }
                    if (i3 > i2) {
                        i2 = i3;
                    }
                }
            }
        }
        if (i < width || i2 < height) {
            return null;
        }
        return Bitmap.createBitmap(bitmap, width, height, (i - width) + 1, (i2 - height) + 1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
