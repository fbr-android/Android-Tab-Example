package innovatecode.com.tabexample;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TabOneFragment extends Fragment {
    private Button buttonTabOne;
    private TextView textTabOne;

    // Required empty public constructor
    public TabOneFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_one, container, false);
        textTabOne = (TextView)view.findViewById(R.id.text_tab_one);
        buttonTabOne = (Button)view.findViewById(R.id.button_tab_one);
        buttonTabOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                textTabOne.setText("Random number Tab One: "+(0+(int)(Math.random()*10)));
            }
        });

        return view;
    }
}
