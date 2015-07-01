package com.example.vimox.navigation;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 'V'moksh S Shah on 19-05-2015.
 */
public class ContactusFragment extends Fragment {

    LinearLayout website_layout,email_layout,call_layout;
    TextView txt_website;

    public ContactusFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.fragment_contactus, container, false);

        txt_website =(TextView)rootView.findViewById(R.id.txt_website);
        txt_website.setClickable(true);
        txt_website.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.technocratsappware.com'> www.technocratsappware.com </a>";
        txt_website.setText(Html.fromHtml(text));




        // website_layout =(LinearLayout)rootView.findViewById(R.id.layout_website);
        email_layout=(LinearLayout)rootView.findViewById(R.id.layout_mail);
        call_layout =(LinearLayout)rootView.findViewById(R.id.layout_call);


        email_layout.setClickable(true);
        call_layout.setClickable(true);


        email_layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "technocratsappware@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Inquery Email from Application.");
                intent.putExtra(Intent.EXTRA_TEXT, "Please Fill your details.\nName:\nCo.No:\nHow May i help you?\n\n\n\nThank you");
                intent.putExtra(Intent.EXTRA_BCC, "shah.jai75@gmail.com");
                startActivity(intent);

            }
        });

        call_layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+919033228796"));
                startActivity(callIntent);


            }
        });

    return  rootView;
    }
}
