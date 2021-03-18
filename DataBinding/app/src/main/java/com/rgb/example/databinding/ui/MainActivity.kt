package com.rgb.example.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rgb.example.databinding.R
import com.rgb.example.databinding.data.User
import com.rgb.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mUser : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mUser = User()
        mBinding.mCandidate = mUser
        mBinding.invalidateAll()

        mBinding.editData.setOnClickListener { view ->
            mBinding.detailsView.visibility = View.GONE
            mBinding.detailsEdit.visibility = View.VISIBLE
            view.visibility = View.GONE
            mBinding.saveData.visibility = View.VISIBLE
        }

        mBinding.saveData.setOnClickListener { view ->
            // Update data variable
            mUser.name = mBinding.editName.text.toString()
            mUser.description = mBinding.editDescription.text.toString()
            mUser.yearsOfExp = mBinding.editExp.text.toString().toFloat()
            mUser.skills = mBinding.editSkill.text.toString()

            // Refresh bound data in views
            mBinding.invalidateAll()

            // Switch back views
            mBinding.detailsView.visibility = View.VISIBLE
            mBinding.detailsEdit.visibility = View.GONE
            view.visibility = View.GONE
            mBinding.editData.visibility = View.VISIBLE
        }
    }
}