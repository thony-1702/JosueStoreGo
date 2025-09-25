package app.ecommerce.josuestorego.Activity

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ecommerce.josuestorego.Helper.ManagmentCart
import app.ecommerce.josuestorego.Model.ItemModel
import app.ecommerce.josuestorego.R
import app.ecommerce.josuestorego.databinding.ActivityDatailBinding
import com.bumptech.glide.Glide

class DatailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatailBinding
    private lateinit var item: ItemModel
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)
        item=intent.getSerializableExtra("object") as ItemModel

        setupViews()
    }

    private fun setupViews() = with(receiver = binding) {
        titleTxt.text = item.title
        descriptionTxt.text = item.description
        priceTxt.text = "$${item.price}"
        oldPriceTxt.text = "$${item.oldPrice}"
        oldPriceTxt.paintFlags = priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        ratingTxt.text = "${item.rating} Rating"
        numberItemTxt.text = item.numberInCart.toString()
        updateTotalPrice()

        Glide.with(this@DatailActivity)
            .load(item.picUrl.firstOrNull())
            .into(picMain)

        backBtn.setOnClickListener {
            finish()
        }

        plusBtn.setOnClickListener {
            item.numberInCart++
            numberItemTxt.text = item.numberInCart.toString()
            updateTotalPrice()
        }

        minusBtn.setOnClickListener {
            if (item.numberInCart > 1)
            item.numberInCart--
            numberItemTxt.text = item.numberInCart.toString()
            updateTotalPrice()
        }

        addToCartBtn.setOnClickListener {
            managmentCart.insert(item)
        }
    }

    private fun updateTotalPrice() = with( binding) {

        totalPriceTxt.text = "$${item.price * item.numberInCart}"
    }


}


