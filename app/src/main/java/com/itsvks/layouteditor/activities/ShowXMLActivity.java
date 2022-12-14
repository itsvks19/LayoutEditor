package com.itsvks.layouteditor.activities;

import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;

import com.blankj.utilcode.util.ClipboardUtils;
import com.itsvks.layouteditor.BaseActivity;
import com.itsvks.layouteditor.R;
import com.itsvks.layouteditor.databinding.ActivityShowXMLBinding;
import com.itsvks.layouteditor.utils.SBUtils;

public class ShowXMLActivity extends BaseActivity {

  public static final String EXTRA_KEY_XML = "xml";

  private ActivityShowXMLBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityShowXMLBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());
    setSupportActionBar(binding.topAppBar);
    getSupportActionBar().setTitle(R.string.xml_preview);

    binding.topAppBar.setNavigationOnClickListener(
        v -> {
          super.onBackPressed();
        });

    binding.result.setText(getIntent().getStringExtra(EXTRA_KEY_XML));
    binding.result.setTypeface(ResourcesCompat.getFont(this, R.font.jetbrains_mono_regular));

    binding.fab.setOnClickListener(
        v -> {
          ClipboardUtils.copyText(binding.result.getText());
          SBUtils.make(binding.getRoot(), getString(R.string.copied))
              .setAnchorView(binding.fab)
              .setSlideAnimation()
              .show();
        });

    binding.nestedScrollView.setOnScrollChangeListener(
        (v, x, y, oldX, oldY) -> {
          if (y > oldY + 20 && binding.fab.isExtended()) {
            binding.fab.shrink();
          }
          if (y < oldY - 20 && !binding.fab.isExtended()) {
            binding.fab.extend();
          }
          if (y == 0) {
            binding.fab.extend();
          }
        });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    binding = null;
  }
}
