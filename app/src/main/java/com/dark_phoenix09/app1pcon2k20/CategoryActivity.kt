package com.dark_phoenix09.app1pcon2k20

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.dark_phoenix09.app1pcon2k20.SignInUp.RegisterActivity
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.gridcategoryitemlayout.view.*

class CategoryActivity : AppCompatActivity() {
    var adapter:CategoryAdapter?=null
    var listOfCats=ArrayList<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setSupportActionBar(toolbar3)
        setTitle(R.string.Category)
        listOfCats.add(Category("Maths",R.drawable.ic_calculate_24px))
        listOfCats.add(Category("GK",R.drawable.ic_public_24px))
        listOfCats.add(Category("Bollywood",R.drawable.ic_theaters_24px))
        listOfCats.add(Category("Science",R.drawable.ic_science_24px))
        listOfCats.add(Category("Food",R.drawable.ic_local_dining_24px))
        listOfCats.add(Category("Sports",R.drawable.ic_sports_cricket_24px))
        listOfCats.add(Category("India",R.drawable.ic_flag_24px))
        listOfCats.add(Category("Tech",R.drawable.ic_computer_24px))
        listOfCats.add(Category("Basic",R.drawable.ic_foundation_24px))
        adapter= CategoryAdapter(this,listOfCats)
        gridview.adapter=adapter
    }
    class CategoryAdapter:BaseAdapter{
        var listOfCats=ArrayList<Category>()
        var context: Context?=null
        constructor(context: Context,listOfCats:ArrayList<Category>):super(){
            this.context=context
            this.listOfCats=listOfCats
        }
        override fun getCount(): Int {
return listOfCats.size        }

        override fun getItem(p0: Int): Any {
return listOfCats[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
         }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
           var Category=listOfCats[p0]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView=inflator.inflate(R.layout.gridcategoryitemlayout,null)

            foodView.imageView.setImageResource(Category.image!!)
            foodView.imageView.setOnClickListener {
                val intent= Intent(context,SetActivity::class.java)
                context!!.startActivity(intent)
            }
            foodView.textView3.text=Category.name!!
            return foodView
        }

    }


}