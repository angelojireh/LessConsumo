package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.models.SlideModel
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.NewProductsAdapter
import com.ecommerce.lessconsumo.adapters.SaleProductsAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mSaleProductsAdapter: SaleProductsAdapter
    private lateinit var mNewProductsAdapter: NewProductsAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private var saleProductsPage = 1
    private var newProductsPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addImageSlider()
        initButtonListeners()
        initNewProductsAdapter()
        initSaleProductsAdapter()
        loadNewArrivals(newProductsPage)
        loadSaleProducts(saleProductsPage)
        addNewProductsScrollListener()
        addSaleProductScrollListener()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonTops -> gotoNewActivity(TopsActivity())
            R.id.buttonBottoms -> gotoNewActivity(BottomsActivity())
            R.id.buttonDresses -> gotoNewActivity(DressesActivity())
            R.id.buttonBags -> gotoNewActivity(BagsActivity())
            R.id.buttonShoes -> gotoNewActivity(ShoesActivity())
            R.id.buttonMentops -> gotoNewActivity(MenTopsActivity())
            R.id.buttonMenbottoms -> gotoNewActivity(MenBottomsActivity())
            R.id.buttonBoys -> gotoNewActivity(BoysActivity())
            R.id.buttonGirls -> gotoNewActivity(GirlsActivity())
            R.id.buttonNotification -> showToast("This feature is not yet available.")
            R.id.buttonSearch -> gotoNewActivity(SearchActivity())
            R.id.buttonAccount -> gotoNewActivity(ProfilesActivity())
            R.id.buttonCart -> gotoNewActivity(CartActivity())
            R.id.buttonViewall -> showToast("This feature is not yet available.")
            R.id.textviewSale -> gotoNewActivity(SaleActivity())
            R.id.textviewMen -> gotoNewActivity(MenActivity())
            R.id.textviewWomen -> gotoNewActivity(WomenActivity())
            R.id.textviewChild -> gotoNewActivity(ChildActivity())
        }
    }

    private fun initButtonListeners() {
        buttonTops.setOnClickListener(this)
        buttonBottoms.setOnClickListener(this)
        buttonDresses.setOnClickListener(this)
        buttonBags.setOnClickListener(this)
        buttonShoes.setOnClickListener(this)
        buttonMentops.setOnClickListener(this)
        buttonMenbottoms.setOnClickListener(this)
        buttonBoys.setOnClickListener(this)
        buttonGirls.setOnClickListener(this)
        buttonNotification.setOnClickListener(this)
        buttonSearch.setOnClickListener(this)
        buttonAccount.setOnClickListener(this)
        buttonCart.setOnClickListener(this)
        buttonViewall.setOnClickListener(this)
        textviewSale.setOnClickListener(this)
        textviewMen.setOnClickListener(this)
        textviewWomen.setOnClickListener(this)
        textviewChild.setOnClickListener(this)
    }

    private fun initSaleProductsAdapter() {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mSaleProductsAdapter = SaleProductsAdapter(this)
        recyclerView_saleProducts.setHasFixedSize(true)
        recyclerView_saleProducts.layoutManager = mGridLayoutManager
        recyclerView_saleProducts.adapter = mSaleProductsAdapter
    }

    private fun initNewProductsAdapter() {
        mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mNewProductsAdapter = NewProductsAdapter(this)
        recyclerView_newArrivals.setHasFixedSize(true)
        recyclerView_newArrivals.layoutManager = mLinearLayoutManager
        recyclerView_newArrivals.adapter = mNewProductsAdapter
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun addImageSlider()
    {
        val slidemodels = ArrayList<SlideModel>()
        slidemodels.add(SlideModel(R.drawable.slider_1))
        slidemodels.add(SlideModel(R.drawable.slider_2))
        slidemodels.add(SlideModel(R.drawable.slider_3))
        slidemodels.add(SlideModel(R.drawable.slider_4))
        imageviewSlider.setImageList(slidemodels)
    }

    private fun loadNewArrivals(page: Int) {
        //load new arrivals
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchNewProducts(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_newArrivals.visibility =  View.VISIBLE
                mNewProductsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progress_newProducts.visibility = View.GONE
        })
    }

    private fun loadSaleProducts(page: Int) {
        // load sale products
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchOnSaleProducts(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_saleProducts.visibility =  View.VISIBLE
                mSaleProductsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progress_saleProducts.visibility = View.GONE
        })
    }

    private fun addSaleProductScrollListener() {
        recyclerView_saleProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    val visibleItemCount = mGridLayoutManager.childCount
                    val totalItemCount = mGridLayoutManager.itemCount
                    val pastVisibleItems = mGridLayoutManager.findFirstVisibleItemPosition()
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        saleProductsPage++
                        loadSaleProducts(saleProductsPage)
                    }
                }
            }
        })
    }

    private fun addNewProductsScrollListener(){
        recyclerView_newArrivals.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dx > 0){
                    val visibleItemCount = mLinearLayoutManager.childCount
                    val totalItemCount = mLinearLayoutManager.itemCount
                    val pastVisibleItems = mLinearLayoutManager.findFirstVisibleItemPosition()
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        newProductsPage++
                        loadNewArrivals(newProductsPage)
                    }
                }
            }
        })
    }
}