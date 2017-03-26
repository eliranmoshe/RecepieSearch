package eliran.recepie.com.recepiesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragIntrFace {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchFragment searchFragment=new SearchFragment();
        getFragmentManager().beginTransaction().replace(R.id.activity_main,searchFragment).commit();
    }


    @Override
    public void ChangeFrag(String href) {
        RecepieFragment recepieFragment=new RecepieFragment();
        recepieFragment.href=href;
        getFragmentManager().beginTransaction().addToBackStack("changeFrags").replace(R.id.activity_main,recepieFragment).commit();
    }
}

