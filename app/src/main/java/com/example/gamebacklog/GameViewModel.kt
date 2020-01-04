package com.example.gamebacklog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val gameRepository = GameRepository(application.applicationContext)

    val games = gameRepository.getAllGames()


    fun deleteReminder(game: Game) {
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }

}