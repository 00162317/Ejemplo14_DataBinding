package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel
    //TODO 5: Variable para poner vistas
    lateinit var binding : com.aldana.ejemplo14.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //TODO 6: Pone la view por medio del binding
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        //TODO 7: Setear los valores
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)

        /*displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
*/
        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        /*displayScore(
            tv_score_team_a,
            ++scoreViewModel.scoreTeamA
        )*/
        binding.score= ScoreDataBinding(++scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)
    }

    fun addOneTeamB(v: View) {
        /*displayScore(
            tv_score_team_b,
            ++scoreViewModel.scoreTeamB
        )*/
        binding.score= ScoreDataBinding(scoreViewModel.scoreTeamA,++scoreViewModel.scoreTeamB)
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        /*displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )*/
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        /*displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )*/
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        /*displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )*/
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        /*displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )*/
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        /*displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )*/
        binding.score=ScoreDataBinding(scoreViewModel.scoreTeamA,scoreViewModel.scoreTeamB)

        /*displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )*/
    } // TODO: Limpiando datos
    //TODO 8: DataBinding no necesita que mande a llamar la funcion. Remplaza los valores!!
    /*fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }*/

}
