package com.example.cs402_final.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
//import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.TagData
import com.example.cs402_final.fragments.SearchResults
import com.example.cs402_final.fragments.TagFragment

class TagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                var tagList = arrayListOf<TagData>(
                    TagData("Tag1"),
                    TagData("Tag2"),
                    TagData("Tag3"),
                    TagData("Tag4")
                )
                val bundle = bundleOf(
                    "fragType" to "manage",
                    "tags" to tagList
                )
                setReorderingAllowed(true)
                add<TagFragment>(R.id.fragmentContainerView, args = bundle)
            }
        }
    }
}