package eliran.recepie.com.recepiesearch;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    EditText RecepieET;
    Button SearchBtn;
    RecyclerView recyclerView;
    FragIntrFace fragIntrFace;
    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search_, container, false);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new RecepieListener(),new IntentFilter("com.recepiesearch.eliran.DONE!"));
        RecepieET= (EditText) view.findViewById(R.id.recepieET);
        recyclerView= (RecyclerView) view.findViewById(R.id.recepieRV);
        SearchBtn= (Button) view.findViewById(R.id.SearchBtn);
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String RecepieSrchName=RecepieET.getText().toString();
                Intent intent=new Intent(getActivity(),DownloadService.class);
                intent.putExtra("recepiename",RecepieSrchName);
                getActivity().startService(intent);
            }
        });
       RecepieET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if (i==EditorInfo.IME_ACTION_SEARCH)
               {
                   String RecepieSrchName=RecepieET.getText().toString();
                   Intent intent=new Intent(getActivity(),DownloadService.class);
                   intent.putExtra("recepiename",RecepieSrchName);
                   getActivity().startService(intent);
               }
               return false;
           }
       });
        fragIntrFace= (FragIntrFace) getActivity();




        return view;
    }
    class  RecepieListener extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            ArrayList<recepieObj> allrecepie=intent.getParcelableArrayListExtra("recepiearray");
            recyclerView.setLayoutManager(new GridLayoutManager(context,3));
            RecepieAdapter adapter=new RecepieAdapter(allrecepie,context,fragIntrFace);
            recyclerView.setAdapter(adapter);


        }
    }


}
