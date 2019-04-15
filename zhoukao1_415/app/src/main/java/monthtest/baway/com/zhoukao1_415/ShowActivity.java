package monthtest.baway.com.zhoukao1_415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        findViewById(R.id.fanhui_show).setOnClickListener(this);
        imageView_show = findViewById(R.id.imageView_show);
        Glide.with(ShowActivity.this)
                .load(R.drawable.pink1)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView_show);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ShowActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
