package com.sandhya.notestodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhya.notestodo.adapter.NotesListAdapter
import com.sandhya.notestodo.databinding.ActivityMainBinding
import com.sandhya.notestodo.modules.Notes

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController : NavController
    lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.notesController)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.notesFragment,R.id.addUpdateFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

    }
}