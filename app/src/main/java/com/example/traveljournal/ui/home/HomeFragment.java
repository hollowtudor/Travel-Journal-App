package com.example.traveljournal.ui.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;
import com.example.traveljournal.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("GFRAG","OK,FRAGMENT");
    }

    private static final String TAG = "Home fragment";
    private List<String> mNames = new ArrayList<>();
    private List<Integer> mImageUrls = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initImageBitmaps();
        initRecyclerView(root);
        if(isOnline()) Toast.makeText(getActivity(),"Welcome!",Toast.LENGTH_SHORT).show();
        else Toast.makeText(getActivity(),"ok,net",Toast.LENGTH_SHORT).show();
        return root;
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add(R.drawable.canada);
        mNames.add("-Canada\n\n" +
                "Trip - Price: 90$\n" +
                "Rating: 4.2★\n" +
                "Canada is a country in the northern part of North America. Its ten provinces and three territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean, covering 9.98 million square kilometres (3.85 million square miles), making it the world's second-largest country by total area. ");
        mImageUrls.add(R.drawable.roma);
        mNames.add("-Rome Italy\n\n" +
                "CityBreak - Price: 60$\n" +
                "Rating: 4.9★\n" +
                "Rome is located on the western coast of central Italy along the Tevere River. The capital of the Lazio region is Italy’s largest city with a population of 2,654,100 and over 2600 years of richness in art, history, architecture, monuments and culture.");
        mImageUrls.add(R.drawable.japan);
        mNames.add("-Tokyo Japan\n\n" +
                "CityBreak - Price: 80$\n" +
                "Rating: 4.8★\n" +
                "Tokyo (東京, Tōkyō) is Japan's capital and the world's most populous metropolis. It is also one of Japan's 47 prefectures, consisting of 23 central city wards and multiple cities, towns and villages west of the city center. The Izu and Ogasawara Islands are also part of Tokyo.");
        mImageUrls.add(R.drawable.ireland);
        mNames.add("-Ireland\n\n" +
                "Trip - Price: 140$\n" +
                "Rating: 4.2★\n" +
                "Ireland is an island in the North Atlantic. It is separated from Great Britain to its east by the North Channel, the Irish Sea, and St George's Channel. Ireland is the second-largest island of the British Isles, the third-largest in Europe, and the twentieth-largest on Earth.");
        mImageUrls.add(R.drawable.germany);
        mNames.add("-Germany\n\n" +
                "Trip - Price: 150$\n" +
                "Rating: 4.0★\n" +
                "Germany Deutschland, German pronunciation: officially the Federal Republic of Germany (German: Bundesrepublik Deutschland, About this soundlisten , is a country in Central and Western Europe, lying between the Baltic and North Seas to the north and the Alps, Lake Constance, and the High Rhine to the south. ");
        mImageUrls.add(R.drawable.greece);
        mNames.add("-Greece\n\n" +
                "Trip - Price: 100$\n" +
                "Rating: 3.8★\n" +
                "Greece has the longest coastline in Europe and is the southernmost country in Europe. The mainland has rugged mountains, forests, and lakes, but the country is well known for the thousands of islands dotting the blue Aegean Sea to the east, the Mediterranean Sea to the south, and the Ionian Sea to the west.\n" +
                "");
//        mImageUrls.add(R.drawable.tomesti);
//        mNames.add("Tomesti City");


    }
    public boolean isOnline() {
        boolean fag=false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                fag=true;
            } else{fag=false;
            }
        }catch (Exception EX){

        }
        return fag;
    }

    private void initRecyclerView(View view){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImageUrls ,mNames, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}