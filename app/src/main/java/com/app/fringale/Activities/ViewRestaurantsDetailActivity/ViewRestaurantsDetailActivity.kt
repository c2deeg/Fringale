package com.app.fringale.Activities.ViewRestaurantsDetailActivity

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewCartActivity.ViewCartActivity
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.Presenter.ViewRestaurantsDetailPresenter
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.View.ViewRestaurantsDetailView
import com.app.fringale.Adapter.BrowseMenuRecylerAdapter
import com.app.fringale.Adapter.FoodItemsCategoriesAdapter
import com.app.fringale.Models.GetRestaurantByid.Data
import com.app.fringale.R
import com.app.fringale.StaticModels.MM
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivityViewRestaurantsDetailBinding
import com.app.fringale.interfaces.NestedClickListener


class ViewRestaurantsDetailActivity : AppCompatActivity(), NestedClickListener,
    View.OnClickListener, ViewRestaurantsDetailView {
    private var binding: ActivityViewRestaurantsDetailBinding? = null
    private var viewRestaurantsDetailPresenter: ViewRestaurantsDetailPresenter? = null
    private var restaurantid: String? = null
    var flag: Boolean = false
    var flag2:Boolean = false



    private var foodItemsCategoriesAdapter: FoodItemsCategoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewRestaurantsDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        listeners()



        restaurantid = intent.getStringExtra("restaurantid")
        viewRestaurantsDetailPresenter = ViewRestaurantsDetailPresenter(this, this,this, binding!!.fooditemscategoriesrecyclerview)



        viewRestaurantsDetailPresenter?.getallRestaurantByIdMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                restaurantid.toString())

        viewRestaurantsDetailPresenter?.getrestaurntsItemMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
            restaurantid.toString(),true,false,false,false)




    }

    private fun listeners() {
        binding!!.imgback.setOnClickListener(this)
        binding!!.InnerRelativeLayout.setOnClickListener(this)
        binding!!.tvbrowsemenu.setOnClickListener(this)
        binding!!.linbestseller.setOnClickListener(this)
        binding!!.linfourrating.setOnClickListener(this)
    }

    override fun passData(imgadd: ArrayList<MM>, qnt: Int, value: Int) {
        Toast.makeText(this, value.toString(), Toast.LENGTH_SHORT).show()
        if (value > 0) {
            binding!!.InnerRelativeLayout.visibility = View.VISIBLE
        } else {

            binding!!.InnerRelativeLayout.visibility = View.GONE

        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imgback -> finish()
            R.id.InnerRelativeLayout -> {
                Utils.movetoActivity(this, ViewCartActivity())
            }
            R.id.tvbrowsemenu ->   showDialog()
            R.id.linbestseller->{
                if(flag){
                    viewRestaurantsDetailPresenter?.getrestaurntsItemMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                        restaurantid.toString(),true,false,false,true)

                    binding?.imgcross?.visibility =View.VISIBLE
                    binding?.linbestseller?.setBackgroundDrawable(resources.getDrawable(R.drawable.redbground))

                }else{
                    viewRestaurantsDetailPresenter?.getrestaurntsItemMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                        restaurantid.toString(),true,false,false,false)
                    binding?.imgcross?.visibility =View.GONE
                    binding?.linbestseller?.setBackgroundDrawable(resources.getDrawable(R.drawable.roundcornerstroke))
                }
                flag = !flag
            }
            R.id.linfourrating->{
                if (flag2){
                    viewRestaurantsDetailPresenter?.getrestaurntsItemMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                        restaurantid.toString(),true,false,true,false)
                    binding?.imgcross2?.visibility =View.VISIBLE
                    binding?.linfourrating?.setBackgroundDrawable(resources.getDrawable(R.drawable.redbground))

                }else{
                    viewRestaurantsDetailPresenter?.getrestaurntsItemMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                        restaurantid.toString(),true,false,false,false)
                    binding?.imgcross2?.visibility =View.GONE
                    binding?.linfourrating?.setBackgroundDrawable(resources.getDrawable(R.drawable.roundcornerstroke))
                }
                flag2 = !flag2


            }



        }
    }


    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.browsemenudialog)
        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.CENTER
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = wlp
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        val browsemenufunctionalityrecyclerview =
            dialog.findViewById<View>(R.id.browsemenufunctionalityrecyclerview) as RecyclerView
        val imgclose = dialog.findViewById<View>(R.id.imgclose) as ImageView

        imgclose.setOnClickListener {
            dialog.dismiss()
        }

        var browseMenuRecylerAdapter: BrowseMenuRecylerAdapter = BrowseMenuRecylerAdapter(this)
        browsemenufunctionalityrecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        browsemenufunctionalityrecyclerview.adapter = browseMenuRecylerAdapter



        dialog.show()
    }


    override fun showMessage(activity: Activity?, msg: String?) {
        Utils.showMessage(activity,msg)

    }

    override fun showDialog(activity: Activity?) {
        Utils.showDialogMethod(activity,activity?.fragmentManager)
    }

    override fun hideDialog() {
        Utils.hideDialog()
    }

    override fun getData(activity: ViewRestaurantsDetailActivity, data: Data) {
        binding!!.tvrestaurantname.text = data.name
        binding!!.tvlocation.text = data.address
        if (data.bestSeller.equals("yes")) binding?.tvpureveg?.visibility = View.VISIBLE else binding?.tvpureveg?.visibility = View.GONE
        if (data.non_veg.equals("yes")) binding?.tvpureveg?.visibility = View.GONE else binding?.tvpureveg?.visibility = View.VISIBLE
//        if (data.fourRating.equals("no")) binding?.tvratingfour?.visibility = View.GONE else binding?.tvpureveg?.visibility = View.VISIBLE

    }



}