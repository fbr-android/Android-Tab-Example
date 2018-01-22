package innovatecode.com.tabexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabTwoFragment extends Fragment {
    private Button buttonTabTwo;
    private TextView textTabTwo;

    public TabTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_two, container, false);

        textTabTwo = (TextView)view.findViewById(R.id.text_tab_two);
        buttonTabTwo = (Button)view.findViewById(R.id.button_tab_two);
        buttonTabTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                textTabTwo.setText("Random number Tab Two: "+(0+(int)(Math.random()*10)));
            }
        });
        return view;
    }


}
