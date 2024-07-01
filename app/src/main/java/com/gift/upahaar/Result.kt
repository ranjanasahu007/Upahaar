package com.gift.upahaar

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.gift.upahaar.Result
import com.gift.upahaar.databinding.ResultBinding
import java.lang.Exception

class Result : AppCompatActivity() {

    private var progressStatus = 0
    lateinit var toolbarText: String

    lateinit var access: ResultBinding
    private val handler = Handler(Looper.getMainLooper())

    var isArrowFreeze = true
    var isBlockBackPress = true
    var isRefreshed = false

    private  val birthdayImg = mapOf(
        R.drawable.alexa to "Alexa Home",
        R.drawable.kapda to "Fashion wear",
        R.drawable.pendent to " A Pendent",
        R.drawable.painting to "Painting",
        R.drawable.shoes to "Shoes",
        R.drawable.watch to "What about a Watch"
    )

    private  val anniversaryImg = mapOf(
        R.drawable.couplebracelet to "A bracelet",
        R.drawable.giftbasket to "Gift Basket",
        R.drawable.holiday to " A holiday Destination",
        R.drawable.lamps to "Lamps",
        R.drawable.p_ar5twork to "Personalized Artwork",
        R.drawable.statue to "Decorative Statue"
    )

    private  val valentineImg = mapOf(
        R.drawable.card to "A Love Card",
        R.drawable.flowers to "Gift Fresh Flowers",
        R.drawable.ledlights to " Led Lights",
        R.drawable.lunchdate to "what about a Lunch Date",
        R.drawable.photocollage to "Personalized photo collage",
        R.drawable.ring to "Matching Rings"
    )

    private  val diwaliImg = mapOf(
        R.drawable.decoration to "Home Decors",
        R.drawable.decorativeitems to "Light Decors",
        R.drawable.lights to " Led Lights",
        R.drawable.silvercoin to "Auspicious Coins",
        R.drawable.sweets to "Some Delicious Sweets",
        R.drawable.decorativediya to "Diyas'"
    )

    private  val motherImg = mapOf(
        R.drawable.bangles to "Bangles",
        R.drawable.flats to "Footwear",
        R.drawable.necklace to "Necklace",
        R.drawable.payal to "Payal",
        R.drawable.saree to "Sarees!"
    )

    private  val christmasImg = mapOf(
        R.drawable.choclates to "Chocolates",
        R.drawable.cmug to "what about a coffee mug!",
        R.drawable.dress to "A dress",
        R.drawable.novels to "Novels",
        R.drawable.tech to "some tech gadgets!"
    )

    private  val teacherImg = mapOf(
        R.drawable.tcard to "Cards",
        R.drawable.diary to "what about a diary!",
        R.drawable.globe to "A globe",
        R.drawable.pen to "Pens",
        R.drawable.photoframe to "A photo frame!"
    )

    private  val newyearImg = mapOf(
        R.drawable.champagne to "A champagne",
        R.drawable.dumbell to "A dumbbell for new start!",
        R.drawable.nycard to "New Years Card",
        R.drawable.pcalender to "Personalized Calender",
        R.drawable.planner to "A day planner!"
    )

    private  val sisterrbgfwifeImg = mapOf(
        R.drawable.bangles to "Bangles",
        R.drawable.flats to "Footwear",
        R.drawable.necklace to "Necklace",
        R.drawable.payal to "Payal",
        R.drawable.anklet to "what about anklet!!",
        R.drawable.saree to "Sarees!",
        R.drawable.earring to "Earring!",
        R.drawable.ethnicwear to "Ethnic Wear!",
        R.drawable.gwatch to "Watch!",
        R.drawable.makeup to "Makeup products!",
        R.drawable.perfume to "A classy Perfume!"
    )

    private  val fatherImg = mapOf(
        R.drawable.formalshoes to "Formal Shoes",
        R.drawable.rings to "Ring",
        R.drawable.rolex to "Watch",
        R.drawable.shirt to "Shirt",
        R.drawable.wallet to "Wallet!"
    )

    private  val brotherImg = mapOf(
        R.drawable.dumbbel to "Dumbbell",
        R.drawable.gaming to "Gaming accessories",
        R.drawable.menbracelet to "Bracelet for men",
        R.drawable.loafers to "Loafers",
        R.drawable.perfumemen to "Perfume!"
    )

    private  val bestfriendImg = mapOf(
        R.drawable.bagpack to "Bagpack",
        R.drawable.band to "Friendship Band",
        R.drawable.books to "Novels",
        R.drawable.craftkit to "Crafting Kit",
        R.drawable.drinks to "Imported Tea OR Coffee Drinks!"
    )

    private  val grandpImg = mapOf(
        R.drawable.carvan to "Saregama Carvan",
        R.drawable.ghome to "Google Home",
        R.drawable.journel to "Memory Journel",
        R.drawable.outing to "Plan a outing with them!",
        R.drawable.photo to "Personalized Photo Collage"
    )

    private  val newbornImg = mapOf(
        R.drawable.babybed to "Bed",
        R.drawable.babyclothes to "Clothes for Babies",
        R.drawable.babykit to "Baby kit",
        R.drawable.cradle to "A baby Cradle",
        R.drawable.quilt to "A quilt set",
        R.drawable.softtoys to "Soft Toys"
    )

    private val bfImg = mapOf(
        R.drawable.dumbbel to "Dumbbell",
        R.drawable.gaming to "Gaming accessories",
        R.drawable.menbracelet to "Bracelet for men",
        R.drawable.loafers to "Loafers",
        R.drawable.perfumemen to "Perfume!",
        R.drawable.formalshoes to "Formal Shoes",
        R.drawable.rings to "Ring",
        R.drawable.rolex to "Watch",
        R.drawable.shirt to "Shirt",
        R.drawable.wallet to "Wallet!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        access = ResultBinding.inflate(layoutInflater)
        setContentView(access.root)

       startWorking()

        if (!isRefreshed){
            access.refreshbtn.setOnClickListener {
                startWorking()
            }
        }

    }

    private fun startWorking() {

        isArrowFreeze = true
        isBlockBackPress = true
        isRefreshed = false

        access.buylink.setOnClickListener {


            val amazonUrl = "https://www.amazon.in"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(amazonUrl))
            intent.setPackage("com.amazon.mobile.shopping")

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(amazonUrl)))
            }
        }

        access.feedback.setOnClickListener {
            val recipientEmail = "ranjanasahu2989991@gmail.com"
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))

            }
            if (emailIntent.resolveActivity(packageManager) != null){
                startActivity(emailIntent)
            }
        }

        getStringExtra()
        access.progressbar.progress = 0

        progressProcess()


        access.backicon.setOnClickListener {
            if (!isArrowFreeze){
                isBlockBackPress = false
                isRefreshed = true
                finish()
            }
            else{
                Toast.makeText(this, "Selection process in Progress...", Toast.LENGTH_SHORT).show()
                isBlockBackPress = true
                isRefreshed = false
            }
        }

    }

    override fun onBackPressed() {
        if (!isBlockBackPress){
            super.onBackPressed()
        }
        else{
            Toast.makeText(this, "Selection process in Progress...", Toast.LENGTH_SHORT).show()

        }
    }

    private fun getStringExtra() {
        if (intent.getStringExtra("icon") == "birthday"){
            toolbarText = "Birthday"
        }
        else if (intent.getStringExtra("icon") == "anniversary"){
            toolbarText = "Anniversary"
        }
        else if (intent.getStringExtra("icon") == "valentine"){
            toolbarText = "Valentines Day"
        }
        else if (intent.getStringExtra("icon") == "diwali"){
            toolbarText = "Diwali"
        }
        else if (intent.getStringExtra("icon") == "mothersday"){
            toolbarText = "Mother's Day"
        }
        else if (intent.getStringExtra("icon") == "teacher"){
            toolbarText = "Teacher's Day"
        }
        else if (intent.getStringExtra("icon") == "christmas"){
            toolbarText = "Christmas"
        }
        else if (intent.getStringExtra("icon") == "newyear"){
            toolbarText = "New Years"
        }
        else if (intent.getStringExtra("icon") == "rakshabandhan"){
            toolbarText = "Raksha Bandhan"
        }
        else if (intent.getStringExtra("icon") == "father"){
            toolbarText = "Father"
        }
        else if (intent.getStringExtra("icon") == "mother"){
            toolbarText = "Mother"
        }
        else if (intent.getStringExtra("icon") == "brother"){
            toolbarText = "Brother"
        }
        else if (intent.getStringExtra("icon") == "sister"){
            toolbarText = "Sister"
        }
        else if (intent.getStringExtra("icon") == "bestfriend"){
            toolbarText = "Best Friend"
        }
        else if (intent.getStringExtra("icon") == "wife"){
            toolbarText = "GF/Wife"
        }
        else if (intent.getStringExtra("icon") == "husband"){
            toolbarText = "BF/Husband"
        }
        else if (intent.getStringExtra("icon") == "grandp"){
            toolbarText = "Grand Parents"
        }
        else if (intent.getStringExtra("icon") == "newborn"){
            toolbarText = "New Born"
        }
        else{
            toolbarText = "Occasion"
        }



        access.toolbartext.text = toolbarText
    }

    private fun progressProcess() {
        access.imgview.visibility = View.GONE
        access.quotes.visibility =  View.VISIBLE
        access.imgtext.visibility = View.GONE
        access.refreshbtn.visibility =  View.GONE

        var shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shakeanimation)
        access.quotes.startAnimation(shakeAnim)

        access.progressbar.max = 3000
        handler.postDelayed({
            resultProcess()
        }, 3000)
        updateProgress()
    }

    private fun updateProgress() {
        handler.postDelayed({
            val currentProgress = access.progressbar.progress
            if (currentProgress < 3000) {

                if(currentProgress < 750){
                        access.quotes.text = "Äre you excited"
                    }
                    else if (currentProgress < 1500){
                        access.quotes.text = "Take a deep breath."
                    }
                    else if (currentProgress < 2250){
                        access.quotes.text = "Hold On"

                    }
                    else if (currentProgress < 2970){
                        access.quotes.text = "Here we go!!"

                    }else{
                        access.quotes.text = "!!!!!!"

                    isArrowFreeze = false
                    isBlockBackPress = false
                    isRefreshed = true

                    access.imgview.visibility = View.VISIBLE
                    access.quotes.visibility =  View.GONE
                    access.imgtext.visibility = View.VISIBLE
                    access.refreshbtn.visibility =  View.VISIBLE
                }




                access.progressbar.progress += 30
                updateProgress()
            }
        }, 30)
    }

    private fun resultProcess() {

        var randomEntry : Map.Entry<Int, String> = birthdayImg.entries.random()

        when(toolbarText){
            "Birthday" -> {
                randomEntry = birthdayImg.entries.random()
                randomEntry = birthdayImg.entries.random()
                randomEntry = birthdayImg.entries.random()

            }
            "Anniversary" -> {
                randomEntry = anniversaryImg.entries.random()
                randomEntry = anniversaryImg.entries.random()
                randomEntry = anniversaryImg.entries.random()
            }
            "Valentines Day" -> {
                randomEntry = valentineImg.entries.random()
                randomEntry = valentineImg.entries.random()
                randomEntry = valentineImg.entries.random()
            }
            "Diwali" -> {
                randomEntry = diwaliImg.entries.random()
                randomEntry = diwaliImg.entries.random()
                randomEntry = diwaliImg.entries.random()

            }
            "Mother's Day" -> {
                randomEntry = motherImg.entries.random()
                randomEntry = motherImg.entries.random()
                randomEntry = motherImg.entries.random()

            }
            "Teacher's Day" -> {
                randomEntry = teacherImg.entries.random()
                randomEntry = teacherImg.entries.random()
                randomEntry = teacherImg.entries.random()
            }
            "Christmas" -> {
                randomEntry = christmasImg.entries.random()
                randomEntry = christmasImg.entries.random()
                randomEntry = christmasImg.entries.random()
            }
            "New Years" -> {
                randomEntry = newyearImg.entries.random()
                randomEntry = newyearImg.entries.random()
                randomEntry = newyearImg.entries.random()
            }

            "Raksha Bandhan" -> {
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()

            }
            "Father" -> {
                randomEntry = fatherImg.entries.random()
                randomEntry = fatherImg.entries.random()
                randomEntry = fatherImg.entries.random()
            }
            "Mother" -> {
                randomEntry = motherImg.entries.random()
                randomEntry = motherImg.entries.random()
                randomEntry = motherImg.entries.random()
            }
            "Brother" -> {
                randomEntry = brotherImg.entries.random()
                randomEntry = brotherImg.entries.random()
                randomEntry = brotherImg.entries.random()
            }
            "Sister" -> {
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()

            }
            "Best Friend" -> {
                randomEntry = bestfriendImg.entries.random()
                randomEntry = bestfriendImg.entries.random()
                randomEntry = bestfriendImg.entries.random()
            }
            "GF/Wife" -> {
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()
                randomEntry = sisterrbgfwifeImg.entries.random()
            }
            "BF/Husband" -> {
                randomEntry = bfImg.entries.random()
                randomEntry = bfImg.entries.random()
                randomEntry = bfImg.entries.random()
            }
            "Grand Parents" -> {
                randomEntry = grandpImg.entries.random()
                randomEntry = grandpImg.entries.random()
                randomEntry = grandpImg.entries.random()
            }
            "New Born" -> {
                randomEntry = newbornImg.entries.random()
                randomEntry = newbornImg.entries.random()
                randomEntry = newbornImg.entries.random()
            }

        }


        val randomImage = randomEntry.key
        val imageName = randomEntry.value
        access.imgview.setImageResource(randomImage)
        access.imgtext.text = "|| $imageName ||"
    }



}