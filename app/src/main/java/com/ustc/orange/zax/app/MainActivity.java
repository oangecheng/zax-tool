package com.ustc.orange.zax.app;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ustc.orange.zax.view.hollow.HollowTextSpan;
import com.ustc.orange.zax_tool.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ColorDrawable d = new ColorDrawable();
    d.setColor(Color.BLUE);
    d.setBounds(0, 0, 250, 100);
    HollowTextSpan span = new HollowTextSpan("我是中国人", d);
    span.setTextSize(50);

    TextView textView = findViewById(R.id.text);
    textView.setBackgroundColor(Color.RED);
    textView.setTextSize(20);
    SpannableStringBuilder builder = new SpannableStringBuilder();
    builder.append("哈哈哈");
    builder.append("~");
    builder.setSpan(span, builder.length() - 1, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    textView.setText(builder);

  }
}