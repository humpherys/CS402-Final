package com.example.cs402_final.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.R
import com.example.cs402_final.adapters.TagAdapter
import com.example.cs402_final.adapters.TagData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TagFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TagFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var tagRecyclerView: RecyclerView
    private lateinit var tagList: ArrayList<TagData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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

        //TODO: This needs to be removed once we get the db working
        tagList = arrayListOf<TagData>(
            TagData("Tag1"),
            TagData("Tag2"),
            TagData("Tag3"),
            TagData("Tag4")
        )

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
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}