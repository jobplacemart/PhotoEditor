package com.jaydip.dropshadowforinsta.gridmaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import com.jaydip.dropshadowforinsta.R;

public class BlurFragment extends Fragment {
    private final BlurFragmentEvent callback;
    public SeekBar progressBar;

    public BlurFragment(BlurFragmentEvent blurFragmentEvent) {
        this.callback = blurFragmentEvent;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_blur, viewGroup, false);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.progressBar);
        this.progressBar = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.jaydip.storymakerforinsta.gridmaker.BlurFragment.AnonymousClass1 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                BlurFragment.this.callback.blurImage(seekBar.getProgress() / 10);
            }
        });
        return inflate;
    }
}
