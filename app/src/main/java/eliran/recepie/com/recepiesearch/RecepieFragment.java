package eliran.recepie.com.recepiesearch;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecepieFragment extends Fragment {
TextView HrefTV;
String href;
    Button WebBtn;
    public RecepieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_recepier, container, false);
        HrefTV= (TextView) view.findViewById(R.id.HrefTV);
        HrefTV.setText(href);

        WebBtn= (Button) view.findViewById(R.id.WebBtn);
        WebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(href));
                startActivity(i);
            }
        });
        // Inflate the layout for this fragment
        return view;


    }





}
