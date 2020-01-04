package com.example.gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.text.SimpleDateFormat
import java.util.*
const val EXTRA_GAME = "EXTRA_GAME"

class AddActivity : AppCompatActivity() {

    private lateinit var viewModel: AddActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener { onSaveClick() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddActivityViewModel::class.java)
    }
    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank()) {
            var dateString = etDay.text.toString() + etMonth.text.toString() + etYear.text.toString()
            var dateFormat = SimpleDateFormat("ddmmyyyy")
            var date = dateFormat.parse(dateString)
            val game = Game(etTitle.text.toString(), etPlatform.text.toString(), date)
            viewModel.insertGame(game)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }

}
