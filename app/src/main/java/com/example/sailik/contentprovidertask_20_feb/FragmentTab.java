package com.example.sailik.contentprovidertask_20_feb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentTab extends AppCompatActivity implements View.OnClickListener{
    private Button mAddButton;
    DbHelper dbHelper;
    private ListView listView;
    String albumname;
    String trackname;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        albumname=intent.getStringExtra("albumName");
//        trackname=intent.getStringExtra("trackName");
        setContentView(R.layout.activity_fragment_tab);
        mAddButton = (Button) findViewById(R.id.add_button);
        mAddButton.setOnClickListener(this);

//        dbHelper = new DbHelper(this);
//        //dbHelper.getWritableDatabase();
//
//        final Cursor cursor = dbHelper.getAllMusicItems();
//
//        String [] columns = new String[] {
//                DbHelper.COLUMN_ID,
//                DbHelper.COLUMN_ALBUM,
//                DbHelper.COLUMN_TRACK
//        };
//        int [] widgets = new int[] {
//                R.id.itemID,
//                R.id.albumname_tv,
//                R.id.trackname_tv
//        };
//
//        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.music_item_info,
//                cursor, columns, widgets, 0);
//        listView = (ListView)findViewById(R.id.listview);
//        listView.setAdapter(cursorAdapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
//        Intent intent = getIntent();
//        if(intent != null){
//            albumname=intent.getStringExtra("albumName");
//            trackname=intent.getStringExtra("trackName");
//            dbHelper.insertMusicItem(albumname,trackname);
//        }
//        dbHelper = new DbHelper(this);
//        //dbHelper.getWritableDatabase();
//        final Cursor cursor = dbHelper.getAllMusicItems();
//        String [] columns = new String[] {
//                DbHelper.COLUMN_ID,
//                DbHelper.COLUMN_ALBUM,
//                DbHelper.COLUMN_TRACK
//        };
//        int [] widgets = new int[] {
//                R.id.itemID,
//                R.id.albumname_tv,
//                R.id.trackname_tv
//        };
//        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.music_item_info,
//                cursor, columns, widgets, 0);
//        listView = (ListView)findViewById(R.id.listview);
//        listView.setAdapter(cursorAdapter);
    }


    @Override
    protected void onResume(){
        super.onResume();
        dbHelper = new DbHelper(this);
        Intent intent = getIntent();
        final Cursor cursor;
        if(intent != null){
            albumname=intent.getStringExtra("albumName");
            trackname=intent.getStringExtra("trackName");
            if(albumname!=""&&trackname!=""){
                dbHelper.insertMusicItem(albumname,trackname);
                getIntent().removeExtra("albumName");
                getIntent().removeExtra("trackName");
//            getIntent(
            }
        }
        //dbHelper.getWritableDatabase();
        if(dbHelper.getAllMusicItems()==null) {
            //cursor = dbHelper.getAllMusicItems();
        }
        else {
            cursor = dbHelper.getAllMusicItems();
            String[] columns = new String[]{
                    DbHelper.COLUMN_ID,
                    DbHelper.COLUMN_ALBUM,
                    DbHelper.COLUMN_TRACK
            };
            int[] widgets = new int[]{
                    R.id.itemID,
                    R.id.albumname_tv,
                    R.id.trackname_tv
            };

            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.music_item_info,
                    cursor, columns, widgets, 0);
            listView = (ListView) findViewById(R.id.listview);
            listView.setAdapter(cursorAdapter);
        }

//        Intent intent = getIntent();
//        if(intent != null){
//            albumname=intent.getStringExtra("albumName");
//            trackname=intent.getStringExtra("trackName");
//            dbHelper.insertMusicItem(albumname,trackname);
//        }
    }



    public void toAdd(){
        Intent i = new Intent(FragmentTab.this,AddItem.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(FragmentTab.this,AddItem.class);
        startActivity(i);
    }
}
