package telamaresrestaurantmd.com.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import telamaresrestaurantmd.com.app.models.Receipt;

public class ReceiptDetailActivity extends AppCompatActivity {

    Receipt receipt;
    @BindView(R.id.idReceiptBackdrop)
    ImageView idReceiptBackdrop;
    @BindView(R.id.textOverview)
    TextView textOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            receipt = (Receipt) extras.getSerializable("RECEIPT");
            this.setTitle(receipt.getTitle());
            textOverview.setText(receipt.getOverview());
            Picasso.with(this)
                    .load(receipt.getBackdropPath())
                    .into(idReceiptBackdrop);
        }

    }
}
