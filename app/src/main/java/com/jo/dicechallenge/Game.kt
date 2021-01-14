package com.jo.dicechallenge

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jo.dicechallenge.databinding.FragmentGameBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [Game.newInstance] factory method to
 * create an instance of this fragment.
 */
class Game : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        var args=GameArgs.fromBundle(requireArguments())
        binding.txtname.setText(args.name)
        var count_user=0
        var count_auto=0
        var record=0
        var record2=0
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val inflat=layoutInflater
        val viewwin:View=inflat.inflate(R.layout.win,container,false)
        val viewlose:View=inflat.inflate(R.layout.lose,container,false)
        fun  play() {
            val drawableResource:Int
            val count= Random.nextInt(6)+1
             when (count) {
                1 ->{
                    drawableResource=R.drawable.dice_1
                    count_user=1
                }
                2 -> {drawableResource=R.drawable.dice_2
                    count_user=2

                }
                3 -> {drawableResource=R.drawable.dice_3
                    count_user=3

                }
                4 ->{ drawableResource=R.drawable.dice_4
                    count_user=4

                }
                5 ->{drawableResource= R.drawable.dice_5
                    count_user=5

                }
                else -> {drawableResource=R.drawable.dice_6
                    count_user=6
                }


            }
               binding.imageView2.setImageResource(drawableResource)


        }

   fun playauto(){
       val drawableResource:Int
       val count= Random.nextInt(6)+1
       when (count) {
           1 ->{
               drawableResource=R.drawable.dice_1
               count_auto=1
           }
           2 -> {drawableResource=R.drawable.dice_2
               count_auto=2

           }
           3 -> {drawableResource=R.drawable.dice_3
               count_auto=3

           }
           4 ->{ drawableResource=R.drawable.dice_4
               count_auto=4

           }
           5 ->{drawableResource= R.drawable.dice_5
               count_auto=5

           }
           else -> {drawableResource=R.drawable.dice_6
               count_auto=6
           }
       }

                 binding.imag2.setImageResource(drawableResource)

   }
        binding.button2.setOnClickListener {
            play()
            playauto()


            if (count_user >=count_auto) {
                if (count_user >count_auto){
                       record++
                    binding.numname.setText(record.toString())
                }
                else
                {
                    record++
                    record2++
                     binding.numname.setText(record.toString())
                    binding.numname2.setText(record2.toString())
                }

            } else{
                record2++
                  binding.numname2.setText(record2.toString())
            }

            if (record >=10||record2>=10) {
                if(record>=10) {
                     dialogBuilder.setView(viewwin)
                     val dialog:AlertDialog=dialogBuilder.create()
                    dialog.show()
                    record=0
                    record2=0
                    binding.numname.setText(record.toString())
                    binding.numname2.setText(record2.toString())
                         viewwin.setOnClickListener {
                             dialog.dismiss()
                         }
                      }
                else {
                      dialogBuilder.setView(viewlose)
                     val dialog:AlertDialog=dialogBuilder.create()  
                      dialog.show()
                      record=0
                      record2=0
                      binding.numname.setText(record.toString())
                      binding.numname2.setText(record2.toString())
                     viewlose.setOnClickListener {
                       dialog.dismiss()
        }            }
            }
              }
        return binding.root
    }


}