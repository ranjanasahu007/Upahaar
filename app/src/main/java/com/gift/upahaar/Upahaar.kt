package com.gift.upahaar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gift.upahaar.Result
import com.gift.upahaar.databinding.UpahaarBinding

class Upahaar : AppCompatActivity() {

    private lateinit var access: UpahaarBinding
    private var countForArrow1 = 0

    private var countForArrow2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        access = UpahaarBinding.inflate(layoutInflater)
        setContentView(access.root)

        access.llPopularOccasion.setOnClickListener {
            countForArrow1++

            if (countForArrow1 % 2 == 0){
                access.arrow1.setImageResource(R.drawable.arrowicon)

                access.icons1.visibility = View.GONE
            }
            else{
                access.arrow1.setImageResource(R.drawable.arrow2)
                access.icons1.visibility = View.VISIBLE
            }
        }

        access.llSpecialMembers.setOnClickListener {
            countForArrow2++

            if (countForArrow2 % 2 == 0){
                access.arrow2.setImageResource(R.drawable.arrowicon)

                access.icons2.visibility = View.GONE
            }
            else{
                access.arrow2.setImageResource(R.drawable.arrow2)
                access.icons2.visibility = View.VISIBLE
            }
        }

        access.iconbirthday.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "birthday")
            startActivity(intent)
        }

        access.iconanniversary.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "anniversary")
            startActivity(intent)
        }

        access.iconvalentine.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "valentine")
            startActivity(intent)
        }

        access.icondiwali.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "diwali")
            startActivity(intent)
        }

        access.iconmothersday.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "mothersday")
            startActivity(intent)
        }

        access.iconteacher.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "teacher")
            startActivity(intent)
        }

        access.iconchristmas.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "christmas")
            startActivity(intent)
        }

        access.iconnewyear.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "newyear")
            startActivity(intent)
        }

        access.iconrakshabandhan.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "rakshabandhan")
            startActivity(intent)
        }

        access.iconfather.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "father")
            startActivity(intent)
        }

        access.iconmother.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "mother")
            startActivity(intent)
        }

        access.iconbrother.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "brother")
            startActivity(intent)
        }

        access.iconsister.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "sister")
            startActivity(intent)
        }

        access.iconbestfriend.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "bestfriend")
            startActivity(intent)
        }

        access.iconwife.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "wife")
            startActivity(intent)
        }

        access.iconhusband.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "husband")
            startActivity(intent)
        }

        access.icongrandp.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "grandp")
            startActivity(intent)
        }

        access.iconnewborn.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("icon", "newborn")
            startActivity(intent)
        }

    }
}      