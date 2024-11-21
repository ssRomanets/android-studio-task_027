package com.example.task_027

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class WardrobeActivity : AppCompatActivity() {

    private val clothes = mutableListOf(
        ClothesViewModal(R.drawable.clothes1,"брюки","светло-серые женские"),
        ClothesViewModal(R.drawable.clothes2, "брюки","светло-голубые женские"),
        ClothesViewModal(R.drawable.clothes3, "брюки","черные женские"),
        ClothesViewModal(R.drawable.clothes4, "брюки","красные женские"),
        ClothesViewModal(R.drawable.clothes5, "юбка","черная"),
        ClothesViewModal(R.drawable.clothes6, "юбка","с мелкими цветочками"),
        ClothesViewModal(R.drawable.clothes7, "юбка","с крупными цветами"),
        ClothesViewModal(R.drawable.clothes8, "юбка","зеленая"),
        ClothesViewModal(R.drawable.clothes9, "галстуки","набор галстуков"),
        ClothesViewModal(R.drawable.clothes10, "галстук","черный"),
        ClothesViewModal(R.drawable.clothes11, "галстуки","черные с белыми точками"),
        ClothesViewModal(R.drawable.clothes12, "шуба","черная норка"),
        ClothesViewModal(R.drawable.clothes13, "шуба","серая норка"),
        ClothesViewModal(R.drawable.clothes14, "шапка","красная шерстяная"),
        ClothesViewModal(R.drawable.clothes15, "шапка","синяя шерстяная"),
        ClothesViewModal(R.drawable.clothes16, "шапка","черная шерстяная"),
        ClothesViewModal(R.drawable.clothes17, "куртка","красная женская"),
        ClothesViewModal(R.drawable.clothes18, "куртка","зеленая женская"),
        ClothesViewModal(R.drawable.clothes19, "куртка","желтая женская"),
        ClothesViewModal(R.drawable.clothes20, "пуховик","женский бордовый")
    )

    private lateinit var toolbarMain: Toolbar
    private lateinit var recyclerViewRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)

        init()

        setSupportActionBar(toolbarMain)
        title = "Мой гардероб."

        recyclerViewRV.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(clothes)
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)
        adapter.setOnClothesViewModalClickListener( object :
            CustomAdapter.OnClothesViewModalClickListener {
            override fun onClothesViewModalClick(clothesType: ClothesViewModal, position: Int) {
                val intent = Intent(this@WardrobeActivity, DetailsActivity::class.java)
                intent.putExtra("clothesType", clothesType)
                startActivity(intent)
            }
        }
        )
    }

    fun init() {
        toolbarMain = findViewById(R.id.toolbarMain)
        recyclerViewRV = findViewById(R.id.recyclerViewRV)
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