package com.example.equal.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.equal.MainActivity
import com.example.equal.R
import com.example.equal.activites.RegisterActivity
import com.example.equal.utilits.AUTH
import com.example.equal.utilits.USER
import com.example.equal.utilits.replaceActivity
import com.example.equal.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_phone_number.text = USER.phone
        settings_login.text = USER.username
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_username.text = USER.fullname
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      when (item.itemId){
          R.id.settings_menu_exit -> {
              AUTH.signOut()
              (activity as MainActivity).replaceActivity(RegisterActivity())
          }
          R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
      }
        return true
    }
}
