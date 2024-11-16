package ru.mirea.myapplication_task

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.Button)
        var linearLayoutFL = findViewById<LinearLayout>(R.id.FL)
        var stateColor = "purple"

        var editText = findViewById<EditText>(R.id.ET)

        var linearLayoutLL = findViewById<LinearLayout>(R.id.LL)
        var textView1 = findViewById<TextView>(R.id.TV)
        var stateColor2 = "green"


        val photo = findViewById<ImageView>(R.id.photo)
        val linearLayoutLR = findViewById<LinearLayout>(R.id.LR)
        var lastclicktime: Long = 0

        button.setOnClickListener{
            if (stateColor.equals("purple")){
                stateColor = "red"
                linearLayoutFL.background = AppCompatResources.getDrawable(this,R.color.purple)
            }
            else{
                stateColor = "purple"
                linearLayoutFL.background = AppCompatResources.getDrawable(this,R.color.red)
            }
        }


        photo.setOnClickListener{
            if (photo.isVisible && System.currentTimeMillis() - lastclicktime < 200)
                photo.visibility = ImageView.INVISIBLE
            lastclicktime = System.currentTimeMillis()
        }
        linearLayoutLR.setOnClickListener{
            if (photo.isInvisible && System.currentTimeMillis() - lastclicktime < 200)
                photo.visibility = ImageView.VISIBLE
            lastclicktime = System.currentTimeMillis()
        }

        linearLayoutLL.setOnLongClickListener{
            if (stateColor2 == "green"){
                stateColor2 = "blue"
                linearLayoutLL.background = AppCompatResources.getDrawable(this,R.color.light_blue)}
            else if (stateColor2 == "blue"){
                linearLayoutLL.background = AppCompatResources.getDrawable(this,R.color.green)
                stateColor2 = "green"
            }
            true
        }

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (editText.text.toString() == "Change Text in TV")
                    textView1.text = getString(R.string.change)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

    }
}