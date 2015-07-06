package com.teamdroid.algoninja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Murali on 16-06-2015.
 */
public class CodeTabFragment extends Fragment {


    private TextView textView;
    Codedisplayer fontColor = new Codedisplayer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_code_tab, container, false);


        textView = (TextView) view.findViewById(R.id.textView);

        textView.setText("import sys\n" +
                "import os\n" +
                "from sqlalchemy import Column, ForeignKey, Integer, String\n" +
                "from sqlalchemy.ext.declarative import declarative_base\n" +
                "from sqlalchemy.orm import relationship\n" +
                "from sqlalchemy import create_engine\n" +
                "from sqlalchemy.orm import sessionmaker\n" +
                "\n" +
                "Base = declarative_base()\n" +
                "\n" +
                "class Restaurant(Base):\n" +
                "    __tablename__ = 'restaurant'\n" +
                "\n" +
                "    id = Column(Integer, primary_key = True)\n" +
                "    name = Column(String(250), nullable = False)\n" +
                "\n" +
                "class MenuItem(Base):\n" +
                "    __tablename__ = 'menu_item'\n" +
                "\n" +
                "    name = Column(String(80), nullable = False)\n" +
                "    id = Column(Integer, primary_key = True)\n" +
                "    description = Column(String(250))\n" +
                "    price = Column(String(8))\n" +
                "    course = Column(String(250))\n" +
                "    restaurant_id = Column(Integer, ForeignKey('restaurant.id'))\n" +
                "    restaurant = relationship(Restaurant)\n" +
                "\n" +
                "\n" +
                "engine = create_engine('sqlite:///restaurantmenu.db')\n" +
                "Base.metadata.create_all(engine)\n");


        String[] orange = {"import", " def", " for", " in","True","False","from"};
        String[] purple = {" range", " print", " open"," id"};
        String[] red = {"#print(content_text)"};
        String[] blue = {" Restaurant", " MenuItem"};
        String[] green = {"'sqlite:///restaurantmenu.db'","'restaurant'","'menu_item'","'restaurant.id'"};

        for (String y : orange) {
            fontColor.Codedisplayer(textView, y, 0xFFF4B511);

        }

        for (String y : purple) {
            fontColor.Codedisplayer(textView, y, 0xFF8B008B);

        }

        for (String y : red) {
            fontColor.Codedisplayer(textView, y, 0xFFF44336);

        }

        for (String y : blue) {
            fontColor.Codedisplayer(textView, y, 0xFF2D96F4);

        }

        for (String y : green) {
            fontColor.Codedisplayer(textView, y, 0xFFA7FA9F);

        }

        return view;
    }
}
