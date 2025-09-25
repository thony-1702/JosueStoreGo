package app.ecommerce.josuestorego.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import app.ecommerce.josuestorego.Model.BrandModel
import app.ecommerce.josuestorego.Model.ItemModel
import app.ecommerce.josuestorego.Model.SliderModel
import app.ecommerce.josuestorego.Repository.MainRepository

class MainViewModel: ViewModel() {

    private val repository = MainRepository()

    val brands: LiveData<MutableList<BrandModel>> = repository.brands
    val banners: LiveData<List<SliderModel>> = repository.banners
    val popular: LiveData<MutableList<ItemModel>> = repository.popular


    fun loadBrands() = repository.loadBrands()
    fun loadBanners() = repository.loadBanners()
    fun loadPopular() = repository.loadPopular()

}