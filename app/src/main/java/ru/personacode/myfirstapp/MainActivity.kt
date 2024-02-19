package ru.personacode.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.personacode.myfirstapp.databinding.ActivityMainBinding

const val MAXIMUM_PASSENGERS: Int = 49

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var passengers: Int = 0

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) // xml-файл activity_main
        setContentView(binding.root)

        fun recalcFunc() {
            when {
                passengers <= 0 -> {
                    passengers = 0
                    binding.clearButton.visibility = View.INVISIBLE
                    binding.centralTextInfo.text = getText(R.string.allSeatsAreFree)
                    binding.centralTextInfo.setTextColor(getColor(R.color.green))
                }

                passengers > MAXIMUM_PASSENGERS -> {
                    binding.clearButton.visibility = View.VISIBLE
                    binding.centralTextInfo.text = getText(R.string.tooManyPassengers)
                    binding.centralTextInfo.setTextColor(getColor(R.color.red))

                }

                else -> {
                    binding.clearButton.visibility = View.INVISIBLE
                    binding.centralTextInfo.text =
                        getText(R.string.freeSeats).toString() +
                                (MAXIMUM_PASSENGERS - passengers).toString()
                    binding.centralTextInfo.setTextColor(getColor(R.color.blue))
                }
            }
            binding.textCounter.text = passengers.toString()
        }

        binding.plusOneButton.setOnClickListener {
            passengers++
            recalcFunc()
        }

        binding.minusOneButton.setOnClickListener {
            passengers--
            recalcFunc()
        }

        binding.clearButton.setOnClickListener {
            passengers = 0
            recalcFunc()
        }
    }
}
