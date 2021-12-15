package com.example.cs402_final.fragments

import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.TagAdapter
import com.example.cs402_final.adapters.TagData


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_FRAG = "fragType"
private const val ARG_LIST = "tags"

/**
 * A simple [Fragment] subclass.
 * Use the [TagFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TagFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var fragType: String? = null

    private lateinit var tagRecyclerView: RecyclerView
    private lateinit var tagList: ArrayList<TagData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fragType = it.getString(ARG_FRAG)
            tagList = it.getParcelableArrayList<TagData>(ARG_LIST) as ArrayList<TagData>
        } ?: run {
            tagList = ArrayList<TagData>()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tagRecyclerView = view.findViewById<RecyclerView>(R.id.tag_recycler_view)
        tagRecyclerView.layoutManager = LinearLayoutManager(this.context)

//
//        tagList = arrayListOf<TagData>(
//            TagData("Tag1"),
//            TagData("Tag2"),
//            TagData("Tag3"),
//            TagData("Tag4")
//        )

        this.context.let {
            val tagAdapter: TagAdapter = TagAdapter(it!!, tagList)
            tagRecyclerView.adapter = tagAdapter;
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TagFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TagFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FRAG, fragType)
                    putParcelableArrayList(ARG_LIST, tagList)
                }
            }
    }
}