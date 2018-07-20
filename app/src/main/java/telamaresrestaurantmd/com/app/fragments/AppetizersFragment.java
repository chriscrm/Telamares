package telamaresrestaurantmd.com.app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import telamaresrestaurantmd.com.app.R;
import telamaresrestaurantmd.com.app.adapters.ReceiptRecyclerViewAdapter;
import telamaresrestaurantmd.com.app.models.Receipt;

public class AppetizersFragment extends Fragment {

    @BindView(R.id.recyclerViewAppetizer)
    RecyclerView recyclerViewAppetizer;

    private List<Receipt> receipts;

    public AppetizersFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_appetizers,container, false);

        ButterKnife.bind(this, view);
        initializeData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());

        recyclerViewAppetizer.setHasFixedSize(true);
        recyclerViewAppetizer.setLayoutManager(linearLayoutManager);

        ReceiptRecyclerViewAdapter adapter = new ReceiptRecyclerViewAdapter(this.getContext(), receipts);
        recyclerViewAppetizer.setAdapter(adapter);

        return view;
    }

    private void initializeData(){
        receipts = new ArrayList<>();

        receipts.add(new Receipt("0001", "Chicken Wings","With Buffalo wings sauce with celery sticks", "/chicken-wings.jpg","/chicken-wings.jpg"));
        receipts.add(new Receipt("0002", "Nachos","Crispy tortilla, chips topped with Chicken or beef", "/nachos.jpg","/nachos.jpg"));
        receipts.add(new Receipt("0003", "Calamares Fritos","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur", "/fried-calamari.jpg","/fried-calamari.jpg"));
        receipts.add(new Receipt("0004", "Cocktail de Camarones","Boiled shrimps marinated with lime juice and pico de gallo", "/shrimp-cocktail.jpg","/shrimp-cocktail.jpg"));

    }
}















