package com.example.maciapek.przypominacz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MenuSeriale_fragment extends MenuFilmy_fragment{

    //TODO: lista top seriali z filmweba i uri ich okładek
    private String[] topSeries = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć","siedem", "osiem", "dziewięć", "dziesięć", "jedenaście", "dwana","trzyna", "czterna", "piętna", "szesna", "siedemna", "osiemna","dziewiętna", "dwadz", "d jeden", "d dwa", "d trzy", "d cztery"};
    private String[] coverUri = {"http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg","http://1.fwcdn.pl/po/68/48/476848/7604108.3.jpg","http://1.fwcdn.pl/po/06/68/430668/7241342.3.jpg"};
    private String[] releaseDateF = {"01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001","01.01.2001"};
    private Boolean b = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.filmy_layout, container, false);

        ListAdapter topFilmsAdapter = new FilmyAdapter(getActivity().getApplicationContext(), topSeries, coverUri, releaseDateF);
        ListView topFilmy = (ListView) rootview.findViewById(R.id.topFilmy);
        topFilmy.setAdapter(topFilmsAdapter);

        topFilmy.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topFilm = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity().getApplicationContext(), topFilm, Toast.LENGTH_SHORT).show();
                        final ImageView icon = (ImageView)view.findViewById(R.id.addOrRemove);
                        icon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //TODO: dodanie/usunięcie z obserwowanych i zmiana ikony
                                //TODO: do ifa sprawdzenie warunku czy w obserwowanych
                                if (b) {
                                    Toast.makeText(getActivity().getApplicationContext(), R.string.added, Toast.LENGTH_SHORT).show();
                                    icon.setImageResource(R.drawable.minus);
                                    b = false;
                                } else {
                                    Toast.makeText(getActivity().getApplicationContext(), R.string.removed, Toast.LENGTH_SHORT).show();
                                    icon.setImageResource(R.drawable.plus);
                                    b = true;
                                }
                            }
                        });

                    }
                }
        );

        return rootview;
    }

}