package com.example.fmadaat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SheetListActivity extends AppCompatActivity {
private ListView sheetList;
private ArrayAdapter adapter;
private ArrayList<String>listItems=new ArrayList();
private long cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_list);

        cid=getIntent().getLongExtra("cid",-1);
        sheetList=findViewById(R.id.sheetList);
        adapter=new ArrayAdapter(this,R.layout.sheet_list,R.id.date_list_item,listItems);
        sheetList.setAdapter(adapter);
        sheetList.setOnItemClickListener( (parent, view, position, id) -> openSheetActivity(position));
        LoadListItems();

    }
private void openSheetActivity(int position)
{   long[]id_Array =getIntent().getLongArrayExtra("idArray");
    int[]roll_Array= getIntent().getIntArrayExtra("rollArray");
    String[]name_Array=getIntent().getStringArrayExtra("nameArray");
    Intent intent=new Intent(this,SheetActivity.class);
    intent.putExtra("idArray",id_Array);
    intent.putExtra("rollArray",roll_Array);
    intent.putExtra("nameArray",name_Array);
    intent.putExtra("month",listItems.get(position));
    startActivity(intent);
}
    private void LoadListItems()
{
        Cursor cursor=new DbHelper(this).getDistinctMonths(cid);
        while(cursor.moveToNext())
        {
            String date=cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.DATE_KEY));
            listItems.add(date.substring(3));
        }
    }
}