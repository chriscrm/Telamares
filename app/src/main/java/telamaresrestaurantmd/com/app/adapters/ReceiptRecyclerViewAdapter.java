package telamaresrestaurantmd.com.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import telamaresrestaurantmd.com.app.R;
import telamaresrestaurantmd.com.app.models.Receipt;
import telamaresrestaurantmd.com.app.ReceiptDetailActivity;

public class ReceiptRecyclerViewAdapter extends RecyclerView.Adapter<ReceiptRecyclerViewAdapter.ViewHolder> {

    List<Receipt> receipts;
    Context context;

    public ReceiptRecyclerViewAdapter(Context context, List<Receipt> receipts){
        this.receipts = receipts;
        this.context = context;
    }

    private Context getContext(){
        return context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_receipt, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Receipt receipt = receipts.get(i);
        viewHolder.textReceiptTitle.setText(receipt.getTitle());
        viewHolder.textReceiptOverview.setText(receipt.getOverview());

        Picasso.with(getContext())
                .load(receipt.getPosterPath())
                .into(viewHolder.ReceiptImage);
    }

    @Override
    public int getItemCount() {
        return receipts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ReceiptImage)
        ImageView ReceiptImage;
        @BindView(R.id.textReceiptTitle)
        TextView textReceiptTitle;
        @BindView(R.id.textReceiptOverview)
        TextView textReceiptOverview;
        @BindView(R.id.cardViewReceipt)
        CardView cardViewReceipt;

        ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){

            Receipt receipt = receipts.get(getAdapterPosition());
            Intent intent = new Intent(getContext(), ReceiptDetailActivity.class);
            intent.putExtra("RECEIPT", receipt);
            getContext().startActivity(intent);

        }
    }

}
















