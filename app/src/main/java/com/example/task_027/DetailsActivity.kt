package com.example.task_027

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.system.exitProcess

class DetailsActivity : AppCompatActivity() {

    private lateinit var layoutCL: ConstraintLayout

    private lateinit var toolbar: Toolbar
    private lateinit var imageViewIV: ImageView
    private lateinit var displayNameTV: TextView
    private lateinit var displayDescriptionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        init()

        setSupportActionBar(toolbar)
        title = "Мой гардероб."

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }

        var clothesType: ClothesViewModal? = null
        if (intent.hasExtra("clothesType")) {
            clothesType = intent.getSerializableExtra("clothesType") as ClothesViewModal
        }
        if (clothesType != null) {
            imageViewIV.setImageResource(clothesType.image)
            displayNameTV.text = clothesType.name
            displayDescriptionTV.text = clothesType.description
        }

        layoutCL.setOnLongClickListener (
            View.OnLongClickListener {
                val dialog = AlertDialog.Builder(this)
                val inflater = this.layoutInflater
                val dialogView = inflater.inflate(R.layout.update_dialog, null)
                dialog.setView(dialogView)
                val editName = dialogView.findViewById(R.id.updateNameET) as EditText
                val editDescription = dialogView.findViewById(R.id.updateDescriptionET) as EditText

                dialog.setTitle("Обновить запись")
                dialog.setTitle("Введите данные ниже")
                dialog.setPositiveButton("обновить") {_, _, ->
                    displayNameTV.text = editName.text.toString()
                    displayDescriptionTV.text = editDescription.text.toString()
                }
                dialog.setNegativeButton("Отмена") {_, _, -> }
                dialog.create().show()
                false
            }
        )
    }

    fun init() {
        layoutCL = findViewById(R.id.layoutCL)
        toolbar = findViewById(R.id.toolbar)
        imageViewIV = findViewById(R.id.imageViewIV)
        displayNameTV = findViewById(R.id.displayNameTV)
        displayDescriptionTV = findViewById(R.id.displayDescriptionTV)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain->{
                moveTaskToBack(true);
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}